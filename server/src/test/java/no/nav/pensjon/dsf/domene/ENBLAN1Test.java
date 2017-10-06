package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.ENBLAN1;
import org.junit.Test;

public class ENBLAN1Test extends DomeneTestHelper {
    @Test
    public void validerENBLAN1() throws NoSuchMethodException {
        validerEnkeltSegment(ENBLAN1.class);
    }
}
