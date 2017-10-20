package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBA1;
import org.junit.Test;

public class GRUNNBA1Test extends DomeneTestHelper {
    @Test
    public void validerGRUNNBA1() throws NoSuchMethodException {
        validerEnkeltSegment(GRUNNBA1.class);
    }
}
