package no.nav.pensjon.dsf.dto;

public class Opphorsblankett1Dto extends GrunnblankettDto {

    private int dodsDato;
    private String ektefelleFodselsnummer;
    private String ektefelleNavn;
    private int avdodesPensjonsgivendeInntekt;

    public int getDodsDato() {
        return dodsDato;
    }

    public void setDodsDato(int dodsDato) {
        this.dodsDato = dodsDato;
    }

    public String getEktefelleFodselsnummer() {
        return ektefelleFodselsnummer;
    }

    public void setEktefelleFodselsnummer(String ektefelleFodselsnummer) {
        this.ektefelleFodselsnummer = ektefelleFodselsnummer;
    }

    public String getEktefelleNavn() {
        return ektefelleNavn;
    }

    public void setEktefelleNavn(String ektefelleNavn) {
        this.ektefelleNavn = ektefelleNavn;
    }

    public int getAvdodesPensjonsgivendeInntekt() {
        return avdodesPensjonsgivendeInntekt;
    }

    public void setAvdodesPensjonsgivendeInntekt(int avdodesPensjonsgivendeInntekt) {
        this.avdodesPensjonsgivendeInntekt = avdodesPensjonsgivendeInntekt;
    }
}
