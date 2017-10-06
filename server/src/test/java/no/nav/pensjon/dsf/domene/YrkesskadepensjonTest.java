package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Yrkesskadepensjon;
import org.junit.Test;

public class YrkesskadepensjonTest extends DomeneTestHelper {
    @Test
    public void validerYrkesskadepensjon() throws NoSuchMethodException {
        validerEnkeltSegment(Yrkesskadepensjon.class);
    }
}
