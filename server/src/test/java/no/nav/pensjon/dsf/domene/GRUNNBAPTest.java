package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBAP;
import org.junit.Test;

public class GRUNNBAPTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBAP() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBAP.class);
    }
}
