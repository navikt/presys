package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.YrkesskadeHistorikk;
import org.junit.Test;

public class YrkesskadeHistorikkTest extends DomeneTestHelper {
    @Test
    public void validerYrkesskadeHistorikk() throws NoSuchMethodException {
        validerEnkeltSegment(YrkesskadeHistorikk.class);
    }
}
