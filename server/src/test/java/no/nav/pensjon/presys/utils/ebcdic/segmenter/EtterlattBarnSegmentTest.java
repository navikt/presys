package no.nav.pensjon.presys.utils.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.status.EtterlattBarn;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.junit.Test;

import java.io.DataInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by K150562 on 09.06.2017.
 */
public class EtterlattBarnSegmentTest {

    @Test
    public void readEtterlattBarnSegment() throws Exception {
        DataInputStream isEttebarn = new DataInputStream(AlderspSegmentTest.class.getClassLoader().getResourceAsStream("ettebarn.txt"));

        byte[] file = new byte[86];

        isEttebarn.readFully(file);
        EtterlattBarn etterlattBarn = AnnotationMapper.les(new ScrollableArray(file), EtterlattBarn.class);
        assertThat(etterlattBarn.getPensjonEtter(), is("T"));
        assertThat(etterlattBarn.getGp(), is(1234));
        assertThat(etterlattBarn.getTp(), is(98765));
        assertThat(etterlattBarn.getSt(), is(43210));
        assertThat(etterlattBarn.getKt(), is(1010));
        assertThat(etterlattBarn.getSptMor(), is("2.00"));
        assertThat(etterlattBarn.getOptMor(), is("1.01"));
        assertThat(etterlattBarn.getPaaMor(), is(12));
        assertThat(etterlattBarn.getSptFar(), is("3.45"));
        assertThat(etterlattBarn.getOptFar(), is("6.78"));
        assertThat(etterlattBarn.getPaaFar(), is(901));
    }
}
