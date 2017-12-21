package no.nav.pensjon.dsf.dto;

public class GrunnblankettAvtalefestetPensjonDto extends GrunnblankettDto {

    private String ektefelleTillegg;
    private int framtidigArbeidsinntekt;
    private String bosattNorge;
    private int statsborgerskap;
    private int bosattLand;
    private String erFlyktning;
    private String fravikPar19Pkt3;
    private int trygdetidFor1967;
    private int trygdetidEtter1966Aar;
    private int trygdetidEtter1966Maaneder;
    private int alderspensjonsdel;
    private String fodselsnummerEktefelle;
    private String navnEktefelle;
    private String overkompensasjonUtland;
    private String afpTilleggskode;
    private String afpOrdning;
    private int pensjonsinntekt;

    public String getEktefelleTillegg() {
        return ektefelleTillegg;
    }

    public void setEktefelleTillegg(String ektefelleTillegg) {
        this.ektefelleTillegg = ektefelleTillegg;
    }

    public int getFramtidigArbeidsinntekt() {
        return framtidigArbeidsinntekt;
    }

    public void setFramtidigArbeidsinntekt(int framtidigArbeidsinntekt) {
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt *100;
    }

    public String getBosattNorge() {
        return bosattNorge;
    }

    public void setBosattNorge(String bosattNorge) {
        this.bosattNorge = bosattNorge;
    }

    public int getStatsborgerskap() {
        return statsborgerskap;
    }

    public void setStatsborgerskap(int statsborgerskap) {
        this.statsborgerskap = statsborgerskap;
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

    public String getFravikPar19Pkt3() {
        return fravikPar19Pkt3;
    }

    public void setFravikPar19Pkt3(String fravikPar19Pkt3) {
        this.fravikPar19Pkt3 = fravikPar19Pkt3;
    }

    public int getTrygdetidFor1967() {
        return trygdetidFor1967;
    }

    public void setTrygdetidFor1967(int trygdetidFor1967) {
        this.trygdetidFor1967 = trygdetidFor1967;
    }

    public int getTrygdetidEtter1966Aar() {
        return trygdetidEtter1966Aar;
    }

    public void setTrygdetidEtter1966Aar(int trygdetidEtter1966Aar) {
        this.trygdetidEtter1966Aar = trygdetidEtter1966Aar;
    }

    public int getTrygdetidEtter1966Maaneder() {
        return trygdetidEtter1966Maaneder;
    }

    public void setTrygdetidEtter1966Maaneder(int trygdetidEtter1966Maaneder) {
        this.trygdetidEtter1966Maaneder = trygdetidEtter1966Maaneder;
    }

    public int getAlderspensjonsdel() {
        return alderspensjonsdel;
    }

    public void setAlderspensjonsdel(int alderspensjonsdel) {
        this.alderspensjonsdel = alderspensjonsdel;
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

    public String getOverkompensasjonUtland() {
        return overkompensasjonUtland;
    }

    public void setOverkompensasjonUtland(String overkompensasjonUtland) {
        this.overkompensasjonUtland = overkompensasjonUtland;
    }

    public String getAfpTilleggskode() {
        return afpTilleggskode;
    }

    public void setAfpTilleggskode(String afpTilleggskode) {
        this.afpTilleggskode = afpTilleggskode;
    }

    public String getAfpOrdning() {
        return afpOrdning;
    }

    public void setAfpOrdning(String afpOrdning) {
        this.afpOrdning = afpOrdning;
    }

    public int getPensjonsinntekt() {
        return pensjonsinntekt;
    }

    public void setPensjonsinntekt(int pensjonsinntekt) {
        this.pensjonsinntekt = pensjonsinntekt *100;
    }
}
