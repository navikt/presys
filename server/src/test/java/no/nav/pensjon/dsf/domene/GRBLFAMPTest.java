package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRBLFAMP;
import org.junit.Test;

public class GRBLFAMPTest extends DomeneTestHelper {
    @Test
    public void validerGRBLFAMP() throws NoSuchMethodException {
        validerEnkeltSegment(GRBLFAMP.class);
    }
}
