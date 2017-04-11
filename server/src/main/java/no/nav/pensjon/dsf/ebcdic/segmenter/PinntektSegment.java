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
        felter.add(new Felt("segmentNavn", 8, false, 8));
        felter.add(new Felt("ukjent1", 21, false, 21));
        felter.add(new Felt("pi_aar", 3, true, 5));
        felter.add(new Felt("pi_type", 1, false, 1));
        felter.add(new Felt("pi_merke", 1, false, 1));
        felter.add(new Felt("pi", 5, true, 9));
        felter.add(new Felt("kommune", 3, true, 5));
        felter.add(new Felt("rappdato", 4, true, 7));
        felter.add(new Felt("reserve", 4, false, 4));
    }

    @Override
    public String getNavn() {
        return "PINNTEKT";
    }

    @Override
    public List<Felt> getFelter() {
        return felter;
    }

    @Override
    public Inntekt initDomene() {
        return new Inntekt();
    }

    @Override
    public void setFeltVerdi(Inntekt domene, Felt f,String verdi) {
        if (f.getFeltNavn().equals("pi_aar")){
            domene.setPersonInntektAar(Integer.parseInt(verdi));// lag datofelt (kanskje som dag 223 i 1973)
        } else if (f.getFeltNavn().equals("pi_type")){
            domene.setPersonInntektType((verdi));
        } else if (f.getFeltNavn().equals("pi_merke")){
            domene.setPersonInntektMerke((verdi));
        } else if (f.getFeltNavn().equals("pi")){
            domene.setPersonInntekt(Integer.parseInt(verdi));
        } else if (f.getFeltNavn().equals("kommune")){
            domene.setKommune((verdi));
        } else if (f.getFeltNavn().equals("rappdato")){
            domene.setRapporteringsDato(Integer.parseInt(verdi));
        }
    }


}
