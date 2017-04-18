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

        felter.add(Characters.on(Inntekt.class, "start", 6, devNull ));
        felter.add(Characters.on(Inntekt.class, "segmentNavn", 8, devNull ));
        felter.add(Characters.on(Inntekt.class, "ukjent1", 21, devNull ));
        felter.add(PackedDecimal.tall(Inntekt.class, "pi_aar", 3, 5, Inntekt::setPersonInntektAar));
        felter.add(Characters.on(Inntekt.class, "pi_type", 1, Inntekt::setPersonInntektType));
        felter.add(Characters.on(Inntekt.class, "pi_merke", 1, Inntekt::setPersonInntektMerke));
        felter.add(PackedDecimal.tall(Inntekt.class, "pi", 5, 9, Inntekt::setPersonInntekt));
        felter.add(PackedDecimal.tekst(Inntekt.class, "kommune", 3, 5, Inntekt::setKommune));
        felter.add(PackedDecimal.tall(Inntekt.class, "rappdato", 4, 7, Inntekt::setRapporteringsDato));
        felter.add(Characters.on(Inntekt.class, "reserve", 4, devNull ));
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
