package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBEP;
import org.junit.Test;

public class GRUNNBEPTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBEP() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBEP.class);
    }
}
