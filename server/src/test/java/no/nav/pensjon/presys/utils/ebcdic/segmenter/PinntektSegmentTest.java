package no.nav.pensjon.presys.utils.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


import java.io.DataInputStream;


public class PinntektSegmentTest {

    @Test
    public void readInntektsSegment() throws Exception {
        DataInputStream isPinntekt = new DataInputStream(PinntektSegmentTest.class.getClassLoader().getResourceAsStream("pinntekt.txt"));

        byte[] file = new byte[56];

        isPinntekt.readFully(file);
        Inntekt inntekt = AnnotationMapper.les(new ScrollableArray(file), Inntekt.class);
        assertThat(inntekt.getKommune(), is("00623"));

    }


    @Test
    public void readInntektsSegment2() throws Exception {
        DataInputStream isPinntekt = new DataInputStream(PinntektSegmentTest.class.getClassLoader().getResourceAsStream("database/02093847140.txt"));

        byte[] file = new byte[4006];
        isPinntekt.readFully(file);


        Person i = AnnotationMapper.les(new ScrollableArray(file), Person.class);
        System.out.println(i.getFnr());
        System.out.println(i.getInntekter().size());
        System.out.println(i.getEtteroppgjor().size());





    }
}
