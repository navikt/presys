package no.nav.pensjon.dsf.domene;

import org.junit.Test;

/**
 * Created by K150562 on 12.06.2017.
 */
public class EtterlattEktefelleTest extends DomeneTest {

    @Test
    public void validerEtterlattEktefelle() throws NoSuchMethodException {
        validerEnkeltSegment(EtterlattEktefelle.class);
    }
}
