package no.nav.pensjon.dsf.dto;

public class GrunnblankettForsorgertilleggEktefelleOgEllerBarnDto extends GrunnblankettDto {

    private String ektefelleTillegg;
    private int arbeidsInntekt;
    private int pensjonsInntekt;
    private int arbeidsInntektEktefelle;
    private int pensjonsInntektEktefelle;
    private int anntallBarnForForsorgertillegg;
    private String minst4G;
    private String fodselsnummerEktefelle;
    private String navnEktefelle;
    private String inntektsprovetEosPensjon;
    private int trygdetidEosAAr;
    private int trygdetidEosMaaneder;

    public String getEktefelleTillegg() {
        return ektefelleTillegg;
    }

    public void setEktefelleTillegg(String ektefelleTillegg) {
        this.ektefelleTillegg = ektefelleTillegg;
    }

    public int getArbeidsInntekt() {
        return arbeidsInntekt;
    }

    public void setArbeidsInntekt(int arbeidsInntekt) {
        this.arbeidsInntekt = arbeidsInntekt;
    }

    public int getPensjonsInntekt() {
        return pensjonsInntekt;
    }

    public void setPensjonsInntekt(int pensjonsInntekt) {
        this.pensjonsInntekt = pensjonsInntekt;
    }

    public int getArbeidsInntektEktefelle() {
        return arbeidsInntektEktefelle;
    }

    public void setArbeidsInntektEktefelle(int arbeidsInntektEktefelle) {
        this.arbeidsInntektEktefelle = arbeidsInntektEktefelle;
    }

    public int getPensjonsInntektEktefelle() {
        return pensjonsInntektEktefelle;
    }

    public void setPensjonsInntektEktefelle(int pensjonsInntektEktefelle) {
        this.pensjonsInntektEktefelle = pensjonsInntektEktefelle;
    }

    public int getAnntallBarnForForsorgertillegg() {
        return anntallBarnForForsorgertillegg;
    }

    public void setAnntallBarnForForsorgertillegg(int anntallBarnForForsorgertillegg) {
        this.anntallBarnForForsorgertillegg = anntallBarnForForsorgertillegg;
    }

    public String getMinst4G() {
        return minst4G;
    }

    public void setMinst4G(String minst4G) {
        this.minst4G = minst4G;
    }

    public String getFodselsnummerEktefelle() {
        return fodselsnummerEktefelle;
    }

    public void setFodselsnummerEktefelle(String fodselsnummerEktefelle) {
        this.fodselsnummerEktefelle = fodselsnummerEktefelle;
    }

    public String getNavnEktefelle() {
        return navnEktefelle;
    }

    public void setNavnEktefelle(String navnEktefelle) {
        this.navnEktefelle = navnEktefelle;
    }

    public String getInntektsprovetEosPensjon() {
        return inntektsprovetEosPensjon;
    }

    public void setInntektsprovetEosPensjon(String inntektsprovetEosPensjon) {
        this.inntektsprovetEosPensjon = inntektsprovetEosPensjon;
    }

    public int getTrygdetidEosAAr() {
        return trygdetidEosAAr;
    }

    public void setTrygdetidEosAAr(int trygdetidEosAAr) {
        this.trygdetidEosAAr = trygdetidEosAAr;
    }

    public int getTrygdetidEosMaaneder() {
        return trygdetidEosMaaneder;
    }

    public void setTrygdetidEosMaaneder(int trygdetidEosMaaneder) {
        this.trygdetidEosMaaneder = trygdetidEosMaaneder;
    }
}
