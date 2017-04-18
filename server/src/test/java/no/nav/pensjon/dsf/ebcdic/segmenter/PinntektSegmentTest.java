package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.web.EbcdicReader;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


import java.io.DataInputStream;
import java.io.IOException;


public class PinntektSegmentTest {

    @Test
    public void readInntektsSegment() throws IOException {
        DataInputStream isPinntekt = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("pinntekt.txt"));

        Segment<Inntekt> inntektssegment = new PinntektSegment();
        byte[] file = new byte[56];
        isPinntekt.readFully(file);
        Inntekt inntekt = inntektssegment.readSegment(file);
        assertThat(inntekt.getKommune(), is("623"));

    }
}
