package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.EtterlattBarn;
import org.junit.Test;

public class EtterlattBarnTest extends DomeneTestHelper {
    @Test
    public void validerEtterlattBarn() throws NoSuchMethodException {
        validerEnkeltSegment(EtterlattBarn.class);
    }
}
