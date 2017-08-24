package no.nav.pensjon.dsf.dto;

public class GrunnblankettNyAFPDto extends GrunnblankettDto {

    private boolean norskBosatt;
    private int trygdetidAar;
    private int trygdetidMaaneder;
    private int statsborger;
    private int bosattLandkode;
    private String fravikFlyktning;
    private String overkompensasjonForUtlending;
    private int pensjonsinntektSisteAar;
    private int framtidigArbeidsinntekt;
    private String tilleggForEktefelle;
    private int pensjonsinntektUtenomFolketrygd;
    private String afpTilleggskode;
    private String afpOrdningskode;
    private int fodselsnummerEktefelle;
    private String navnEktefelle;
    private String ektefelleInntektOver2G;
    private String redusertGrunnpensjonEtterParagraf325;

    public boolean getNorskBosatt() {
        return norskBosatt;
    }

    public void setNorskBosatt(String norskBosatt) {
        this.norskBosatt = norskBosatt.equals("J");
    }

    public int getTrygdetidAar() {
        return trygdetidAar;
    }

    public void setTrygdetidAar(int trygdetidAar) {
        this.trygdetidAar = trygdetidAar;
    }

    public int getTrygdetidMaaneder() {
        return trygdetidMaaneder;
    }

    public void setTrygdetidMaaneder(int trygdetidMaaneder) {
        this.trygdetidMaaneder = trygdetidMaaneder;
    }

    public int getStatsborger() {
        return statsborger;
    }

    public void setStatsborger(int statsborger) {
        this.statsborger = statsborger;
    }

    public int getBosattLandkode() {
        return bosattLandkode;
    }

    public void setBosattLandkode(int bosattLandkode) {
        this.bosattLandkode = bosattLandkode;
    }

    public String getFravikFlyktning() {
        return fravikFlyktning;
    }

    public void setFravikFlyktning(String fravikFlyktning) {
        this.fravikFlyktning = fravikFlyktning;
    }

    public String getOverkompensasjonForUtlending() {
        return overkompensasjonForUtlending;
    }

    public void setOverkompensasjonForUtlending(String overkompensasjonForUtlending) {
        this.overkompensasjonForUtlending = overkompensasjonForUtlending;
    }

    public int getPensjonsinntektSisteAar() {
        return pensjonsinntektSisteAar;
    }

    public void setPensjonsinntektSisteAar(int pensjonsinntektSisteAar) {
        this.pensjonsinntektSisteAar = pensjonsinntektSisteAar;
    }

    public int getFramtidigArbeidsinntekt() {
        return framtidigArbeidsinntekt;
    }

    public void setFramtidigArbeidsinntekt(int framtidigArbeidsinntekt) {
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt;
    }

    public String getTilleggForEktefelle() {
        return tilleggForEktefelle;
    }

    public void setTilleggForEktefelle(String tilleggForEktefelle) {
        this.tilleggForEktefelle = tilleggForEktefelle;
    }

    public int getPensjonsinntektUtenomFolketrygd() {
        return pensjonsinntektUtenomFolketrygd;
    }

    public void setPensjonsinntektUtenomFolketrygd(int pensjonsinntektUtenomFolketrygd) {
        this.pensjonsinntektUtenomFolketrygd = pensjonsinntektUtenomFolketrygd;
    }

    public String getAfpTilleggskode() {
        return afpTilleggskode;
    }

    public void setAfpTilleggskode(String afpTilleggskode) {
        this.afpTilleggskode = afpTilleggskode;
    }

    public String getAfpOrdningskode() {
        return afpOrdningskode;
    }

    public void setAfpOrdningskode(String afpOrdningskode) {
        this.afpOrdningskode = afpOrdningskode;
    }

    public int getFodselsnummerEktefelle() {
        return fodselsnummerEktefelle;
    }

    public void setFodselsnummerEktefelle(int fodselsnummerEktefelle) {
        this.fodselsnummerEktefelle = fodselsnummerEktefelle;
    }

    public String getNavnEktefelle() {
        return navnEktefelle;
    }

    public void setNavnEktefelle(String navnEktefelle) {
        this.navnEktefelle = navnEktefelle;
    }

    public String getEktefelleInntektOver2G() {
        return ektefelleInntektOver2G;
    }

    public void setEktefelleInntektOver2G(String ektefelleInntektOver2G) {
        this.ektefelleInntektOver2G = ektefelleInntektOver2G;
    }

    public String getRedusertGrunnpensjonEtterParagraf325() {
        return redusertGrunnpensjonEtterParagraf325;
    }

    public void setRedusertGrunnpensjonEtterParagraf325(String redusertGrunnpensjonEtterParagraf325) {
        this.redusertGrunnpensjonEtterParagraf325 = redusertGrunnpensjonEtterParagraf325;
    }
}
