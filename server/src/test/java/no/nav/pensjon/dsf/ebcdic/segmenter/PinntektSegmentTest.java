package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.ebcdic.ScrollableArray;
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
        Inntekt inntekt = inntektssegment.readSegment(new ScrollableArray(file));
        assertThat(inntekt.getKommune(), is("00623"));

    }

    @Test
    public void acceptsInntektsSegment() throws IOException {
        DataInputStream isPinntekt = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("pinntekt.txt"));

        Segment<Inntekt> inntektssegment = new PinntektSegment();
        byte[] file = new byte[56];
        isPinntekt.readFully(file);
        assertThat(inntektssegment.accept(new ScrollableArray(file)), is(true));

    }
}
