package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.Barn;
import org.junit.Test;

public class BarnTest extends DomeneTestHelper {
    @Test
    public void validerBarn() throws NoSuchMethodException {
        validerEnkeltSegment(Barn.class);
    }
}
