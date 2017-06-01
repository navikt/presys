package no.nav.pensjon.presys.utils.ebcdic;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.SubSegment;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnnotationMapper {


    public static <E> E mapData(byte[] values, Class<E> clazz) throws Exception {
        E o = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Felt.class)) {
                Felt ta = f.getAnnotation(Felt.class);

                byte[] feltData = Arrays.copyOfRange(values, ta.start(), ta.start() + ta.length());
                if (f.isAnnotationPresent(PackedDecimal.class)) {
                    if (f.getType().equals(String.class)) {
                        int unpackedWith = (ta.length() * 2) - 1;
                        String unpadded = EbcdicUtils.deCompress(feltData, unpackedWith, 0);
                        getSetter(f).invoke(o, padLeft(unpadded, unpackedWith, "0"));
                    } else if (f.getType().equals(Integer.TYPE)) {
                        getSetter(f).invoke(o, EbcdicUtils.unPack(feltData, (ta.length() * 2) - 1, 0).intValue());
                    }
                } else if (f.getType().equals(String.class)) {
                    getSetter(f).invoke(o, EbcdicUtils.getString(feltData));
                } else if (f.getType().equals(Integer.TYPE)) {
                    getSetter(f).invoke(o, ByteBuffer.wrap(feltData).getShort());
                }
            }
        }
        return o;
    }

    private static String padLeft(String oldString, int newLength, String padding){
        while(oldString.length()<newLength){
            oldString = padding+oldString;
        }
        return oldString;
    }

    private static Method getSetter(Field f) throws Exception {
        String setterName = "set" + String.valueOf(f.getName().charAt(0)).toUpperCase() + f.getName().substring(1);
        return f.getDeclaringClass().getMethod(setterName, f.getType());
    }

    public static Meta lesMetadata(ScrollableArray data, boolean consume) throws Exception {
        return consume ? mapData(data.read(Meta.META_SIZE), Meta.class):mapData(data.peekAhead(0, Meta.META_SIZE), Meta.class);
    }

    public static <T> T les(ScrollableArray data, Class<T> segmentToMap) throws Exception {
        Meta m = lesMetadata(data, true);
        T o = mapData(data.read(m.getDatalengde()), segmentToMap);
        data.read(1);

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
                    .filter(seg -> seg.getAnnotation(Segment.class).name().equals(mNext.getSegmentNavn())).findAny();
            if (!nextClass.isPresent()) break;

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
