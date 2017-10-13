package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRBLEBBE;
import org.junit.Test;

public class GRBLEBBETest extends DomeneTestHelper {
    @Test
    public void validerGRBLEBBE() throws NoSuchMethodException {
        validerEnkeltSegment(GRBLEBBE.class);
    }
}
