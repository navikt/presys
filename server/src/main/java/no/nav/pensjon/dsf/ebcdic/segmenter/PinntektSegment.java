package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Inntekt;

import java.util.function.BiConsumer;

import static no.nav.pensjon.dsf.ebcdic.felter.Characters.filler;
import static no.nav.pensjon.dsf.ebcdic.felter.Characters.plaintext;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.pakketHeltall;
import static no.nav.pensjon.dsf.ebcdic.felter.SegmentNavnFelt.segmentNavn;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.pakketZeroFilled;


public class PinntektSegment extends Segment<Inntekt> {

    PinntektSegment() {
        super("PINNTEKT", Inntekt::new);

        getFelter().add(filler("start", 6 ));
        getFelter().add(segmentNavn(this));
        getFelter().add(filler("ukjent1", 21 ));
        getFelter().add(pakketHeltall("pi_aar", 3, 5, Inntekt::setPersonInntektAar, Inntekt::getPersonInntektAar));
        getFelter().add(plaintext("pi_type", 1, Inntekt::setPersonInntektType, Inntekt::getPersonInntektType));
        getFelter().add(plaintext("pi_merke", 1, Inntekt::setPersonInntektMerke, Inntekt::getPersonInntektMerke));
        getFelter().add(pakketHeltall("pi", 5, 9, Inntekt::setPersonInntekt, Inntekt::getPersonInntekt));
        getFelter().add(pakketZeroFilled("kommune", 3, 5, Inntekt::setKommune, Inntekt::getKommune));
        getFelter().add(pakketHeltall("rappdato", 4, 7, Inntekt::setRapporteringsDato, Inntekt::getRapporteringsDato));
        getFelter().add(filler("reserve", 4 ));
    }
}
