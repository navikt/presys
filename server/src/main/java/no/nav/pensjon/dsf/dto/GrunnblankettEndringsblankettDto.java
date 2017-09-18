package no.nav.pensjon.dsf.dto;

public class GrunnblankettEndringsblankettDto extends GrunnblankettDto {

    private int framtidigArbeidsinntekt;
    private String hoyestePensjonsgrad;
    private int alderspensjonsdelIProsent;
    private int uforegrad;
    private int forventetInntekt;
    private String overgangsstonadTilPensjon;
    private int tilleggspensjonForGjenlevendePensjonIProsent;
    private int framleggsdato;
    private String opphortOvergangsstonadGjennlevende;
    private String nyttNavnPensjonist;
    private String nyttNavnEps;
    private String fodselsnummerEktefelle;
    private String navnEktefelle;
    private String skilsmisse;
    private String flyttetFraHverandre;
    private String flyttetSammen;
    private String inntektMinst4G;
    private String inntektUnder4G;
    private int yrkeUforegrad;

    public int getFramtidigArbeidsinntekt() {
        return framtidigArbeidsinntekt;
    }

    public void setFramtidigArbeidsinntekt(int framtidigArbeidsinntekt) {
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt;
    }

    public String getHoyestePensjonsgrad() {
        return hoyestePensjonsgrad;
    }

    public void setHoyestePensjonsgrad(String hoyestePensjonsgrad) {
        this.hoyestePensjonsgrad = hoyestePensjonsgrad;
    }

    public int getAlderspensjonsdelIProsent() {
        return alderspensjonsdelIProsent;
    }

    public void setAlderspensjonsdelIProsent(int alderspensjonsdelIProsent) {
        this.alderspensjonsdelIProsent = alderspensjonsdelIProsent;
    }

    public int getUforegrad() {
        return uforegrad;
    }

    public void setUforegrad(int uforegrad) {
        this.uforegrad = uforegrad;
    }

    public int getForventetInntekt() {
        return forventetInntekt;
    }

    public void setForventetInntekt(int forventetInntekt) {
        this.forventetInntekt = forventetInntekt * 100;
    }

    public String getOvergangsstonadTilPensjon() {
        return overgangsstonadTilPensjon;
    }

    public void setOvergangsstonadTilPensjon(String overgangsstonadTilPensjon) {
        this.overgangsstonadTilPensjon = overgangsstonadTilPensjon;
    }

    public int getTilleggspensjonForGjenlevendePensjonIProsent() {
        return tilleggspensjonForGjenlevendePensjonIProsent;
    }

    public void setTilleggspensjonForGjenlevendePensjonIProsent(int tilleggspensjonForGjenlevendePensjonIProsent) {
        this.tilleggspensjonForGjenlevendePensjonIProsent = tilleggspensjonForGjenlevendePensjonIProsent;
    }

    public int getFramleggsdato() {
        return framleggsdato;
    }

    public void setFramleggsdato(int framleggsdato) {
        this.framleggsdato = framleggsdato;
    }

    public String getOpphortOvergangsstonadGjennlevende() {
        return opphortOvergangsstonadGjennlevende;
    }

    public void setOpphortOvergangsstonadGjennlevende(String opphortOvergangsstonadGjennlevende) {
        this.opphortOvergangsstonadGjennlevende = opphortOvergangsstonadGjennlevende;
    }

    public String getNyttNavnPensjonist() {
        return nyttNavnPensjonist;
    }

    public void setNyttNavnPensjonist(String nyttNavnPensjonist) {
        this.nyttNavnPensjonist = nyttNavnPensjonist;
    }

    public String getNyttNavnEps() {
        return nyttNavnEps;
    }

    public void setNyttNavnEps(String nyttNavnEps) {
        this.nyttNavnEps = nyttNavnEps;
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

    public String getSkilsmisse() {
        return skilsmisse;
    }

    public void setSkilsmisse(String skilsmisse) {
        this.skilsmisse = skilsmisse;
    }

    public String getFlyttetFraHverandre() {
        return flyttetFraHverandre;
    }

    public void setFlyttetFraHverandre(String flyttetFraHverandre) {
        this.flyttetFraHverandre = flyttetFraHverandre;
    }

    public String getFlyttetSammen() {
        return flyttetSammen;
    }

    public void setFlyttetSammen(String flyttetSammen) {
        this.flyttetSammen = flyttetSammen;
    }

    public String getInntektMinst4G() {
        return inntektMinst4G;
    }

    public void setInntektMinst4G(String inntektMinst4G) {
        this.inntektMinst4G = inntektMinst4G;
    }

    public String getInntektUnder4G() {
        return inntektUnder4G;
    }

    public void setInntektUnder4G(String inntektUnder4G) {
        this.inntektUnder4G = inntektUnder4G;
    }

    public int getYrkeUforegrad() {
        return yrkeUforegrad;
    }

    public void setYrkeUforegrad(int yrkeUforegrad) {
        this.yrkeUforegrad = yrkeUforegrad;
    }
}
