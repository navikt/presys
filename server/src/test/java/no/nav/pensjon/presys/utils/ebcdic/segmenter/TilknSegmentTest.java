package no.nav.pensjon.presys.utils.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.status.Tilknytning;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.junit.Test;

import java.io.DataInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by K150562 on 07.06.2017.
 */
public class TilknSegmentTest {

    @Test
    public void readTilknytningSegment() throws Exception {
        DataInputStream isTilkn = new DataInputStream(TilknSegmentTest.class.getClassLoader().getResourceAsStream("tilkn.txt"));

        byte[] file = new byte[44];

        isTilkn.readFully(file);
        Tilknytning tilknytning = AnnotationMapper.les(new ScrollableArray(file), Tilknytning.class);
        assertThat(tilknytning.getFnr(), is("06037300045"));
        assertThat(tilknytning.getTilknytningskode(), is("D"));
        assertThat(tilknytning.getFt_fr_91(), is(""));
    }
}
