package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNEES;
import org.junit.Test;

public class GRUNNEESTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNEES() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNEES.class);
    }
}
