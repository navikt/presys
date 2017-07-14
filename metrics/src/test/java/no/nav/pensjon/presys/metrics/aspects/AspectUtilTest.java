package no.nav.pensjon.presys.metrics.aspects;

import mockit.Expectations;
import mockit.Mocked;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Test;

import static org.junit.Assert.*;

public class AspectUtilTest {

    @Mocked
    JoinPoint joinPoint;

    @Mocked
    Signature signature;

    @Test
    public void lagMetodeTimernavn() {
        settOppNavneMock(true);

        String generertNavn = AspectUtil.lagMetodeTimernavn(joinPoint, "", true);
        String customNavn = AspectUtil.lagMetodeTimernavn(joinPoint, "customNavn", true);

        assertEquals("AspectUtilTest.metode1", generertNavn);
        assertEquals("customNavn", customNavn);
    }

    @Test
    public void lagKlasseTimernavn() {
        settOppNavneMock(true);

        String generertNavn = AspectUtil.lagKlasseTimernavn(joinPoint, "", true);
        String customNavn = AspectUtil.lagKlasseTimernavn(joinPoint, "customNavn", true);

        assertEquals("AspectUtilTest.metode1", generertNavn);
        assertEquals("customNavn.metode1", customNavn);
    }
/*
    @Test
    public void lagMetodeTimernavnUtenUniqueMeasurement() {
        settOppNavneMock(false);

        String generertNavn = AspectUtil.lagMetodeTimernavn(joinPoint, "", false);
        String customNavn = AspectUtil.lagMetodeTimernavn(joinPoint, "customNavn", false);

        assertEquals("AspectUtilTest", generertNavn);
        assertEquals("customNavn", customNavn);
    }

    @Test
    public void lagKlasseTimernavnUtenUniqueMeasurement() {
        settOppNavneMock(false);

        String generertNavn = AspectUtil.lagKlasseTimernavn(joinPoint, "", false);
        String customNavn = AspectUtil.lagKlasseTimernavn(joinPoint, "customNavn", false);

        assertEquals("AspectUtilTest", generertNavn);
        assertEquals("customNavn", customNavn);
    }*/

    @Test
    public void metodeSkalIgnoreres() {
        String[] ignorerteMetoder = new String[]{"metode1", "metode2"};

        assertTrue(AspectUtil.metodeSkalIgnoreres("metode1", ignorerteMetoder));
        assertTrue(AspectUtil.metodeSkalIgnoreres("metode2", ignorerteMetoder));

        assertTrue(AspectUtil.metodeSkalIgnoreres("toString", ignorerteMetoder));
        assertTrue(AspectUtil.metodeSkalIgnoreres("hashCode", ignorerteMetoder));
        assertTrue(AspectUtil.metodeSkalIgnoreres("equals", ignorerteMetoder));

        assertFalse(AspectUtil.metodeSkalIgnoreres("metode3", ignorerteMetoder));
        assertFalse(AspectUtil.metodeSkalIgnoreres("metode4", ignorerteMetoder));
    }

    private void settOppNavneMock(boolean medUniqueMeasurements) {
        //if(medUniqueMeasurements) {
            new Expectations() {{
                signature.getDeclaringType();
                result = AspectUtilTest.class; // Bare for å ha noe
                signature.getName();
                result = "metode1";
                joinPoint.getSignature();
                result = signature;
            }};
        /*} else {
            new Expectations() {{
                signature.getDeclaringType();
                result = AspectUtilTest.class; // Bare for å ha noe
                joinPoint.getSignature();
                result = signature;
            }};
        }*/

    }
}