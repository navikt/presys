package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.Status;
import org.junit.Test;

public class StatusTest extends DomeneTestHelper {
    @Test
    public void validerStatus() throws NoSuchMethodException {
        validerEnkeltSegment(Status.class);
    }
}
