package no.nav.pensjon.dsf.domene;

import org.junit.Test;

/**
 * Created by K150562 on 07.06.2017.
 */
public class TilknytningTest extends DomeneTest {

    @Test
    public void validerTilknytning() throws NoSuchMethodException {
        validerSegment(Tilknytning.class);
    }
}
