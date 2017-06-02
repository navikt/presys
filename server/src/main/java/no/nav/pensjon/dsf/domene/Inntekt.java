package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;


@Segment(name="PINNTEKT", length = 20)
public class Inntekt {

    @Felt(name="pi_aar", length = 3, start = 0)
    @PackedDecimal
    private int personInntektAar;

    @Felt(name="pi_type", length = 1, start = 3)
    private String personInntektType;

    @Felt(name="pi_merke", length = 1, start = 4)
    private String personInntektMerke;

    @Felt(name="pi", length = 5, start = 5)
    @PackedDecimal
    private int personInntekt;

    @Felt(name="kommune", length = 3, start = 10)
    @PackedDecimal
    private String kommune;

    @Felt(name="rappdato", length = 4, start = 13)
    @PackedDecimal
    private int rapporteringsDato;

    public int getPersonInntektAar() {
        return personInntektAar;
    }

    public void setPersonInntektAar(int personInntektAar) {
        this.personInntektAar = personInntektAar;
    }

    public String getPersonInntektType() {
        return personInntektType;
    }

    public void setPersonInntektType(String personInntektType) {
        this.personInntektType = personInntektType;
    }

    public String getPersonInntektMerke() {
        return personInntektMerke;
    }

    public void setPersonInntektMerke(String personInntektMerke) {
        this.personInntektMerke = personInntektMerke;
    }

    public int getPersonInntekt() {
        return personInntekt;
    }

    public void setPersonInntekt(int personInntekt) {
        this.personInntekt = personInntekt;
    }

    public String getKommune() {
        return kommune;
    }

    public void setKommune(String kommune) {
        this.kommune = kommune;
    }

    public int getRapporteringsDato() {
        return rapporteringsDato;
    }

    public void setRapporteringsDato(int rapporteringsDato) {
        this.rapporteringsDato = rapporteringsDato;
    }
}


