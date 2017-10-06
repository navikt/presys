package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBFO;
import org.junit.Test;

public class GRUNNBFOTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBFO() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBFO.class);
    }
}
