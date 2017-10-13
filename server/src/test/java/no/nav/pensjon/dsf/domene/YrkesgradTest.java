package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Yrkesgrad;
import org.junit.Test;

public class YrkesgradTest extends DomeneTestHelper {
    @Test
    public void validerYrkesgrad() throws NoSuchMethodException {
        validerEnkeltSegment(Yrkesgrad.class);
    }
}
