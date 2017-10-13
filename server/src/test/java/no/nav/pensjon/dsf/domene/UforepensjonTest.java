package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Uforepensjon;
import org.junit.Test;

public class UforepensjonTest extends DomeneTestHelper {
    @Test
    public void validerUforepensjon() throws NoSuchMethodException {
        validerEnkeltSegment(Uforepensjon.class);
    }
}
