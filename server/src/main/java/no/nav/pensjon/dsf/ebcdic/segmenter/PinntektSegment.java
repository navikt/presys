package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Inntekt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static no.nav.pensjon.dsf.ebcdic.segmenter.Characters.plaintext;
import static no.nav.pensjon.dsf.ebcdic.segmenter.PackedDecimal.pakketHeltall;
import static no.nav.pensjon.dsf.ebcdic.segmenter.PackedDecimal.pakketTekst;
import static no.nav.pensjon.dsf.ebcdic.segmenter.SegmentNavnFelt.segmentNavn;

public class PinntektSegment extends Segment<Inntekt> {

    private List<Felt<Inntekt>> felter = new ArrayList<>();

    PinntektSegment() {
        BiConsumer<Inntekt, String> settesIkke = (inntekt, verdi)-> {}; //Brukes for felter som ikke skal settes på domeneobjektet

        felter.add(plaintext("start", 6, settesIkke ));
        felter.add(segmentNavn());
        felter.add(plaintext("ukjent1", 21, settesIkke ));
        felter.add(pakketHeltall("pi_aar", 3, 5, Inntekt::setPersonInntektAar));
        felter.add(plaintext("pi_type", 1, Inntekt::setPersonInntektType));
        felter.add(plaintext("pi_merke", 1, Inntekt::setPersonInntektMerke));
        felter.add(pakketHeltall("pi", 5, 9, Inntekt::setPersonInntekt));
        felter.add(pakketTekst("kommune", 3, 5, Inntekt::setKommune));
        felter.add(pakketHeltall("rappdato", 4, 7, Inntekt::setRapporteringsDato));
        felter.add(plaintext("reserve", 4, settesIkke ));
    }


    @Override
    public String getNavn() {
        return "PINNTEKT";
    }

    @Override
    public List<Felt<Inntekt>> getFelter() {
        return felter;
    }

    @Override
    public Inntekt initDomene() {
        return new Inntekt();
    }


}
