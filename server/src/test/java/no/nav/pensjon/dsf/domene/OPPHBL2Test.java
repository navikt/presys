package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.OPPHBL2;
import org.junit.Test;

public class OPPHBL2Test extends DomeneTestHelper {
    @Test
    public void validerOPPHBL2() throws NoSuchMethodException {
        validerEnkeltSegment(OPPHBL2.class);
    }
}
