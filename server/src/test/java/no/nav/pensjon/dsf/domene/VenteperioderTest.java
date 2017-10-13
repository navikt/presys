package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Venteperioder;
import org.junit.Test;

public class VenteperioderTest extends DomeneTestHelper {
    @Test
    public void validerVenteperioder() throws NoSuchMethodException {
        validerEnkeltSegment(Venteperioder.class);
    }
}
