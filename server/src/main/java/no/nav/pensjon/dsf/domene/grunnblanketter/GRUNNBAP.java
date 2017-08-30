package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBAP", length = 66)
@UnmappedField(name = "filler", length = 3, start = 63)
public class GRUNNBAP {

    @Felt(name="EKTEFELLE_TILL", length = 1, start = 0) private String ektefelleTillegg;
    @Felt(name="FAI", length = 3, start = 1) @PackedDecimal private int framtidigArbeidsinntekt;
    @Felt(name="NBOSATT", length = 1, start = 4) private String bosattNorge;
    @Felt(name="STATSBORGER", length = 2, start = 5) @PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT", length = 2, start = 7) @PackedDecimal private int bosattLand;
    @Felt(name="FRAVIK_FLYKTN", length = 1, start = 9) private String erFlyktning;
    @Felt(name="FRAVIK_19_3", length = 1, start = 10) private String fravikPar19Pkt3;
    @Felt(name="TT_VENT_UTL", length = 2, start = 11) @PackedDecimal private int trygdetidVentetUtlandMaaneder;
    @Felt(name="TT_FOR_1967", length = 2, start = 13) @PackedDecimal private int trygdetidFor1967;
    @Felt(name="TT_ETTER_1966_AAR", length = 2, start = 15) @PackedDecimal private int trygdetidEtter1966Aar;
    @Felt(name="TT_ETTER_1966_MM", length = 2, start = 17) @PackedDecimal private int trygdetidEtter1966Maaneder;
    @Felt(name="BT_ANT", length = 2, start = 19) @PackedDecimal private int antallBarnetillegg;
    @Felt(name="APD", length = 2, start = 21) @PackedDecimal private int alderspensjonsdel;
    @Felt(name="FNR_EK", length = 6, start = 23) @PackedDecimal private String fodselsnummerEktefelle;
    @Felt(name="NAVN_EK", length = 25, start = 29) private String navnEktefelle;
    @Felt(name="TT_FOR_1967_EK", length = 2, start = 54) @PackedDecimal private int trygdetidFor1967Ektefelle;
    @Felt(name="TT_ETTER_1966_EK_AAR", length = 2, start = 56) @PackedDecimal private int trygdetidEtter1966AarEktefelle;
    @Felt(name="TT_ETTER_1966_EK_MM", length = 2, start = 58) @PackedDecimal private int trygdetidEtter1966MaanederEktefelle;
    @Felt(name="OVERKOMP_UTL", length = 1, start = 60) private String overkompensasjonUtland;
    @Felt(name="IKKE_GP", length = 1, start = 61) private String ikkeGrunnpensjon;
    @Felt(name="INNT_MINST_4G", length = 1, start = 62) private String inntektMinst4G;

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
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt;
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

    public int getTrygdetidVentetUtlandMaaneder() {
        return trygdetidVentetUtlandMaaneder;
    }

    public void setTrygdetidVentetUtlandMaaneder(int trygdetidVentetUtlandMaaneder) {
        this.trygdetidVentetUtlandMaaneder = trygdetidVentetUtlandMaaneder;
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

    public int getAntallBarnetillegg() {
        return antallBarnetillegg;
    }

    public void setAntallBarnetillegg(int antallBarnetillegg) {
        this.antallBarnetillegg = antallBarnetillegg;
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

    public int getTrygdetidFor1967Ektefelle() {
        return trygdetidFor1967Ektefelle;
    }

    public void setTrygdetidFor1967Ektefelle(int trygdetidFor1967Ektefelle) {
        this.trygdetidFor1967Ektefelle = trygdetidFor1967Ektefelle;
    }

    public int getTrygdetidEtter1966AarEktefelle() {
        return trygdetidEtter1966AarEktefelle;
    }

    public void setTrygdetidEtter1966AarEktefelle(int trygdetidEtter1966AarEktefelle) {
        this.trygdetidEtter1966AarEktefelle = trygdetidEtter1966AarEktefelle;
    }

    public int getTrygdetidEtter1966MaanederEktefelle() {
        return trygdetidEtter1966MaanederEktefelle;
    }

    public void setTrygdetidEtter1966MaanederEktefelle(int trygdetidEtter1966MaanederEktefelle) {
        this.trygdetidEtter1966MaanederEktefelle = trygdetidEtter1966MaanederEktefelle;
    }

    public String getOverkompensasjonUtland() {
        return overkompensasjonUtland;
    }

    public void setOverkompensasjonUtland(String overkompensasjonUtland) {
        this.overkompensasjonUtland = overkompensasjonUtland;
    }

    public String getIkkeGrunnpensjon() {
        return ikkeGrunnpensjon;
    }

    public void setIkkeGrunnpensjon(String ikkeGrunnpensjon) {
        this.ikkeGrunnpensjon = ikkeGrunnpensjon;
    }

    public String getInntektMinst4G() {
        return inntektMinst4G;
    }

    public void setInntektMinst4G(String inntektMinst4G) {
        this.inntektMinst4G = inntektMinst4G;
    }
}
