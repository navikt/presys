package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.EtterlattBarn;
import org.junit.Test;

/**
 * Created by K150562 on 09.06.2017.
 */
public class EtterlattBarnTest extends DomeneTest {
    @Test
    public void validerEtterlattBarn() throws NoSuchMethodException {
        validerEnkeltSegment(EtterlattBarn.class);
    }
}
