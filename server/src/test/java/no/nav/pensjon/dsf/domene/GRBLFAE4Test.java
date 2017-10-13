package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRBLFAE4;
import org.junit.Test;

public class GRBLFAE4Test extends DomeneTestHelper {
    @Test
    public void validerGRBLFAE4() throws NoSuchMethodException {
        validerEnkeltSegment(GRBLFAE4.class);
    }
}
