package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.status.EtterlattEktefelle;
import org.junit.Test;

public class EtterlattEktefelleTest extends DomeneTestHelper {
    @Test
    public void validerEtterlattEktefelle() throws NoSuchMethodException {
        validerEnkeltSegment(EtterlattEktefelle.class);
    }
}
