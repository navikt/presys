package no.nav.pensjon.dsf.domene;

import org.junit.Test;

/**
 * Created by K150562 on 08.06.2017.
 */
public class TilberpoTest extends DomeneTest {

    @Test
    public void validerTilberpo() throws NoSuchMethodException {
        validerSegment(Tilberpo.class);
    }
}
