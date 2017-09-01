package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRBLFAMP", length = 38)
@UnmappedField(name = "filler", length = 4, start = 34)
public class GRBLFAMP {

    @Felt(name="FORVENTET_INNT", length = 3, start = 0) @PackedDecimal private int forventetInntekt;
    @Felt(name="HJEMMEL_10_8", length = 1, start = 3) private String hjemmelPar10Pkt8;
    @Felt(name="FRAMLEGGSDATO_AAMD", length = 5, start = 4) @PackedDecimal private int framleggsdato;
    @Felt(name="FRAMLEGGSKODE", length = 1, start = 9) private String framleggskode;
    @Felt(name="NBOSATT", length = 1, start = 10) private String bosattNorge;
    @Felt(name="GP_OS_KODE", length = 1, start = 11) private String overgangsstonadPensjonKode;
    @Felt(name="STATSBORGER", length = 2, start = 12) @PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT", length = 2, start = 14) @PackedDecimal private int bosattLand;
    @Felt(name="FRAVIK_BOSATT", length = 1, start = 16) private String fravikBosatt;
    @Felt(name="TRYGD3", length = 1, start = 17) private String trygd3;
    @Felt(name="FRAVIK_TRYGDET_3AAR", length = 1, start = 18) private String fravikTrygdet3Aar;
    @Felt(name="FRAVIK_10_1", length = 1, start = 19) private String fravikPar10Pkt1;
    @Felt(name="KONVENSJON", length = 1, start = 20) private String konvensjon;
    @Felt(name="FRAVIK_19_3", length = 1, start = 21) private String fravikPar19Pkt3;
    @Felt(name="FRAVIK_FLYKTN", length = 1, start = 22) private String erFlyktning;
    @Felt(name="TT_ETTER_OPPHOR", length = 2, start = 23) @PackedDecimal private int trygdetidEtterOpphor;
    @Felt(name="TT_FOR_1967", length = 2, start = 25) @PackedDecimal private int trygdetidFor1967;
    @Felt(name="TT_ETTER_1966_AAR", length = 2, start = 27) @PackedDecimal private int trygdetidEtter1966Aar;
    @Felt(name="TT_ETTER_1966_MM", length = 2, start = 29) @PackedDecimal private int trygdetidEtter1966Maaneder;
    @Felt(name="TTFMT101", length = 2, start = 31) @PackedDecimal private int ttfmt101all;
    @Felt(name="DOD_AV_YRKESSKADE", length = 1, start = 33) private String dodAvYrkesskade;

    public int getForventetInntekt() {
        return forventetInntekt;
    }

    public void setForventetInntekt(int forventetInntekt) {
        this.forventetInntekt = forventetInntekt;
    }

    public String getHjemmelPar10Pkt8() {
        return hjemmelPar10Pkt8;
    }

    public void setHjemmelPar10Pkt8(String hjemmelPar10Pkt8) {
        this.hjemmelPar10Pkt8 = hjemmelPar10Pkt8;
    }

    public int getFramleggsdato() {
        return framleggsdato;
    }

    public void setFramleggsdato(int framleggsdato) {
        this.framleggsdato = framleggsdato;
    }

    public String getFramleggskode() {
        return framleggskode;
    }

    public void setFramleggskode(String framleggskode) {
        this.framleggskode = framleggskode;
    }

    public String getBosattNorge() {
        return bosattNorge;
    }

    public void setBosattNorge(String bosattNorge) {
        this.bosattNorge = bosattNorge;
    }

    public String getOvergangsstonadPensjonKode() {
        return overgangsstonadPensjonKode;
    }

    public void setOvergangsstonadPensjonKode(String overgangsstonadPensjonKode) {
        this.overgangsstonadPensjonKode = overgangsstonadPensjonKode;
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

    public String getFravikBosatt() {
        return fravikBosatt;
    }

    public void setFravikBosatt(String fravikBosatt) {
        this.fravikBosatt = fravikBosatt;
    }

    public String getTrygd3() {
        return trygd3;
    }

    public void setTrygd3(String trygd3) {
        this.trygd3 = trygd3;
    }

    public String getFravikTrygdet3Aar() {
        return fravikTrygdet3Aar;
    }

    public void setFravikTrygdet3Aar(String fravikTrygdet3Aar) {
        this.fravikTrygdet3Aar = fravikTrygdet3Aar;
    }

    public String getFravikPar10Pkt1() {
        return fravikPar10Pkt1;
    }

    public void setFravikPar10Pkt1(String fravikPar10Pkt1) {
        this.fravikPar10Pkt1 = fravikPar10Pkt1;
    }

    public String getKonvensjon() {
        return konvensjon;
    }

    public void setKonvensjon(String konvensjon) {
        this.konvensjon = konvensjon;
    }

    public String getFravikPar19Pkt3() {
        return fravikPar19Pkt3;
    }

    public void setFravikPar19Pkt3(String fravikPar19Pkt3) {
        this.fravikPar19Pkt3 = fravikPar19Pkt3;
    }

    public String getErFlyktning() {
        return erFlyktning;
    }

    public void setErFlyktning(String erFlyktning) {
        this.erFlyktning = erFlyktning;
    }

    public int getTrygdetidEtterOpphor() {
        return trygdetidEtterOpphor;
    }

    public void setTrygdetidEtterOpphor(int trygdetidEtterOpphor) {
        this.trygdetidEtterOpphor = trygdetidEtterOpphor;
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

    public int getTtfmt101all() {
        return ttfmt101all;
    }

    public void setTtfmt101all(int ttfmt101all) {
        this.ttfmt101all = ttfmt101all;
    }

    public String getDodAvYrkesskade() {
        return dodAvYrkesskade;
    }

    public void setDodAvYrkesskade(String dodAvYrkesskade) {
        this.dodAvYrkesskade = dodAvYrkesskade;
    }
}
