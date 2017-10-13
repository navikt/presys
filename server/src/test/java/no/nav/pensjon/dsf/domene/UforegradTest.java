package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Uforegrad;
import org.junit.Test;

public class UforegradTest extends DomeneTestHelper {
    @Test
    public void validerUforegrad() throws NoSuchMethodException {
        validerEnkeltSegment(Uforegrad.class);
    }
}
