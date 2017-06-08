package no.nav.pensjon.presys.utils.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Alderspensjon;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.junit.Test;

import java.io.DataInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by K150562 on 08.06.2017.
 */
public class AlderspSegmentTest {

    @Test
    public void readTilknytningSegment() throws Exception {
        DataInputStream isTilkn = new DataInputStream(AlderspSegmentTest.class.getClassLoader().getResourceAsStream("aldersp.txt"));

        byte[] file = new byte[178];

        isTilkn.readFully(file);
        Alderspensjon alderspensjon = AnnotationMapper.les(new ScrollableArray(file), Alderspensjon.class);
        assertThat(alderspensjon.getGrunnpensjon(), is("04898"));
        assertThat(alderspensjon.getSaertillegg(), is("00307"));
        assertThat(alderspensjon.getTilleggspensjon(), is("03553"));
        assertThat(alderspensjon.getSluttpoengtall(), is("2.48"));
        assertThat(alderspensjon.getOverkompensasjonPoengtall(), is("3.41"));
        assertThat(alderspensjon.getPoengaar(), is("013"));
    }
}
