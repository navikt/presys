package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.GradsendringInnenforYrkesskadeperioden;
import org.junit.Test;

public class GradsendringInnenforYrkesskadeperiodenTest extends DomeneTestHelper {
    @Test
    public void validerGradsendringInnenforYrkesskadeperioden() throws NoSuchMethodException {
        validerEnkeltSegment(GradsendringInnenforYrkesskadeperioden.class);
    }
}
