package no.nav.pensjon.dsf.domene;

/**
 * Created by d132988 on 11.04.2017.
 */
public class Inntekt {

    private int personInntektAar;
    private String personInntektType;
    private String personInntektMerke;
    private int personInntekt;
    private String kommune;
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


