package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRBLEBEN;
import org.junit.Test;

public class GRBLEBENTest extends DomeneTestHelper {
    @Test
    public void validerGRBLEBEN() throws NoSuchMethodException {
        validerEnkeltSegment(GRBLEBEN.class);
    }
}
