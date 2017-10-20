package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBKF;
import org.junit.Test;

public class GRUNNBKFTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBKF() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBKF.class);
    }
}
