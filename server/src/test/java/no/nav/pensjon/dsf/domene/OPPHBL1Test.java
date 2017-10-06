package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.OPPHBL1;
import org.junit.Test;

public class OPPHBL1Test extends DomeneTestHelper {
    @Test
    public void validerOPPHBL1() throws NoSuchMethodException {
        validerEnkeltSegment(OPPHBL1.class);
    }
}
