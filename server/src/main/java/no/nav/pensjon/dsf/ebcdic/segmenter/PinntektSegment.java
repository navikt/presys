package no.nav.pensjon.dsf.ebcdic.segmenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d132988 on 11.04.2017.
 */
public class PinntektSegment extends Segment<Inntekt> {

    private static List<Felt> felter = new ArrayList<>();
 /*   byte[] start = er.read(isPinntekt, 6);
    byte[] segmentNavn = er.read(isPinntekt, 8);
            er.read(isPinntekt, 19);
    byte[] ukjent1 = er.read(isPinntekt, 2);
    byte[] pi_aar = er.read(isPinntekt, 3);
    byte[] pi_type = er.read(isPinntekt, 1);
    byte[] pi_merke = er.read(isPinntekt, 1);
    byte[] pi = er.read(isPinntekt, 5);
    byte[] kommune = er.read(isPinntekt, 3);
    byte[] rappdato = er.read(isPinntekt, 4);
    byte[] reserve = er.read(isPinntekt, 4);*/

    static {
        felter.add(new Felt("start", 6, false, 6));
        felter.add(new Felt("pi_aar", 3, true, 5));

    }

    @Override
    public String getNavn() {
        return "PINNTEKT";
    }

    @Override
    public Inntekt readSegment(byte[] data) {

        return null;
    }


}
