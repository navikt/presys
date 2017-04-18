package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Inntekt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class PinntektSegment extends Segment<Inntekt> {

    private List<Felt<Inntekt>> felter = new ArrayList<>();

    PinntektSegment() {
        BiConsumer<Inntekt, String> devNull = (inntekt, verdi)-> {};

        felter.add(Characters.tekst("start", 6, devNull ));
        felter.add(Characters.tekst("segmentNavn", 8, devNull ));
        felter.add(Characters.tekst("ukjent1", 21, devNull ));
        felter.add(PackedDecimal.tall("pi_aar", 3, 5, Inntekt::setPersonInntektAar));
        felter.add(Characters.tekst("pi_type", 1, Inntekt::setPersonInntektType));
        felter.add(Characters.tekst("pi_merke", 1, Inntekt::setPersonInntektMerke));
        felter.add(PackedDecimal.tall("pi", 5, 9, Inntekt::setPersonInntekt));
        felter.add(PackedDecimal.tekst("kommune", 3, 5, Inntekt::setKommune));
        felter.add(PackedDecimal.tall("rappdato", 4, 7, Inntekt::setRapporteringsDato));
        felter.add(Characters.tekst("reserve", 4, devNull ));
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
