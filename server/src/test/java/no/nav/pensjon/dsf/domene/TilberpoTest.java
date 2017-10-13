package no.nav.pensjon.dsf.domene;

import org.junit.Test;

public class TilberpoTest extends DomeneTestHelper {
    @Test
    public void validerTilberpo() throws NoSuchMethodException {
        validerEnkeltSegment(Tilberpo.class);
    }
}
