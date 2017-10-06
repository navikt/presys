package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.SpesielleOpplysninger;
import org.junit.Test;

public class SpesielleOpplysningerTest extends DomeneTestHelper {
    @Test
    public void validerSpesielleOpplysninger() throws NoSuchMethodException {
        validerEnkeltSegment(SpesielleOpplysninger.class);
    }
}
