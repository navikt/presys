package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBAF;
import org.junit.Test;

public class GRUNNBAFTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBAF() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBAF.class);
    }
}
