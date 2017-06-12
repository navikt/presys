package no.nav.pensjon.presys.utils.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.EtterlattEktefelle;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.junit.Test;

import java.io.DataInputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by K150562 on 12.06.2017.
 */
public class EtterlattEktefelleSegmentTest {

    @Test
    public void readEtterlattEktefelleSegment () throws Exception {
        DataInputStream isEttepens = new DataInputStream(EtterlattEktefelleSegmentTest.class.getClassLoader().getResourceAsStream("ettepens.txt"));

        byte[] file = new byte[98];

        isEttepens.readFully(file);
        EtterlattEktefelle etterlattEktefelle = AnnotationMapper.les(new ScrollableArray(file), EtterlattEktefelle.class);
        assertThat(etterlattEktefelle.getOmsorgAvdBa(), is("N"));
        assertThat(etterlattEktefelle.getVilkaar_10_5(), is("J"));
        assertThat(etterlattEktefelle.getHjemmel_10_8(), is("O"));
        assertThat(etterlattEktefelle.getGpBrutto(), is(2533));
        assertThat(etterlattEktefelle.getGpNetto(), is(876));
        assertThat(etterlattEktefelle.getSt(), is(1230));
        assertThat(etterlattEktefelle.getKt(), is(15));
        assertThat(etterlattEktefelle.getTpBrutto(), is(1447));
        assertThat(etterlattEktefelle.getTpNetto(), is(501));
        assertThat(etterlattEktefelle.getSptAvd(), is("5.23"));
        assertThat(etterlattEktefelle.getOptAvd(), is("4.00"));
        assertThat(etterlattEktefelle.getPaaAvd(), is(10));
        assertThat(etterlattEktefelle.getTpProsent(), is(120));
        assertThat(etterlattEktefelle.getForventet(), is(933));
        assertThat(etterlattEktefelle.getStiAMD(), is("019980110"));
        assertThat(etterlattEktefelle.getStBrutto(), is(1230));
        assertThat(etterlattEktefelle.getFradrag2G(), is("T"));
    }
}
