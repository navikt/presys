package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Tilknytning;
import org.junit.Test;

/**
 * Created by K150562 on 07.06.2017.
 */
public class TilknytningTest extends DomeneTest {

    @Test
    public void validerTilknytning() throws NoSuchMethodException {
        validerEnkeltSegment(Tilknytning.class);
    }
}
