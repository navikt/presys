package no.nav.pensjon.dsf.domene;


import no.nav.pensjon.presys.utils.ebcdic.annotations.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class PersonTest {


    @Test
    public void validerPerson() throws NoSuchMethodException {
        validerSegment(Person.class);
    }


    public void validerSegment(Class<?> clazz) throws NoSuchMethodException {

        Segment seg = clazz.getAnnotation(Segment.class);
        clazz.getConstructor();
        assertThat(seg.name().length(), is(8));

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
                validerSegment(subTypeClass);
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
                fields[i + umf.start()]++;
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
