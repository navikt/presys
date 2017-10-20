package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.ForsorgingsTillegg;
import org.junit.Test;

public class ForsorgingsTilleggTest extends DomeneTestHelper {
    @Test
    public void validerForsorgingsTillegg() throws NoSuchMethodException {
        validerEnkeltSegment(ForsorgingsTillegg.class);
    }
}
