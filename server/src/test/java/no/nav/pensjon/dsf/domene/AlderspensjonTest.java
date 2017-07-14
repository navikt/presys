package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Alderspensjon;
import org.junit.Test;

/**
 * Created by K150562 on 08.06.2017.
 */
public class AlderspensjonTest extends DomeneTest {

    @Test
    public void validerAlderspensjon() throws NoSuchMethodException {
        validerEnkeltSegment(Alderspensjon.class);
    }
}
