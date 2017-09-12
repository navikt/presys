package no.nav.pensjon.dsf.domene;

import org.junit.Test;

/**
 * Created by K150562 on 08.06.2017.
 */
public class TilberpoTest extends DomeneTestHelper {

    @Test
    public void validerTilberpo() throws NoSuchMethodException {
        validerEnkeltSegment(Tilberpo.class);
    }
}
