package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBIF;
import org.junit.Test;

public class GRUNNBIFTest extends DomeneTestHelper {
    @Test
    public void validerGRUNNBIF() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBIF.class);
    }
}
