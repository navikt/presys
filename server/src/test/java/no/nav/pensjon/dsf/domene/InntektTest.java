package no.nav.pensjon.dsf.domene;

import org.junit.Test;

public class InntektTest extends DomeneTestHelper {
    @Test
    public void validerInntekt() throws NoSuchMethodException {
        validerEnkeltSegment(Inntekt.class);
    }
}
