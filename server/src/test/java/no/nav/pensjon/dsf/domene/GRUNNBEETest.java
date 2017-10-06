package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBEE;
import org.junit.Test;

public class GRUNNBEETest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBEE() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBEE.class);
    }
}
