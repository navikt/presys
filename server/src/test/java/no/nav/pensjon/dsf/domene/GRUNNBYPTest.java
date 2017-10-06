package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBYP;
import org.junit.Test;

public class GRUNNBYPTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBYP() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBYP.class);
    }
}
