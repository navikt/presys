package no.nav.pensjon.presys.utils.ebcdic;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.SubSegment;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnnotationMapper {


    public static <E> E mapData(byte[] values, Class<E> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        E o = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Felt.class)) {
                Felt ta = f.getAnnotation(Felt.class);
                Object valueToSet = null;
                byte[] feltData = Arrays.copyOfRange(values, ta.start(), ta.start() + ta.length());
                if (f.isAnnotationPresent(PackedDecimal.class)) {
                    PackedDecimal pda = f.getAnnotation(PackedDecimal.class);
                    int unpackedWith = (ta.length() * 2) - 1;
                    BigDecimal unpacked = EbcdicUtils.unpack(feltData, unpackedWith, pda.decimals());
                    if (f.getType().equals(String.class)) {
                        valueToSet = padLeft(unpacked.toString(), unpackedWith, "0");
                    } else if (f.getType().equals(Integer.TYPE)) {
                        valueToSet = unpacked.intValue();
                    }
                } else if (f.getType().equals(String.class)) {
                    valueToSet = EbcdicUtils.getString(feltData);
                } else if (f.getType().equals(Integer.TYPE)) {
                    valueToSet = ByteBuffer.wrap(feltData).getShort();
                }
                if(valueToSet != null) {
                    getSetter(f).invoke(o, valueToSet);
                }
            }
        }
        return o;
    }


    static void writeSegment(Object o, OutputStream os) throws IOException, InvocationTargetException, IllegalAccessException {
        Meta m = new Meta();
        m.setMetalengde(Meta.META_SIZE);

        Segment seg = o.getClass().getAnnotation(Segment.class);
        m.setDatalengde(seg.length());
        m.setSegmentNavn(seg.name());

        os.write(asByte(m));
        os.write(asByte(o));
        if((m.metalengde + m.datalengde) % 2 == 1){
            os.write(0);
        }

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(SubSegment.class)) {
                List<Object> segments =  (List<Object>) getGetter(f).invoke(o);
                for(Object segment : segments){
                    writeSegment(segment, os);
                }
            }
        }
    }

    static byte[] asByte(Object o) throws InvocationTargetException, IllegalAccessException, UnsupportedEncodingException {
        Segment seg = o.getClass().getAnnotation(Segment.class);
        byte[] segmentBytes = new byte[seg.length()];
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Felt.class)) {
                Felt ta = f.getAnnotation(Felt.class);

                byte[] feltData = new byte[ta.length()];

                if (f.isAnnotationPresent(PackedDecimal.class)) {
                    if (f.getType().equals(String.class)) {
                        feltData =  EbcdicUtils.pack(new BigDecimal(Double.parseDouble(getGetter(f).invoke(o).toString())), ta.length() * 2 - 1);

                    } else if (f.getType().equals(Integer.TYPE)) {
                        feltData =  EbcdicUtils.pack(new BigDecimal((int) getGetter(f).invoke(o)), ta.length() * 2 - 1);
                    }
                } else if (f.getType().equals(String.class)) {
                    byte[] tmp = getGetter(f).invoke(o).toString().getBytes(EbcdicUtils.EBCDIC_CHARSET);
                    for(int i = 0; i<feltData.length && i< tmp.length;i++){
                        feltData[i] = tmp[i];
                    }
                } else if (f.getType().equals(Integer.TYPE)) {
                    ByteBuffer buf = ByteBuffer.allocate(2);
                    int tmp = (int)getGetter(f).invoke(o);
                    buf.putShort((short)tmp);
                    feltData = buf.array();
                }
                for(int i = 0; i< feltData.length; i++){

                    segmentBytes[i+ta.start()] = feltData[i];
                }
            }
        }

        return segmentBytes;
    }

    private static Method getGetter(Field f) {
        String getterName = "get" + String.valueOf(f.getName().charAt(0)).toUpperCase() + f.getName().substring(1);
        try {
            return f.getDeclaringClass().getMethod(getterName);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Fant ikke getter for felt " + f.getName() +  "på segment "  + f.getDeclaringClass().getSimpleName(), e);
        }
    }

    private static String padLeft(String oldString, int newLength, String padding){
        while(oldString.length()<newLength){
            oldString = padding+oldString;
        }
        return oldString;
    }

    private static Method getSetter(Field f) {
        String setterName = "set" + String.valueOf(f.getName().charAt(0)).toUpperCase() + f.getName().substring(1);
        try {
            return f.getDeclaringClass().getMethod(setterName, f.getType());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Fant ikke setter for felt " + f.getName() +  "på segment "  + f.getDeclaringClass().getSimpleName(), e);
        }
    }

    public static Meta lesMetadata(ScrollableArray data, boolean consume) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return consume ? mapData(data.read(Meta.META_SIZE), Meta.class):mapData(data.peekAhead(0, Meta.META_SIZE), Meta.class);
    }

    public static <T> T les(ScrollableArray data, Class<T> segmentToMap) throws Exception {

        Meta m = lesMetadata(data, true);
        T o = mapData(data.read(m.getDatalengde()), segmentToMap);
        Segment seg = segmentToMap.getAnnotation(Segment.class);
        if(seg.length() != m.getDatalengde()){
            System.out.println("Avvik på datalengde i Segment:" + seg.name() + ". Metadata:" + m.getDatalengde() + " Segmentbeskrivelse:" + seg.length());
        }

        if((m.metalengde + m.datalengde) % 2 == 1){
            data.read(1);
        }

        List<Class<?>> subSegments = Arrays.stream(segmentToMap.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(SubSegment.class))
                .map(f -> (ParameterizedType) f.getGenericType())
                .map(f -> (Class<?>) f.getActualTypeArguments()[0])
                .collect(Collectors.toList());

        if(subSegments.isEmpty()){
            return o;
        }

        while (data.bytesLeft() > Meta.META_SIZE) {
            Meta mNext = lesMetadata(data, false);
            Optional<Class<?>> nextClass = subSegments.stream()
                    .filter(subseg -> subseg.getAnnotation(Segment.class).name().equals(mNext.getSegmentNavn())).findAny();
            if (!nextClass.isPresent()){
                System.out.println(m.getSegmentNavn() + ": Next segment is " + mNext.getSegmentNavn()  );
                break;
            }

            Field[] fields = segmentToMap.getDeclaredFields();

            for (Field f : fields) {
                if (f.isAnnotationPresent(SubSegment.class) && f.getType().equals(List.class)) {
                    ParameterizedType subType = (ParameterizedType) f.getGenericType();
                    Class<?> subTypeClass = (Class<?>) subType.getActualTypeArguments()[0];
                    if (nextClass.get().equals(subTypeClass)) {
                        String getterName = "get" + String.valueOf(f.getName().charAt(0)).toUpperCase() + f.getName().substring(1);
                        List l = (List) f.getDeclaringClass().getMethod(getterName).invoke(o);
                        l.add(les(data, nextClass.get()));
                    }
                }
            }
        }
        return o;

    }


}
