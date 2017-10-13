package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Alderspensjon;
import org.junit.Test;

public class AlderspensjonTest extends DomeneTestHelper {
    @Test
    public void validerAlderspensjon() throws NoSuchMethodException {
        validerEnkeltSegment(Alderspensjon.class);
    }
}
