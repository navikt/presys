package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRBLEBB6;
import org.junit.Test;

public class GRBLEBB6Test extends DomeneTestHelper {
    @Test
    public void validerGRBLEBB6() throws NoSuchMethodException {
        validerEnkeltSegment(GRBLEBB6.class);
    }
}
