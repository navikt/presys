package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;

/**
 * Superklasse for alle domenetestene.
 * Created by K150562 on 07.06.2017.
 */
public class DomeneTestHelper {

    /**
     * Validerer at domene-entity, med felter, gettere og settere er satt rett.
     * Alle definerte undersegmenter blir også validert
     *
     * @param clazz Domene-entity som valideres
     * @throws NoSuchMethodException Kastes om en get/set'er ikke er satt
     */
    void validerSegmentHierarkisk(Class<?> clazz) throws NoSuchMethodException {
        validerSegment(clazz, true);
    }

    /**
     * Validerer at domene-entity, med felter, gettere og settere er satt rett.
     * Definerte undersegmenter blir ignoreres
     *
     * @param clazz Domene-entity som valideres
     * @throws NoSuchMethodException Kastes om en get/set'er ikke er satt
     */
    void validerEnkeltSegment(Class<?> clazz) throws NoSuchMethodException {
        validerSegment(clazz, false);
    }

    private void validerSegment(Class<?> clazz, boolean validerUndersegment) throws NoSuchMethodException {

        Segment seg = clazz.getAnnotation(Segment.class);
        clazz.getConstructor();
        assertThat("Segmentnavn må være 8 tegn. Dette segmentet har lengre navn: "+ clazz.getSimpleName(), seg.name().length(), is(8));

        int[] fields = new int[seg.length()];

        for (Field f: clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(Felt.class)) {
                hasSetter(f);
                Felt feltannotasjon = f.getAnnotation(Felt.class);
                for (int i = 0; i < feltannotasjon.length(); i++) {
                    fields[i + feltannotasjon.start()]++;
                }
            } else if (f.isAnnotationPresent(SubSegment.class)) {
                ParameterizedType subType = (ParameterizedType) f.getGenericType();
                Class<?> subTypeClass = (Class<?>) subType.getActualTypeArguments()[0];
                String getterName = "get" + String.valueOf(f.getName().charAt(0)).toUpperCase() + f.getName().substring(1);
                f.getDeclaringClass().getMethod(getterName).getReturnType().equals(List.class);
                if(validerUndersegment) {
                    validerSegment(subTypeClass, true);
                }
            }
        }
        if (clazz.isAnnotationPresent(UnmappedFields.class)) {
            UnmappedFields umfs = clazz.getAnnotation(UnmappedFields.class);
            for (UnmappedField umf : umfs.value()) {
                for (int i = 0; i < umf.length(); i++) {
                    fields[i + umf.start()]++;
                }
            }
        }
        if (clazz.isAnnotationPresent(UnmappedField.class)) {
            UnmappedField umf = clazz.getAnnotation(UnmappedField.class);
            for (int i = 0; i < umf.length(); i++) {
                try {
                    fields[i + umf.start()]++;
                }catch (ArrayIndexOutOfBoundsException e){
                    throw new RuntimeException(clazz.getSimpleName(), e);
                }
            }
        }

        for (int i = 0; i < fields.length ; i++){
            assertThat("Overlappende felt i segment " + clazz.getSimpleName() + ";" + i,  fields[i], is(lessThan(2)));
            assertThat("Manglende felt i segment " + clazz.getSimpleName() + ";" + i,  fields[i], is(not(0)));
        }
    }
    private void hasSetter(Field f) throws NoSuchMethodException {
        String setterName = "set" + String.valueOf(f.getName().charAt(0)).toUpperCase() + f.getName().substring(1);
        f.getDeclaringClass().getMethod(setterName, f.getType());
    }
}
