package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBUF;
import org.junit.Test;

public class GRUNNBUFTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBUF() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBUF.class);
    }
}
