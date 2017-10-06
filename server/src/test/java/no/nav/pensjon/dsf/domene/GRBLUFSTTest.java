package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRBLUFST;
import org.junit.Test;

public class GRBLUFSTTest extends DomeneTestHelper {
    @Test
    public void validerGRBLUFST() throws NoSuchMethodException {
        validerEnkeltSegment(GRBLUFST.class);
    }
}
