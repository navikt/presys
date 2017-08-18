package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBUP", length = 118)
@UnmappedField(name="primdiag", length = 6, start = 12)//primærdiagnose
@UnmappedField(name="sekudiag", length = 6, start = 18)//sekundærdiagnose
@UnmappedField(name = "filler", length = 7, start = 111)
public class Grunnbup {

    @Felt(name="Ektefelle_till", length = 1, start = 0)
    private String ektefelletillegg;

    @Felt(name="bt_ant", length = 2, start = 1)
    @PackedDecimal
    private int anntallBarn;

    @Felt(name="ufg", length = 2, start = 3)
    @PackedDecimal
    private int uforegrad;

    @Felt(name="uft", length = 5, start = 5)
    @PackedDecimal
    private int uforetidspunkt;

    @Felt(name="yrke", length = 2, start = 10)
    @PackedDecimal
    private int yrke;
    // unmapped 12 - 23
    @Felt(name="vilkaar_8_4_3A", length = 1, start = 24)
    private String vilkaar843A;

    @Felt(name="vilkaar_8_1b", length = 1, start = 25)
    private String vilkaar81B;

    @Felt(name="fnr_ek", length = 6, start = 26)
    @PackedDecimal
    private int fodselsnummerEktefelle;

    @Felt(name="navn_ek", length = 25, start = 32)
    private String navnEktefelle;

    @Felt(name="nbosatt", length = 1, start = 57)
    private String norskINorgeMedlem;

    @Felt(name="vernepliktr1", length = 3, start = 58)
    @PackedDecimal
    private int vernepliktAar1;

    @Felt(name="vernepliktr2", length = 3, start = 61)
    @PackedDecimal
    private int vernepliktAar2;

    @Felt(name="vernepliktr3", length = 3, start = 64)
    @PackedDecimal
    private int vernepliktAar3;

    @Felt(name="vernepliktr4", length = 3, start = 67)
    @PackedDecimal
    private int vernepliktAar4;

    @Felt(name="pi", length = 4, start = 70)
    @PackedDecimal
    private int pensjonsgivendeInntekt;

    @Felt(name="statsborger", length = 2, start = 74)
    @PackedDecimal
    private int statsborgerskap;

    @Felt(name="bosatt", length = 2, start = 76)
    @PackedDecimal
    private int bosattLand;

    @Felt(name="fravik_bosatt", length = 1, start = 78)
    private String fravikBosatt;

    @Felt(name="trygd3", length = 1, start = 79)
    private String trygd3;

    @Felt(name="fravik_trygdet_3aar", length = 1, start = 80)
    private String fravikTrygdet3Aar;

    @Felt(name="fravik_8_1", length = 1, start = 81)
    private String fravik81;

    @Felt(name="konvensjon", length = 1, start = 82)
    private String konvensjon;

    @Felt(name="fravik_19_3", length = 1, start = 83)
    private String fravik193;

    @Felt(name="fravik_flyktn", length = 1, start = 84)
    private String fravikFlyktning;

    @Felt(name="overkompUtl", length = 1, start = 85)
    private String overkompUtl;

    @Felt(name="ufor_under_botid", length = 1, start = 86)
    private String uforUnderBotid;

    @Felt(name="tt_for_1967", length = 2, start = 87)
    @PackedDecimal
    private int trygdetidFor1967;

    @Felt(name="tt_etter_1966_aar", length = 2, start = 89)
    @PackedDecimal
    private int trygdetidEtter1966Aar;

    @Felt(name="tt_etter_1966_mm", length = 2, start = 91)
    @PackedDecimal
    private int trygdetidEtter1966Maaneder;

    @Felt(name="trygdetid_for_1967_ek", length = 2, start = 93)
    @PackedDecimal
    private int trygdetidFor1967Ektefelle;

    @Felt(name="tt_etter_1966_ek_aar", length = 2, start = 95)
    @PackedDecimal
    private int trygdetidEtter1966AarEktefelle;

    @Felt(name="tt_etter_1966_ek_mm", length = 2, start = 97)
    @PackedDecimal
    private int trygdetidEtter1966MaanederEktefelle;

    @Felt(name="ttfmt81", length = 2, start = 99)
    @PackedDecimal
    private int ttfmt81;

    @Felt(name="ttFramtUft", length = 2, start = 101)
    @PackedDecimal
    private int ttFramtUft;

    @Felt(name="ikke_gp", length = 1, start = 103)
    private String ikkeGrunnpensjon;

    @Felt(name="inntektMinst4g", length = 1, start = 104)
    private String inntektMinst4g;

    @Felt(name="att_uf", length = 1, start = 105)
    private String attforingUfore;

    @Felt(name="yskade_tillegg", length = 1, start = 106)
    private String yrkesskadetillegg;

    @Felt(name="inntekt_for_up", length = 4, start = 107)
    @PackedDecimal
    private int inntektForUforepensjon;


    public String getEktefelletillegg() {
        return ektefelletillegg;
    }

    public void setEktefelletillegg(String ektefelletillegg) {
        this.ektefelletillegg = ektefelletillegg;
    }

    public int getAnntallBarn() {
        return anntallBarn;
    }

    public void setAnntallBarn(int anntallBarn) {
        this.anntallBarn = anntallBarn;
    }

    public int getUforegrad() {
        return uforegrad;
    }

    public void setUforegrad(int uforegrad) {
        this.uforegrad = uforegrad;
    }

    public int getUforetidspunkt() {
        return uforetidspunkt;
    }

    public void setUforetidspunkt(int uforetidspunkt) {
        this.uforetidspunkt = uforetidspunkt;
    }

    public int getYrke() {
        return yrke;
    }

    public void setYrke(int yrke) {
        this.yrke = yrke;
    }

    public String getVilkaar843A() {
        return vilkaar843A;
    }

    public void setVilkaar843A(String vilkaar843A) {
        this.vilkaar843A = vilkaar843A;
    }

    public String getVilkaar81B() {
        return vilkaar81B;
    }

    public void setVilkaar81B(String vilkaar81B) {
        this.vilkaar81B = vilkaar81B;
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

    public String getNorskINorgeMedlem() {
        return norskINorgeMedlem;
    }

    public void setNorskINorgeMedlem(String norskINorgeMedlem) {
        this.norskINorgeMedlem = norskINorgeMedlem;
    }

    public int getVernepliktAar1() {
        return vernepliktAar1;
    }

    public void setVernepliktAar1(int vernepliktAar1) {
        this.vernepliktAar1 = vernepliktAar1;
    }

    public int getVernepliktAar2() {
        return vernepliktAar2;
    }

    public void setVernepliktAar2(int vernepliktAar2) {
        this.vernepliktAar2 = vernepliktAar2;
    }

    public int getVernepliktAar3() {
        return vernepliktAar3;
    }

    public void setVernepliktAar3(int vernepliktAar3) {
        this.vernepliktAar3 = vernepliktAar3;
    }

    public int getVernepliktAar4() {
        return vernepliktAar4;
    }

    public void setVernepliktAar4(int vernepliktAar4) {
        this.vernepliktAar4 = vernepliktAar4;
    }

    public int getPensjonsgivendeInntekt() {
        return pensjonsgivendeInntekt;
    }

    public void setPensjonsgivendeInntekt(int pensjonsgivendeInntekt) {
        this.pensjonsgivendeInntekt = pensjonsgivendeInntekt;
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

    public String getFravik81() {
        return fravik81;
    }

    public void setFravik81(String fravik81) {
        this.fravik81 = fravik81;
    }

    public String getKonvensjon() {
        return konvensjon;
    }

    public void setKonvensjon(String konvensjon) {
        this.konvensjon = konvensjon;
    }

    public String getFravik193() {
        return fravik193;
    }

    public void setFravik193(String fravik193) {
        this.fravik193 = fravik193;
    }

    public String getFravikFlyktning() {
        return fravikFlyktning;
    }

    public void setFravikFlyktning(String fravikFlyktning) {
        this.fravikFlyktning = fravikFlyktning;
    }

    public String getOverkompUtl() {
        return overkompUtl;
    }

    public void setOverkompUtl(String overkompUtl) {
        this.overkompUtl = overkompUtl;
    }

    public String getUforUnderBotid() {
        return uforUnderBotid;
    }

    public void setUforUnderBotid(String uforUnderBotid) {
        this.uforUnderBotid = uforUnderBotid;
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

    public int getTtfmt81() {
        return ttfmt81;
    }

    public void setTtfmt81(int ttfmt81) {
        this.ttfmt81 = ttfmt81;
    }

    public int getTtFramtUft() {
        return ttFramtUft;
    }

    public void setTtFramtUft(int ttFramtUft) {
        this.ttFramtUft = ttFramtUft;
    }

    public String getIkkeGrunnpensjon() {
        return ikkeGrunnpensjon;
    }

    public void setIkkeGrunnpensjon(String ikkeGrunnpensjon) {
        this.ikkeGrunnpensjon = ikkeGrunnpensjon;
    }

    public String getInntektMinst4g() {
        return inntektMinst4g;
    }

    public void setInntektMinst4g(String inntektMinst4g) {
        this.inntektMinst4g = inntektMinst4g;
    }

    public String getAttforingUfore() {
        return attforingUfore;
    }

    public void setAttforingUfore(String attforingUfore) {
        this.attforingUfore = attforingUfore;
    }

    public String getYrkesskadetillegg() {
        return yrkesskadetillegg;
    }

    public void setYrkesskadetillegg(String yrkesskadetillegg) {
        this.yrkesskadetillegg = yrkesskadetillegg;
    }

    public int getInntektForUforepensjon() {
        return inntektForUforepensjon;
    }

    public void setInntektForUforepensjon(int inntektForUforepensjon) {
        this.inntektForUforepensjon = inntektForUforepensjon;
    }
}
