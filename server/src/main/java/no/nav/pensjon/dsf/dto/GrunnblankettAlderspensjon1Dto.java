package no.nav.pensjon.dsf.dto;

public class GrunnblankettAlderspensjon1Dto extends GrunnblankettDto {

    private int statsborgerskap;
    private String bosattNorge;
    private int bosattLand;
    private String erFlyktning;
    private String overkompensasjonUtland;
    private String fravikTrygdetidUtland;
    private int trygdetidFra16Til66Aar;
    private int trygdetidFra16Til66AMaaneder;
    private String ikkeGrunnpensjon;
    private int alderspensjonIProsent;
    private int framtidigArbeidsinntekt;
    private String navnEktefelle;
    private String fodselsnummerEktefelle;
    private String tilleggEktefelle;
    private int inntektEktefelle;
    private int antallBarn;
    private String ektefelleMinst4G;
    private String ektefelleInntektOver2G;
    private String fravikKonvensjonTPOrdning;
    private String reduksjonGrunnpensjonPar3Pkt2Ledd5;

    public int getStatsborgerskap() {
        return statsborgerskap;
    }

    public void setStatsborgerskap(int statsborgerskap) {
        this.statsborgerskap = statsborgerskap;
    }

    public String getBosattNorge() {
        return bosattNorge;
    }

    public void setBosattNorge(String bosattNorge) {
        this.bosattNorge = bosattNorge;
    }

    public int getBosattLand() {
        return bosattLand;
    }

    public void setBosattLand(int bosattLand) {
        this.bosattLand = bosattLand;
    }

    public String getErFlyktning() {
        return erFlyktning;
    }

    public void setErFlyktning(String erFlyktning) {
        this.erFlyktning = erFlyktning;
    }

    public String getOverkompensasjonUtland() {
        return overkompensasjonUtland;
    }

    public void setOverkompensasjonUtland(String overkompensasjonUtland) {
        this.overkompensasjonUtland = overkompensasjonUtland;
    }

    public String getFravikTrygdetidUtland() {
        return fravikTrygdetidUtland;
    }

    public void setFravikTrygdetidUtland(String fravikTrygdetidUtland) {
        this.fravikTrygdetidUtland = fravikTrygdetidUtland;
    }

    public int getTrygdetidFra16Til66Aar() {
        return trygdetidFra16Til66Aar;
    }

    public void setTrygdetidFra16Til66Aar(int trygdetidFra16Til66Aar) {
        this.trygdetidFra16Til66Aar = trygdetidFra16Til66Aar;
    }

    public int getTrygdetidFra16Til66AMaaneder() {
        return trygdetidFra16Til66AMaaneder;
    }

    public void setTrygdetidFra16Til66AMaaneder(int trygdetidFra16Til66AMaaneder) {
        this.trygdetidFra16Til66AMaaneder = trygdetidFra16Til66AMaaneder;
    }

    public String getIkkeGrunnpensjon() {
        return ikkeGrunnpensjon;
    }

    public void setIkkeGrunnpensjon(String ikkeGrunnpensjon) {
        this.ikkeGrunnpensjon = ikkeGrunnpensjon;
    }

    public int getAlderspensjonIProsent() {
        return alderspensjonIProsent;
    }

    public void setAlderspensjonIProsent(int alderspensjonIProsent) {
        this.alderspensjonIProsent = alderspensjonIProsent;
    }

    public int getFramtidigArbeidsinntekt() {
        return framtidigArbeidsinntekt;
    }

    public void setFramtidigArbeidsinntekt(int framtidigArbeidsinntekt) {
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt *100;
    }

    public String getNavnEktefelle() {
        return navnEktefelle;
    }

    public void setNavnEktefelle(String navnEktefelle) {
        this.navnEktefelle = navnEktefelle;
    }

    public String getFodselsnummerEktefelle() {
        return fodselsnummerEktefelle;
    }

    public void setFodselsnummerEktefelle(String fodselsnummerEktefelle) {
        this.fodselsnummerEktefelle = fodselsnummerEktefelle;
    }

    public String getTilleggEktefelle() {
        return tilleggEktefelle;
    }

    public void setTilleggEktefelle(String tilleggEktefelle) {
        this.tilleggEktefelle = tilleggEktefelle;
    }

    public int getInntektEktefelle() {
        return inntektEktefelle;
    }

    public void setInntektEktefelle(int inntektEktefelle) {
        this.inntektEktefelle = inntektEktefelle;
    }

    public int getAntallBarn() {
        return antallBarn;
    }

    public void setAntallBarn(int antallBarn) {
        this.antallBarn = antallBarn;
    }

    public String getEktefelleMinst4G() {
        return ektefelleMinst4G;
    }

    public void setEktefelleMinst4G(String ektefelleMinst4G) {
        this.ektefelleMinst4G = ektefelleMinst4G;
    }

    public String getEktefelleInntektOver2G() {
        return ektefelleInntektOver2G;
    }

    public void setEktefelleInntektOver2G(String ektefelleInntektOver2G) {
        this.ektefelleInntektOver2G = ektefelleInntektOver2G;
    }

    public String getFravikKonvensjonTPOrdning() {
        return fravikKonvensjonTPOrdning;
    }

    public void setFravikKonvensjonTPOrdning(String fravikKonvensjonTPOrdning) {
        this.fravikKonvensjonTPOrdning = fravikKonvensjonTPOrdning;
    }

    public String getReduksjonGrunnpensjonPar3Pkt2Ledd5() {
        return reduksjonGrunnpensjonPar3Pkt2Ledd5;
    }

    public void setReduksjonGrunnpensjonPar3Pkt2Ledd5(String reduksjonGrunnpensjonPar3Pkt2Ledd5) {
        this.reduksjonGrunnpensjonPar3Pkt2Ledd5 = reduksjonGrunnpensjonPar3Pkt2Ledd5;
    }
}
