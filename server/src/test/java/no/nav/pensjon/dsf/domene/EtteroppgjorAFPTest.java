package no.nav.pensjon.dsf.domene;

import org.junit.Test;

public class EtteroppgjorAFPTest extends DomeneTestHelper {
    @Test
    public void validerEtteroppgjorAFP() throws NoSuchMethodException {
        validerEnkeltSegment(EtteroppgjorAFP.class);
    }
}
