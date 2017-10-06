package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.ENDRBLAN;
import org.junit.Test;

public class ENDRBLANTest extends DomeneTestHelper {
    @Test
    public void validerENDRBLAN() throws NoSuchMethodException {
        validerEnkeltSegment(ENDRBLAN.class);
    }
}
