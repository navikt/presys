package no.nav.pensjon.presys.utils.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Tilberpo;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.junit.Test;

import java.io.DataInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by K150562 on 08.06.2017.
 */
public class TilberpoSegmentTest {

    @Test
    public void readTilberpoSegment() throws Exception {
        DataInputStream isTilkn = new DataInputStream(TilknSegmentTest.class.getClassLoader().getResourceAsStream("tilberpo.txt"));

        byte[] file = new byte[64];

        isTilkn.readFully(file);
        Tilberpo tilberpo = AnnotationMapper.les(new ScrollableArray(file), Tilberpo.class);
        assertThat(tilberpo.getVernepliktaar1(), is(1991));
        assertThat(tilberpo.getVernepliktaar2(), is(1992));
        assertThat(tilberpo.getVernepliktaar3(), is(1993));
        assertThat(tilberpo.getVernepliktaar4(), is(1994));
        assertThat(tilberpo.getAi63(), is(80));
        assertThat(tilberpo.getAi64(), is(79));
        assertThat(tilberpo.getAi65(), is(83));
        assertThat(tilberpo.getAi66(), is(105));
        assertThat(tilberpo.getPi66(), is(115));
    }
}
