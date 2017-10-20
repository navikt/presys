package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBU3;
import org.junit.Test;

public class GRUNNBU3Test extends DomeneTestHelper {
    @Test
    public void validerGRUNNBU3() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBU3.class);
    }
}
