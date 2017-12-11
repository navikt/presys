package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBAF", length = 66)
@UnmappedField(name = "filler1", length = 2, start = 11)
@UnmappedField(name = "filler2", length = 2, start = 19)
@UnmappedField(name = "filler3", length = 6, start = 54)
public class GRUNNBAF {

    @Felt(name="EKTEFELLE_TILL", length = 1, start = 0) private String ektefelleTillegg;
    @Felt(name="FAI", length = 3, start = 1) @PackedDecimal private int framtidigArbeidsinntekt;
    @Felt(name="NBOSATT", length = 1, start = 4) private String bosattNorge;
    @Felt(name="STATSBORGER", length = 2, start = 5) @PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT", length = 2, start = 7) @PackedDecimal private int bosattLand;
    @Felt(name="FRAVIK_FLYKTN", length = 1, start = 9) private String erFlyktning;
    @Felt(name="FRAVIK_19_3", length = 1, start = 10) private String fravikPar19Pkt3;
    @Felt(name="TT_FOR_1967", length = 2, start = 13) @PackedDecimal private int trygdetidFor1967;
    @Felt(name="TT_ETTER_1966_AAR", length = 2, start = 15) @PackedDecimal private int trygdetidEtter1966Aar;
    @Felt(name="TT_ETTER_1966_MM", length = 2, start = 17) @PackedDecimal private int trygdetidEtter1966Maaneder;
    @Felt(name="APD", length = 2, start = 21) @PackedDecimal private int alderspensjonsdel;
    @Felt(name="FNR_EK", length = 6, start = 23) @PackedDecimal private String fodselsnummerEktefelle;
    @Felt(name="NAVN_EK", length = 25, start = 29) private String navnEktefelle;
    @Felt(name="OVERKOMP_UTL", length = 1, start = 60) private String overkompensasjonUtland;
    @Felt(name="AFP_TILLEGG_KODE ", length = 1, start = 61) private String afpTilleggskode;
    @Felt(name="AFP_ORDNING ", length = 1, start = 62) private String afpOrdning;
    @Felt(name="PI", length = 3, start = 63) private int pensjonsinntekt;

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
        this.pensjonsinntekt = pensjonsinntekt;
    }
}
