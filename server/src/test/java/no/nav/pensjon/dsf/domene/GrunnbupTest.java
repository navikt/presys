package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.Grunnbup;
import org.junit.Test;

public class GrunnbupTest extends DomeneTestHelper {
    @Test
    public void validerGrunnbup() throws NoSuchMethodException {
        validerEnkeltSegment(Grunnbup.class);
    }
}
