package no.nav.pensjon.dsf.dto;

public class GrunnblankettForesorgingsTilleggF7Dto extends GrunnblankettDto {


    private String ektefelletillegg;
    private int arbeidsinntekt;
    private int pensjonsinntekt;
    private int arbeidsinntektEktefelle;
    private int pensjonsinntektEktefelle;
    private int antallBarnetillegg;
    private PersonDto ektefelle;

    public String getEktefelletillegg() {
        return ektefelletillegg;
    }

    public void setEktefelletillegg(String ektefelletillegg) {
        this.ektefelletillegg = ektefelletillegg;
    }

    public int getArbeidsinntekt() {
        return arbeidsinntekt;
    }

    public void setArbeidsinntekt(int arbeidsinntekt) {
        this.arbeidsinntekt = arbeidsinntekt;
    }

    public int getPensjonsinntekt() {
        return pensjonsinntekt;
    }

    public void setPensjonsinntekt(int pensjonsinntekt) {
        this.pensjonsinntekt = pensjonsinntekt;
    }

    public int getArbeidsinntektEktefelle() {
        return arbeidsinntektEktefelle;
    }

    public void setArbeidsinntektEktefelle(int arbeidsinntektEktefelle) {
        this.arbeidsinntektEktefelle = arbeidsinntektEktefelle;
    }

    public int getPensjonsinntektEktefelle() {
        return pensjonsinntektEktefelle;
    }

    public void setPensjonsinntektEktefelle(int pensjonsinntektEktefelle) {
        this.pensjonsinntektEktefelle = pensjonsinntektEktefelle;
    }

    public int getAntallBarnetillegg() {
        return antallBarnetillegg;
    }

    public void setAntallBarnetillegg(int antallBarnetillegg) {
        this.antallBarnetillegg = antallBarnetillegg;
    }

    public PersonDto getEktefelle() {
        return ektefelle;
    }

    public void setEktefelle(PersonDto ektefelle) {
        this.ektefelle = ektefelle;
    }
}
