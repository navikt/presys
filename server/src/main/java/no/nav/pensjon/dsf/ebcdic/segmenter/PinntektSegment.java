package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.ebcdic.felter.Felt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static no.nav.pensjon.dsf.ebcdic.felter.Characters.plaintext;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.pakketHeltall;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.pakketTekst;
import static no.nav.pensjon.dsf.ebcdic.felter.SegmentNavnFelt.segmentNavn;

public class PinntektSegment extends Segment<Inntekt> {

    PinntektSegment() {
        super("PINNTEKT", Inntekt::new);

        BiConsumer<Inntekt, String> settesIkke = (inntekt, verdi)-> {}; //Brukes for felter som ikke skal settes på domeneobjektet

        getFelter().add(plaintext("start", 6, settesIkke ));
        getFelter().add(segmentNavn());
        getFelter().add(plaintext("ukjent1", 21, settesIkke ));
        getFelter().add(pakketHeltall("pi_aar", 3, 5, Inntekt::setPersonInntektAar));
        getFelter().add(plaintext("pi_type", 1, Inntekt::setPersonInntektType));
        getFelter().add(plaintext("pi_merke", 1, Inntekt::setPersonInntektMerke));
        getFelter().add(pakketHeltall("pi", 5, 9, Inntekt::setPersonInntekt));
        getFelter().add(pakketTekst("kommune", 3, 5, Inntekt::setKommune));
        getFelter().add(pakketHeltall("rappdato", 4, 7, Inntekt::setRapporteringsDato));
        getFelter().add(plaintext("reserve", 4, settesIkke ));
    }
}
