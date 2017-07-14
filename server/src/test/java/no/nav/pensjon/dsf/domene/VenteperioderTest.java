package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Venteperioder;
import org.junit.Test;

/**
 * Created by K150562 on 13.06.2017.
 */
public class VenteperioderTest extends DomeneTest {

    @Test
    public void validerVenteperioder() throws NoSuchMethodException {
        validerEnkeltSegment(Venteperioder.class);
    }
}
