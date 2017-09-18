package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBKF", length = 66)
@UnmappedField(name = "filler", length = 9, start = 57)
public class GRUNNBKF {

    @Felt(name="NBOSATT", length = 1, start = 0)
    private String norskBosatt;

    @Felt(name="TT_16_66_AA", length = 2, start = 1)
    @PackedDecimal
    private int trygdetidAar;

    @Felt(name="TT_16_66_M", length = 2, start = 3)
    @PackedDecimal
    private int trygdetidMaaneder;

    @Felt(name="STATSBORGER", length = 2, start = 5)
    @PackedDecimal
    private int statsborger;

    @Felt(name="BOSATT", length = 2, start = 7)
    @PackedDecimal
    private int bosattLandkode;

    @Felt(name="FRAVIK_FLYKTN", length = 1, start = 9)
    private String fravikFlyktning;

    @Felt(name="OVERKOMP_UTL", length = 1, start = 10)
    private String overkompensasjonForUtlending;

    @Felt(name="PI_SISTE_AAR", length = 4, start = 11)
    @PackedDecimal
    private int pensjonsinntektSisteAar;

    @Felt(name="FAI", length = 3, start = 15)
    @PackedDecimal
    private int framtidigArbeidsinntekt;

    @Felt(name="TILL_EK", length = 1, start = 18)
    private String tilleggForEktefelle;

    @Felt(name="PEN_INNT", length = 3, start = 19)
    @PackedDecimal
    private int pensjonsinntektUtenomFolketrygd;

    @Felt(name="AFP_TILLEGGKODE", length = 1, start = 22)
    private String afpTilleggskode;

    @Felt(name="AFP_ORDNING", length = 1, start = 23)
    private String afpOrdningskode;

    @Felt(name="FNR_EK", length = 6, start = 24)
    @PackedDecimal
    private String fodselsnummerEktefelle;

    @Felt(name="NAVN_EK", length = 25, start = 30)
    private String navnEktefelle;

    @Felt(name="EK_INNT_OVER_2G", length = 1, start = 55)
    private String ektefelleInntektOver2G;

    @Felt(name="RED_GP_3_2_5", length = 1, start = 56)
    private String redusertGrunnpensjonEtterParagraf325;

    public String getNorskBosatt() {
        return norskBosatt;
    }

    public void setNorskBosatt(String norskBosatt) {
        this.norskBosatt = norskBosatt;
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
