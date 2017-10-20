package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.UforeHistorikk;
import org.junit.Test;

public class UforeHistorikkTest extends DomeneTestHelper {
    @Test
    public void validerUforeHistorikk() throws NoSuchMethodException {
        validerEnkeltSegment(UforeHistorikk.class);
    }
}
