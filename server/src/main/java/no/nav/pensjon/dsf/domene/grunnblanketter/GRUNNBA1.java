package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBA1", length = 66)
@UnmappedField(name="PENSJON_BELOP", length = 4, start = 57)
@UnmappedField(name = "filler", length = 2, start = 64)
public class GRUNNBA1 {

    @Felt(name="STATSBORGER", length = 2, start = 0) @PackedDecimal private int statsborgerskap;
    @Felt(name="NBOSATT", length = 1, start = 2) private String bosattNorge;
    @Felt(name="BOSATT", length = 2, start = 3) @PackedDecimal private int bosattLand;
    @Felt(name="FRAVIK_FLYKTN", length = 1, start = 5) private String erFlyktning;
    @Felt(name="OVERKOMP_UTL", length = 1, start = 6) private String overkompensasjonUtland;
    @Felt(name="FRAVIK_TT_KONV", length = 1, start = 7) private String fravikTrygdetidUtland;
    @Felt(name="TT_16_66AAR", length = 2, start = 8) @PackedDecimal private int trygdetidFra16Til66Aar;
    @Felt(name="TT_16_66MD", length = 2, start = 10) @PackedDecimal private int trygdetidFra16Til66AMaaneder;
    @Felt(name="IKKE_GP", length = 1, start = 12) private String ikkeGrunnpensjon;
    @Felt(name="APD", length = 2, start = 13) @PackedDecimal private int alderspensjonIProsent;
    @Felt(name="FAI", length = 3, start = 15) @PackedDecimal private int framtidigArbeidsinntekt;
    @Felt(name="NAVN_EK", length = 25, start = 18) private String navnEktefelle;
    @Felt(name="FNR_EK", length = 6, start = 43) @PackedDecimal private String fodselsnummerEktefelle;
    @Felt(name="TILL_EK", length = 1, start = 49) private String tilleggEktefelle;
    @Felt(name="INNT_EK", length = 4, start = 50) @PackedDecimal private int inntektEktefelle;
    @Felt(name="BT_ANT", length = 2, start = 54) @PackedDecimal private int antallBarn;
    @Felt(name="MINST4G", length = 1, start = 56) private String ektefelleMinst4G;
    @Felt(name="EK_INNT_OVER_2G", length = 1, start = 61) private String ektefelleInntektOver2G;
    @Felt(name="FRAVIK_KONV_TP", length = 1, start = 62) private String fravikKonvensjonTPOrdning;
    @Felt(name="RED_GP_3_2_5", length = 1, start = 63) private String reduksjonGrunnpensjonPar3Pkt2Ledd5;

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
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt;
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
