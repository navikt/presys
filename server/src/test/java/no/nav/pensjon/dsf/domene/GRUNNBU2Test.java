package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBU2;
import org.junit.Test;

public class GRUNNBU2Test extends DomeneTestHelper {
    @Test
    public void validerGRUNNBU2() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBU2.class);
    }
}
