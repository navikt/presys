package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.AfpHistorikk;
import org.junit.Test;

public class AfpHistorikkTest extends DomeneTestHelper {
    @Test
    public void validerAfpHistorikk() throws NoSuchMethodException {
        validerEnkeltSegment(AfpHistorikk.class);
    }
}
