package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Tilknytning;
import org.junit.Test;

public class TilknytningTest extends DomeneTestHelper {
    @Test
    public void validerTilknytning() throws NoSuchMethodException {
        validerEnkeltSegment(Tilknytning.class);
    }
}
