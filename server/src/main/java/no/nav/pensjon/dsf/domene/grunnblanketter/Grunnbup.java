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
    private int anntall_barn;

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
    @Felt(name="vilkaar_8_4_3a", length = 1, start = 24)
    private String vilkaar_8_4_3a;

    @Felt(name="vilkaar_8_1b", length = 1, start = 25)
    private String vilkaar_8_1b;

    @Felt(name="fnr_ek", length = 6, start = 26)
    @PackedDecimal
    private int fodselsnummer_ektefelle;

    @Felt(name="navn_ek", length = 25, start = 32)
    private String navn_ektefelle;

    @Felt(name="nbosatt", length = 1, start = 57)
    private String norsk_i_norge_medlem;

    @Felt(name="vernepliktr1", length = 3, start = 58)
    @PackedDecimal
    private int verneplikt_aar1;

    @Felt(name="vernepliktr2", length = 3, start = 61)
    @PackedDecimal
    private int verneplikt_aar2;

    @Felt(name="vernepliktr3", length = 3, start = 64)
    @PackedDecimal
    private int verneplikt_aar3;

    @Felt(name="vernepliktr4", length = 3, start = 67)
    @PackedDecimal
    private int verneplikt_aar4;

    @Felt(name="pi", length = 4, start = 70)
    @PackedDecimal
    private int pensjonsgivende_inntekt;

    @Felt(name="statsborger", length = 2, start = 74)
    @PackedDecimal
    private int statsborgerskap;

    @Felt(name="bosatt", length = 2, start = 76)
    @PackedDecimal
    private int bosatt_land;

    @Felt(name="fravik_bosatt", length = 1, start = 78)
    private String fravik_bosatt;

    @Felt(name="trygd3", length = 1, start = 79)
    private String trygd3;

    @Felt(name="fravik_trygdet_3aar", length = 1, start = 80)
    private String fravik_trygdet_3aar;

    @Felt(name="fravik_8_1", length = 1, start = 81)
    private String fravik_8_1;

    @Felt(name="konvensjon", length = 1, start = 82)
    private String konvensjon;

    @Felt(name="fravik_19_3", length = 1, start = 83)
    private String fravik_19_3;

    @Felt(name="fravik_flyktn", length = 1, start = 84)
    private String fravik_flyktning;

    @Felt(name="overkomp_utl", length = 1, start = 85)
    private String overkomp_utl;

    @Felt(name="ufor_under_botid", length = 1, start = 86)
    private String ufor_under_botid;

    @Felt(name="tt_for_1967", length = 2, start = 87)
    @PackedDecimal
    private int trygdetid_for_1967;

    @Felt(name="tt_etter_1966_aar", length = 2, start = 89)
    @PackedDecimal
    private int trygdetid_etter_1966_aar;

    @Felt(name="tt_etter_1966_mm", length = 2, start = 91)
    @PackedDecimal
    private int trygdetid_etter_1966_maaneder;

    @Felt(name="trygdetid_for_1967_ek", length = 2, start = 93)
    @PackedDecimal
    private int trygdetid_for_1967_ektefelle;

    @Felt(name="tt_etter_1966_ek_aar", length = 2, start = 95)
    @PackedDecimal
    private int trygdetid_etter_1966_aar_ektefelle;

    @Felt(name="tt_etter_1966_ek_mm", length = 2, start = 97)
    @PackedDecimal
    private int trygdetid_etter_1966_maaneder_ektefelle;

    @Felt(name="ttfmt81", length = 2, start = 99)
    @PackedDecimal
    private int ttfmt81;

    @Felt(name="tt_framt_uft", length = 2, start = 101)
    @PackedDecimal
    private int tt_framt_uft;

    @Felt(name="ikke_gp", length = 1, start = 103)
    private String ikke_grunnpensjon;

    @Felt(name="innt_minst_4g", length = 1, start = 104)
    private String innt_minst_4g;

    @Felt(name="att_uf", length = 1, start = 105)
    private String attforing_ufore;

    @Felt(name="yskade_tillegg", length = 1, start = 106)
    private String yrkesskadetillegg;

    @Felt(name="inntekt_for_up", length = 4, start = 107)
    @PackedDecimal
    private int inntekt_for_uforepensjon;


    public String getEktefelletillegg() {
        return ektefelletillegg;
    }

    public void setEktefelletillegg(String ektefelletillegg) {
        this.ektefelletillegg = ektefelletillegg;
    }

    public int getAnntall_barn() {
        return anntall_barn;
    }

    public void setAnntall_barn(int anntall_barn) {
        this.anntall_barn = anntall_barn;
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

    public String getVilkaar_8_4_3a() {
        return vilkaar_8_4_3a;
    }

    public void setVilkaar_8_4_3a(String vilkaar_8_4_3a) {
        this.vilkaar_8_4_3a = vilkaar_8_4_3a;
    }

    public String getVilkaar_8_1b() {
        return vilkaar_8_1b;
    }

    public void setVilkaar_8_1b(String vilkaar_8_1b) {
        this.vilkaar_8_1b = vilkaar_8_1b;
    }

    public int getFodselsnummer_ektefelle() {
        return fodselsnummer_ektefelle;
    }

    public void setFodselsnummer_ektefelle(int fodselsnummer_ektefelle) {
        this.fodselsnummer_ektefelle = fodselsnummer_ektefelle;
    }

    public String getNavn_ektefelle() {
        return navn_ektefelle;
    }

    public void setNavn_ektefelle(String navn_ektefelle) {
        this.navn_ektefelle = navn_ektefelle;
    }

    public String getNorsk_i_norge_medlem() {
        return norsk_i_norge_medlem;
    }

    public void setNorsk_i_norge_medlem(String norsk_i_norge_medlem) {
        this.norsk_i_norge_medlem = norsk_i_norge_medlem;
    }

    public int getVerneplikt_aar1() {
        return verneplikt_aar1;
    }

    public void setVerneplikt_aar1(int verneplikt_aar1) {
        this.verneplikt_aar1 = verneplikt_aar1;
    }

    public int getVerneplikt_aar2() {
        return verneplikt_aar2;
    }

    public void setVerneplikt_aar2(int verneplikt_aar2) {
        this.verneplikt_aar2 = verneplikt_aar2;
    }

    public int getVerneplikt_aar3() {
        return verneplikt_aar3;
    }

    public void setVerneplikt_aar3(int verneplikt_aar3) {
        this.verneplikt_aar3 = verneplikt_aar3;
    }

    public int getVerneplikt_aar4() {
        return verneplikt_aar4;
    }

    public void setVerneplikt_aar4(int verneplikt_aar4) {
        this.verneplikt_aar4 = verneplikt_aar4;
    }

    public int getPensjonsgivende_inntekt() {
        return pensjonsgivende_inntekt;
    }

    public void setPensjonsgivende_inntekt(int pensjonsgivende_inntekt) {
        this.pensjonsgivende_inntekt = pensjonsgivende_inntekt;
    }

    public int getStatsborgerskap() {
        return statsborgerskap;
    }

    public void setStatsborgerskap(int statsborgerskap) {
        this.statsborgerskap = statsborgerskap;
    }

    public int getBosatt_land() {
        return bosatt_land;
    }

    public void setBosatt_land(int bosatt_land) {
        this.bosatt_land = bosatt_land;
    }

    public String getFravik_bosatt() {
        return fravik_bosatt;
    }

    public void setFravik_bosatt(String fravik_bosatt) {
        this.fravik_bosatt = fravik_bosatt;
    }

    public String getTrygd3() {
        return trygd3;
    }

    public void setTrygd3(String trygd3) {
        this.trygd3 = trygd3;
    }

    public String getFravik_trygdet_3aar() {
        return fravik_trygdet_3aar;
    }

    public void setFravik_trygdet_3aar(String fravik_trygdet_3aar) {
        this.fravik_trygdet_3aar = fravik_trygdet_3aar;
    }

    public String getFravik_8_1() {
        return fravik_8_1;
    }

    public void setFravik_8_1(String fravik_8_1) {
        this.fravik_8_1 = fravik_8_1;
    }

    public String getKonvensjon() {
        return konvensjon;
    }

    public void setKonvensjon(String konvensjon) {
        this.konvensjon = konvensjon;
    }

    public String getFravik_19_3() {
        return fravik_19_3;
    }

    public void setFravik_19_3(String fravik_19_3) {
        this.fravik_19_3 = fravik_19_3;
    }

    public String getFravik_flyktning() {
        return fravik_flyktning;
    }

    public void setFravik_flyktning(String fravik_flyktning) {
        this.fravik_flyktning = fravik_flyktning;
    }

    public String getOverkomp_utl() {
        return overkomp_utl;
    }

    public void setOverkomp_utl(String overkomp_utl) {
        this.overkomp_utl = overkomp_utl;
    }

    public String getUfor_under_botid() {
        return ufor_under_botid;
    }

    public void setUfor_under_botid(String ufor_under_botid) {
        this.ufor_under_botid = ufor_under_botid;
    }

    public int getTrygdetid_for_1967() {
        return trygdetid_for_1967;
    }

    public void setTrygdetid_for_1967(int trygdetid_for_1967) {
        this.trygdetid_for_1967 = trygdetid_for_1967;
    }

    public int getTrygdetid_etter_1966_aar() {
        return trygdetid_etter_1966_aar;
    }

    public void setTrygdetid_etter_1966_aar(int trygdetid_etter_1966_aar) {
        this.trygdetid_etter_1966_aar = trygdetid_etter_1966_aar;
    }

    public int getTrygdetid_etter_1966_maaneder() {
        return trygdetid_etter_1966_maaneder;
    }

    public void setTrygdetid_etter_1966_maaneder(int trygdetid_etter_1966_maaneder) {
        this.trygdetid_etter_1966_maaneder = trygdetid_etter_1966_maaneder;
    }

    public int getTrygdetid_for_1967_ektefelle() {
        return trygdetid_for_1967_ektefelle;
    }

    public void setTrygdetid_for_1967_ektefelle(int trygdetid_for_1967_ektefelle) {
        this.trygdetid_for_1967_ektefelle = trygdetid_for_1967_ektefelle;
    }

    public int getTrygdetid_etter_1966_aar_ektefelle() {
        return trygdetid_etter_1966_aar_ektefelle;
    }

    public void setTrygdetid_etter_1966_aar_ektefelle(int trygdetid_etter_1966_aar_ektefelle) {
        this.trygdetid_etter_1966_aar_ektefelle = trygdetid_etter_1966_aar_ektefelle;
    }

    public int getTrygdetid_etter_1966_maaneder_ektefelle() {
        return trygdetid_etter_1966_maaneder_ektefelle;
    }

    public void setTrygdetid_etter_1966_maaneder_ektefelle(int trygdetid_etter_1966_maaneder_ektefelle) {
        this.trygdetid_etter_1966_maaneder_ektefelle = trygdetid_etter_1966_maaneder_ektefelle;
    }

    public int getTtfmt81() {
        return ttfmt81;
    }

    public void setTtfmt81(int ttfmt81) {
        this.ttfmt81 = ttfmt81;
    }

    public int getTt_framt_uft() {
        return tt_framt_uft;
    }

    public void setTt_framt_uft(int tt_framt_uft) {
        this.tt_framt_uft = tt_framt_uft;
    }

    public String getIkke_grunnpensjon() {
        return ikke_grunnpensjon;
    }

    public void setIkke_grunnpensjon(String ikke_grunnpensjon) {
        this.ikke_grunnpensjon = ikke_grunnpensjon;
    }

    public String getInnt_minst_4g() {
        return innt_minst_4g;
    }

    public void setInnt_minst_4g(String innt_minst_4g) {
        this.innt_minst_4g = innt_minst_4g;
    }

    public String getAttforing_ufore() {
        return attforing_ufore;
    }

    public void setAttforing_ufore(String attforing_ufore) {
        this.attforing_ufore = attforing_ufore;
    }

    public String getYrkesskadetillegg() {
        return yrkesskadetillegg;
    }

    public void setYrkesskadetillegg(String yrkesskadetillegg) {
        this.yrkesskadetillegg = yrkesskadetillegg;
    }

    public int getInntekt_for_uforepensjon() {
        return inntekt_for_uforepensjon;
    }

    public void setInntekt_for_uforepensjon(int inntekt_for_uforepensjon) {
        this.inntekt_for_uforepensjon = inntekt_for_uforepensjon;
    }
}
