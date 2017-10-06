package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBE3;
import org.junit.Test;

public class GRUNNBE3Test extends DomeneTestHelper {
    @Test
    public void validerGRUNNBE3() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBE3.class);
    }
}
