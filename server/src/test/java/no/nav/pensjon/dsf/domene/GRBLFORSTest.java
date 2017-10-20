package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRBLFORS;
import org.junit.Test;

public class GRBLFORSTest extends DomeneTestHelper {
    @Test
    public void validerGRBLFORS() throws NoSuchMethodException {
        validerEnkeltSegment(GRBLFORS.class);
    }
}
