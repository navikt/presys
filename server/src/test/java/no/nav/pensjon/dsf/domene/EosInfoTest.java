package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.EosInfo;
import org.junit.Test;

public class EosInfoTest extends DomeneTestHelper {
    @Test
    public void validerEosInfo() throws NoSuchMethodException {
        validerEnkeltSegment(EosInfo.class);
    }
}
