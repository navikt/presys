package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBEP", length = 120)//EP
@UnmappedField(name = "filler", length = 3, start = 117)
public class GRUNNBEP {

    @Felt(name="NORSK_BOSATT", length = 1, start = 0) private String bosattNorge;
    @Felt(name="TP_PROSENT", length = 2, start = 1) @PackedDecimal private int tpProsent;
    @Felt(name="OMSORG_AVD_BA", length = 1, start = 3) private String omsorgAvdodeBarn;
    @Felt(name="VILKAAR_10_5", length = 1, start = 4) private String vilkaarPar10Pkt5;
    @Felt(name="FORVENTET_INNT", length = 3, start = 5) @PackedDecimal private int forventetInntekt;
    @Felt(name="HJEMMEL_10_8", length = 1, start = 8) private String hjemmelPar10Pkt8;
    @Felt(name="FRAMLEGGSDATO_AAMD", length = 5, start = 9) @PackedDecimal private int framleggsdato;
    @Felt(name="FRAMLEGGSKODE", length = 1, start = 14) private String framleggskode;
    @Felt(name="FNR_EK", length = 6, start = 15) @PackedDecimal private int fodrselsnummerEktefelle;
    @Felt(name="NAVN_EK ", length = 25, start = 21) private String navnEktefelle;
    @Felt(name="DODSDATO_AAMD", length = 5, start = 46) @PackedDecimal private int dodsdato;
    @Felt(name="VILKAAR_8_4_3A", length = 1, start = 51) private String vilkaarPar4Pkt4Ledd3BokstavA;
    @Felt(name="FAI", length = 3, start = 52) @PackedDecimal private int framtidigArbeidsinntekt;
    @Felt(name="NORSK_BOSATT_EK", length = 1, start = 55) private String bosattNorgeEktefelle;
    @Felt(name="PIEK ", length = 4, start = 56) @PackedDecimal private int pensjonsgivendeInntektAvdodSisteAar;
    @Felt(name="VERNEPLIKTAAR1", length = 3, start = 60) @PackedDecimal private int vernepliktaar1;
    @Felt(name="VERNEPLIKTAAR2", length = 3, start = 63) @PackedDecimal private int vernepliktaar2;
    @Felt(name="VERNEPLIKTAAR3", length = 3, start = 66) @PackedDecimal private int vernepliktaar3;
    @Felt(name="VERNEPLIKTAAR4", length = 3, start = 69) @PackedDecimal private int vernepliktaar4;
    @Felt(name="GP_OS_KODE ", length = 1, start = 72) private String overgangsstonadEllerPensjonKode;
    @Felt(name="STATSBORGER", length = 2, start = 73) @PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT", length = 2, start = 75) @PackedDecimal private int bosattLand;
    @Felt(name="FRAVIK_BOSATT", length = 1, start = 77) private String fravikBosatt;
    @Felt(name="TRYGD3", length = 1, start = 78) private String trygdet3AarForDodsfall;
    @Felt(name="FRAVIK_TRYGDET_3AAR", length = 1, start = 79) private String fravikTrygdet3Aar;
    @Felt(name="FRAVIK_19_3", length = 1, start = 80) private String fravikPar19Pkt3;
    @Felt(name="FRAVIK_FLYKTN", length = 1, start = 81) private String erFlyktning;
    @Felt(name="KONVENSJON ", length = 1, start = 82) private String konvensjon;
    @Felt(name="FRAVIK_10_1", length = 1, start = 83) private String fravikPar10Pkt1;
    @Felt(name="OVERKOMP_UTL", length = 1, start = 84) private String overkompensasjonUtland;
    @Felt(name="TT_FRAMT_DOD", length = 2, start = 85) @PackedDecimal private int trygdetidFramTilDod;
    @Felt(name="TT_FOR_1967", length = 2, start = 87) @PackedDecimal private int trygdetidFor1967;
    @Felt(name="TT_ETTER_1966_AAR ", length = 2, start = 89) @PackedDecimal private int trygdetidEtter1966Aar;
    @Felt(name="TT_ETTER_1966_MM ", length = 2, start = 91) @PackedDecimal private int trygdetidEtter1966Maaneder;
    @Felt(name="TTFMT101 ", length = 2, start = 93) @PackedDecimal private int ttfmt101;
    @Felt(name="TRYGDET_DOD", length = 1, start = 95) private String trygdetVedDod;
    @Felt(name="TT_VENT_UTL", length = 2, start = 96) @PackedDecimal private int trygdetidVentUtland;
    @Felt(name="IKKE_GP ", length = 1, start = 98) private String ikkeGrunnpensjon;
    @Felt(name="STATSBEK ", length = 2, start = 99) @PackedDecimal private int statsborgerskapEktefelle;
    @Felt(name="BOSATTEK ", length = 2, start = 101) @PackedDecimal private int bosattLandEktefelle;
    @Felt(name="TRYGD3EK", length = 1, start = 103) private String trygdet3AarForDodsfallEktefelle;
    @Felt(name="FFLYKTEK", length = 1, start = 104) private String erFlyktningEktefelle;
    @Felt(name="OKUTLEK ", length = 1, start = 105) private String overkompensasjonUtlandEktefelle;
    @Felt(name="TRYGDET_DOD_EK ", length = 1, start = 106) private String trygdetVedDodEktefelle;
    @Felt(name="IKKE_TT_FRAMT", length = 1, start = 107) private String ikkeFramtidigTrygdetid;
    @Felt(name="TT_FOR_1967_EK", length = 2, start = 108) @PackedDecimal private int trygdetidFor1967Ektefelle;
    @Felt(name="TT_ETTER_1966_EK_AAR ", length = 2, start = 110) @PackedDecimal private int trygdetidEtter1966AarEktefelle;
    @Felt(name="TT_ETTER_1966_EK_MM ", length = 2, start = 112) @PackedDecimal private int trygdetidEtter1966MaanederEktefelle;
    @Felt(name="TTFT10EK ", length = 2, start = 114) @PackedDecimal private int framtidigTrygdetidEktefelle;
    @Felt(name="YSKADE_TILLEGG ", length = 1, start = 116) private String yrkesskadetillegg;

    public String getBosattNorge() {
        return bosattNorge;
    }

    public void setBosattNorge(String bosattNorge) {
        this.bosattNorge = bosattNorge;
    }

    public int getTpProsent() {
        return tpProsent;
    }

    public void setTpProsent(int tpProsent) {
        this.tpProsent = tpProsent;
    }

    public String getOmsorgAvdodeBarn() {
        return omsorgAvdodeBarn;
    }

    public void setOmsorgAvdodeBarn(String omsorgAvdodeBarn) {
        this.omsorgAvdodeBarn = omsorgAvdodeBarn;
    }

    public String getVilkaarPar10Pkt5() {
        return vilkaarPar10Pkt5;
    }

    public void setVilkaarPar10Pkt5(String vilkaarPar10Pkt5) {
        this.vilkaarPar10Pkt5 = vilkaarPar10Pkt5;
    }

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

    public int getFodrselsnummerEktefelle() {
        return fodrselsnummerEktefelle;
    }

    public void setFodrselsnummerEktefelle(int fodrselsnummerEktefelle) {
        this.fodrselsnummerEktefelle = fodrselsnummerEktefelle;
    }

    public String getNavnEktefelle() {
        return navnEktefelle;
    }

    public void setNavnEktefelle(String navnEktefelle) {
        this.navnEktefelle = navnEktefelle;
    }

    public int getDodsdato() {
        return dodsdato;
    }

    public void setDodsdato(int dodsdato) {
        this.dodsdato = dodsdato;
    }

    public String getVilkaarPar4Pkt4Ledd3BokstavA() {
        return vilkaarPar4Pkt4Ledd3BokstavA;
    }

    public void setVilkaarPar4Pkt4Ledd3BokstavA(String vilkaarPar4Pkt4Ledd3BokstavA) {
        this.vilkaarPar4Pkt4Ledd3BokstavA = vilkaarPar4Pkt4Ledd3BokstavA;
    }

    public int getFramtidigArbeidsinntekt() {
        return framtidigArbeidsinntekt;
    }

    public void setFramtidigArbeidsinntekt(int framtidigArbeidsinntekt) {
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt;
    }

    public String getBosattNorgeEktefelle() {
        return bosattNorgeEktefelle;
    }

    public void setBosattNorgeEktefelle(String bosattNorgeEktefelle) {
        this.bosattNorgeEktefelle = bosattNorgeEktefelle;
    }

    public int getPensjonsgivendeInntektAvdodSisteAar() {
        return pensjonsgivendeInntektAvdodSisteAar;
    }

    public void setPensjonsgivendeInntektAvdodSisteAar(int pensjonsgivendeInntektAvdodSisteAar) {
        this.pensjonsgivendeInntektAvdodSisteAar = pensjonsgivendeInntektAvdodSisteAar;
    }

    public int getVernepliktaar1() {
        return vernepliktaar1;
    }

    public void setVernepliktaar1(int vernepliktaar1) {
        this.vernepliktaar1 = vernepliktaar1;
    }

    public int getVernepliktaar2() {
        return vernepliktaar2;
    }

    public void setVernepliktaar2(int vernepliktaar2) {
        this.vernepliktaar2 = vernepliktaar2;
    }

    public int getVernepliktaar3() {
        return vernepliktaar3;
    }

    public void setVernepliktaar3(int vernepliktaar3) {
        this.vernepliktaar3 = vernepliktaar3;
    }

    public int getVernepliktaar4() {
        return vernepliktaar4;
    }

    public void setVernepliktaar4(int vernepliktaar4) {
        this.vernepliktaar4 = vernepliktaar4;
    }

    public String getOvergangsstonadEllerPensjonKode() {
        return overgangsstonadEllerPensjonKode;
    }

    public void setOvergangsstonadEllerPensjonKode(String overgangsstonadEllerPensjonKode) {
        this.overgangsstonadEllerPensjonKode = overgangsstonadEllerPensjonKode;
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

    public String getTrygdet3AarForDodsfall() {
        return trygdet3AarForDodsfall;
    }

    public void setTrygdet3AarForDodsfall(String trygdet3AarForDodsfall) {
        this.trygdet3AarForDodsfall = trygdet3AarForDodsfall;
    }

    public String getFravikTrygdet3Aar() {
        return fravikTrygdet3Aar;
    }

    public void setFravikTrygdet3Aar(String fravikTrygdet3Aar) {
        this.fravikTrygdet3Aar = fravikTrygdet3Aar;
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

    public String getKonvensjon() {
        return konvensjon;
    }

    public void setKonvensjon(String konvensjon) {
        this.konvensjon = konvensjon;
    }

    public String getFravikPar10Pkt1() {
        return fravikPar10Pkt1;
    }

    public void setFravikPar10Pkt1(String fravikPar10Pkt1) {
        this.fravikPar10Pkt1 = fravikPar10Pkt1;
    }

    public String getOverkompensasjonUtland() {
        return overkompensasjonUtland;
    }

    public void setOverkompensasjonUtland(String overkompensasjonUtland) {
        this.overkompensasjonUtland = overkompensasjonUtland;
    }

    public int getTrygdetidFramTilDod() {
        return trygdetidFramTilDod;
    }

    public void setTrygdetidFramTilDod(int trygdetidFramTilDod) {
        this.trygdetidFramTilDod = trygdetidFramTilDod;
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

    public int getTtfmt101() {
        return ttfmt101;
    }

    public void setTtfmt101(int ttfmt101) {
        this.ttfmt101 = ttfmt101;
    }

    public String getTrygdetVedDod() {
        return trygdetVedDod;
    }

    public void setTrygdetVedDod(String trygdetVedDod) {
        this.trygdetVedDod = trygdetVedDod;
    }

    public int getTrygdetidVentUtland() {
        return trygdetidVentUtland;
    }

    public void setTrygdetidVentUtland(int trygdetidVentUtland) {
        this.trygdetidVentUtland = trygdetidVentUtland;
    }

    public String getIkkeGrunnpensjon() {
        return ikkeGrunnpensjon;
    }

    public void setIkkeGrunnpensjon(String ikkeGrunnpensjon) {
        this.ikkeGrunnpensjon = ikkeGrunnpensjon;
    }

    public int getStatsborgerskapEktefelle() {
        return statsborgerskapEktefelle;
    }

    public void setStatsborgerskapEktefelle(int statsborgerskapEktefelle) {
        this.statsborgerskapEktefelle = statsborgerskapEktefelle;
    }

    public int getBosattLandEktefelle() {
        return bosattLandEktefelle;
    }

    public void setBosattLandEktefelle(int bosattLandEktefelle) {
        this.bosattLandEktefelle = bosattLandEktefelle;
    }

    public String getTrygdet3AarForDodsfallEktefelle() {
        return trygdet3AarForDodsfallEktefelle;
    }

    public void setTrygdet3AarForDodsfallEktefelle(String trygdet3AarForDodsfallEktefelle) {
        this.trygdet3AarForDodsfallEktefelle = trygdet3AarForDodsfallEktefelle;
    }

    public String getErFlyktningEktefelle() {
        return erFlyktningEktefelle;
    }

    public void setErFlyktningEktefelle(String erFlyktningEktefelle) {
        this.erFlyktningEktefelle = erFlyktningEktefelle;
    }

    public String getOverkompensasjonUtlandEktefelle() {
        return overkompensasjonUtlandEktefelle;
    }

    public void setOverkompensasjonUtlandEktefelle(String overkompensasjonUtlandEktefelle) {
        this.overkompensasjonUtlandEktefelle = overkompensasjonUtlandEktefelle;
    }

    public String getTrygdetVedDodEktefelle() {
        return trygdetVedDodEktefelle;
    }

    public void setTrygdetVedDodEktefelle(String trygdetVedDodEktefelle) {
        this.trygdetVedDodEktefelle = trygdetVedDodEktefelle;
    }

    public String getIkkeFramtidigTrygdetid() {
        return ikkeFramtidigTrygdetid;
    }

    public void setIkkeFramtidigTrygdetid(String ikkeFramtidigTrygdetid) {
        this.ikkeFramtidigTrygdetid = ikkeFramtidigTrygdetid;
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

    public int getFramtidigTrygdetidEktefelle() {
        return framtidigTrygdetidEktefelle;
    }

    public void setFramtidigTrygdetidEktefelle(int framtidigTrygdetidEktefelle) {
        this.framtidigTrygdetidEktefelle = framtidigTrygdetidEktefelle;
    }

    public String getYrkesskadetillegg() {
        return yrkesskadetillegg;
    }

    public void setYrkesskadetillegg(String yrkesskadetillegg) {
        this.yrkesskadetillegg = yrkesskadetillegg;
    }
}
