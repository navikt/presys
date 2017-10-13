package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.TranHist;
import org.junit.Test;

public class TranHistTest extends DomeneTestHelper {
    @Test
    public void validerTranHist() throws NoSuchMethodException {
        validerEnkeltSegment(TranHist.class);
    }
}
