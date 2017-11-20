package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

@Segment(name = "GRUNNBU3" , length = 224)
@UnmappedField(name="FRAVIK_5_1", length = 1, start = 130)
/*
@UnmappedField(name="EOS_AAR_IKKE_PRO_RATA (1967:2014)", length = 6, start = 198)
@UnmappedField(name="EOS_AAR_1967_2014", length = 6, start = 176)
*/
@UnmappedField(name = "filler", length = 17, start = 207)
public class GRUNNBU3 {

    @Felt(name="ATT_UF", length = 1, start = 0)
    private String attforingUfor;

    @Felt(name="NAVN", length = 25, start = 1)
    private String navn;

    @Felt(name="NORSK_BOSATT", length = 1, start = 26)
    private String bosattNorge;

    @Felt(name="TILL_EK", length = 1, start = 27)
    private String ektefelletillegg;

    @Felt(name="TILL_BARN", length = 1, start = 28)
    private String barnetillegg;

    @Felt(name="VP_TAB1", length = 3, start = 29)
    @PackedDecimal
    private int vernepliktaar1;

    @Felt(name="VP_TAB2", length = 3, start = 32)
    @PackedDecimal
    private int vernepliktaar2;

    @Felt(name="VP_TAB3", length = 3, start = 35)
    @PackedDecimal
    private int vernepliktaar3;

    @Felt(name="VP_TAB4", length = 3, start = 38)
    @PackedDecimal
    private int vernepliktaar4;

    @Felt(name="VILKAAR_8_4_3A", length = 1, start = 41)
    private String vilkaarPar8Pkt4Ledd3BokstavA;

    @Felt(name="PI", length = 4, start = 42)
    @PackedDecimal
    private int pensjonsgivendeInntekt;

    @Felt(name="YNGSTE_BARN_FAAR", length = 3, start = 46)
    @PackedDecimal
    private int yngsteBarnFodselsaar;

    @Felt(name="YSKADE_TILLEGG", length = 1, start = 49)
    private String yrkesskadetillegg;

    @Felt(name="YRKESM_ATTF", length = 1, start = 50)
    private String yrkesmessigAttforing;

    @Felt(name="UTDANNING", length = 2, start = 51)
    @PackedDecimal
    private int utdanning;

    @Felt(name="YRKE", length = 2, start = 53)
    @PackedDecimal
    private int yrke;

    @Felt(name="UFG", length = 2, start = 55)
    @PackedDecimal
    private int uforegrad;

    @Felt(name="UFT_AAMD", length = 5, start = 57)
    @PackedDecimal
    private int uforetidspunkt;

    @Felt(name="FRIINNTEKT_DATO_AAMD", length = 5, start = 62)
    @PackedDecimal
    private int friinntektDato;

    @Felt(name="VIRK_DATO_AAMD", length = 5, start = 67)
    @PackedDecimal
    private int virkningsdato;

    @Felt(name="FNR_EK", length = 6, start = 72)
    @PackedDecimal
    private String fodselsnummerEktefelle;

    @Felt(name="NAVN_EK", length = 25, start = 78)
    private String navnEktefelle;

    @Felt(name="STATSBORGER", length = 2, start = 103)
    @PackedDecimal
    private int statsborgerskap;

    @Felt(name="BOSATT", length = 2, start = 105)
    @PackedDecimal
    private int bosattLand;

    @Felt(name="UNNTAK_12_2", length = 1, start = 107)
    private String unntakPar12Pkt2;

    @Felt(name="STI_AAMD_3B", length = 5, start = 108)
    @PackedDecimal
    private int stonadstilfelleDato3B;

    @Felt(name="FRAVIK_8_1_3C", length = 1, start = 113)
    private String fravikPar2Pkt1Ledd3BokstavC;

    @Felt(name="STI_AAMD_3C", length = 5, start = 114)
    @PackedDecimal
    private int stonadstilfelleDato3C;

    @Felt(name="PENSJONSTRYGDET", length = 1, start = 119)
    private String pensjonstrygdet;

    @Felt(name="TT_LIK_PAA", length = 1, start = 120)
    private String  grunnPensjonBeregnetPaaTrygdetidLikPoengaar;

    @Felt(name="MINST_20_AAR", length = 1, start = 121)
    private String minst20Aar;

    @Felt(name="KONVENSJON", length = 1, start = 122)
    private String folgerKonvensjonMedAndreLand;

    @Felt(name="KONVENSJON_LAND", length = 2, start = 123)
    @PackedDecimal
    private int konvensjonsLand;

    @Felt(name="FRAVIK_BOSATT_EOS", length = 1, start = 125)
    private String fravikBosattEOS;

    @Felt(name="FRAVIK_8_1", length = 1, start = 126)
    private String fravikPar8Pkt1;

    @Felt(name="TT_PAA", length = 1, start = 127)
    private String trygdetidLikPoengaar;

    @Felt(name="TT_FRAMTIDIG", length = 1, start = 128)
    private String beregneFramtidigTrygdetid;

    @Felt(name="TT_FAKTISK", length = 1, start = 129)
    private String beregneFaktiskTrygdetid;

    //Unmapped "FRAVIK_5_1", length = 1, start = 130)

    @Felt(name="UNG_UFOR", length = 1, start = 131)
    private String ungUfor;

    @Felt(name="FRAVIK_FLYKT", length = 1, start = 132)
    private String godkjentFlyktningUDI;

    @Felt(name="OVERKOMP_UTL", length = 1, start = 133)
    private String overkompensert;

    @Felt(name="TT_FRA1937_AAR", length = 2, start = 134)
    @PackedDecimal
    private int trygdetidFra1937Aar;

    @Felt(name="TT_FRA1937_MND", length = 2, start = 136)
    @PackedDecimal
    private int trygdetidFra1937Maaneder;

    @Felt(name="TT_F67", length = 2, start = 138)
    @PackedDecimal
    private int trygdetidFor1967Aar;

    @Felt(name="TT_E66_AA", length = 2, start = 140)
    @PackedDecimal
    private int trygdetidEtter1966Aar;

    @Felt(name="TT_E66_M", length = 2, start = 142)
    @PackedDecimal
    private int trygdetidEtter1966Maaneder;

    @Felt(name="TT_F67_EK", length = 2, start = 144)
    @PackedDecimal
    private int trygdetidFor1967AarEktefelle;

    @Felt(name="TT_E66_AA_EK", length = 2, start = 146)
    @PackedDecimal
    private int trygdetidEtter1966AarEktefelle;

    @Felt(name="TT_E66_M_EK", length = 2, start = 148)
    @PackedDecimal
    private int trygdetidEtter1966MaanederEktefelle;

    @Felt(name="FRAVIK_19_3", length = 1, start = 150)
    private String fravikpar19Pkt3;

    @Felt(name="TT_ENDRES", length = 1, start = 151)
    private String trygdetidEndres;

    @Felt(name="TT_NORDEN_ANNET", length = 1, start = 152)
    private String trygdetidAnnetNordiskLand;

    @Felt(name="IKKE_GP", length = 1, start = 153)
    private String ikkeBeregneGrunnpensjon;

    @Felt(name="AVKORT_SAERTILL", length = 1, start = 154)
    private String avkorteSaertillegg;

    @Felt(name="TP_NORDISK", length = 3, start = 155)
    @PackedDecimal
    private int tilleggspensjonFraAnnetNordiskland;

    @Felt(name="TP_NORDISK_LAND", length = 2, start = 158)
    @PackedDecimal
    private int tilleggspensjonsland;

    @Felt(name="BEREGNING_KONV", length = 1, start = 160)
    private String beregningKonvensjon;

    @Felt(name="TT_KONVENSJON_AAR", length = 2, start = 161)
    @PackedDecimal
    private int trygdetidKonvensjonAar;

    @Felt(name="BEREGN_FOLKETRYGD", length = 1, start = 163)
    private String beregneFolketrygd;

    @Felt(name="EOS_8_4_3A", length = 1, start = 164)
    private String eosPar8Pkt4Ledd3BokstavA;

    @Felt(name="TT_TEORETISK_EOS_AAR", length = 2, start = 165)
    @PackedDecimal
    private int teoretiskTrygdetidEOSAar;

    @Felt(name="TT_TEORETISK_EOS_MND", length = 2, start = 167)
    @PackedDecimal
    private int teoretiskTrygdetidEOSMaaneder;

    @Felt(name="TT_PRORATA_EOS_AAR", length = 2, start = 169)
    @PackedDecimal
    private int prorataTrygdetidEOSAar;

    @Felt(name="TT_PRORATA_EOS_MND", length = 2, start = 171)
    @PackedDecimal
    private int prorataTrygdetidEOSMaaneder;

    @Felt(name="PENSJON_EOS", length = 3, start = 173)
    @PackedDecimal
    private int pensjonEOS;

    @Felt(name="EOS_AAR_1967_2014", length = 6, start = 176)
    @BitTabell
    private boolean[] poengaarIEOS;

    @Felt(name="INNTEKT_FOR_UP", length = 4, start = 182)
    @PackedDecimal
    private int inntektForUforepensjon;

    @Felt(name="TT_FAKTISK_NORDISK_AAR", length = 2, start = 186)
    @PackedDecimal
    private int faktiskNordiskTrygdetidAar;

    @Felt(name="TT_FAKTISK_NORDISK_MND", length = 2, start = 188)
    @PackedDecimal
    private int faktiskNordiskTrygdetidMaaneder;

    @Felt(name="PAA_FAKTISK_NORDISK", length = 2, start = 190)
    @PackedDecimal
    private int faktiskeNordiskePoengaar;

    @Felt(name="REAKTIVISERING", length = 1, start = 192)
    private String reaktivisering;

    @Felt(name="UNNTAK_VENTETID", length = 1, start = 193)
    private String unntakVentetid;

    @Felt(name="EK_INNT_OVER_2G", length = 1, start = 194)
    private String ektefelleInntektOver2G;

    @Felt(name="GARANTERT_TP", length = 1, start = 195)
    private String garantiTilleggspensjon;

    @Felt(name="FRYSP_5AAR_ARB", length = 1, start = 196)
    private String frysp5AarArbeid;

    @Felt(name="FRYSP_TIDSB", length = 1, start = 197)
    private String fryspTidsb;

    @Felt(name="EOS_AAR_IKKE_PRO_RATA (1967:2014)", length = 6, start = 198)
    @BitTabell
    private boolean[]poengaarIEOSIkkeMedIProrata;

    @Felt(name="RED_GP_3_2_5", length = 1, start = 204)
    private String reduksjonGrunnpensjonEtterPar3Pkt2Ledd5;

    @Felt(name="EOS_OPPLYSN", length = 1, start = 205)
    private String eosOpplysning;

    @Felt(name="LONNSTILSKUDD", length = 1, start = 206)
    private String lonnstilskudd;

    public String getAttforingUfor() {
        return attforingUfor;
    }

    public void setAttforingUfor(String attforingUfor) {
        this.attforingUfor = attforingUfor;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBosattNorge() {
        return bosattNorge;
    }

    public void setBosattNorge(String bosattNorge) {
        this.bosattNorge = bosattNorge;
    }

    public String getEktefelletillegg() {
        return ektefelletillegg;
    }

    public void setEktefelletillegg(String ektefelletillegg) {
        this.ektefelletillegg = ektefelletillegg;
    }

    public String getBarnetillegg() {
        return barnetillegg;
    }

    public void setBarnetillegg(String barnetillegg) {
        this.barnetillegg = barnetillegg;
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

    public String getVilkaarPar8Pkt4Ledd3BokstavA() {
        return vilkaarPar8Pkt4Ledd3BokstavA;
    }

    public void setVilkaarPar8Pkt4Ledd3BokstavA(String vilkaarPar8Pkt4Ledd3BokstavA) {
        this.vilkaarPar8Pkt4Ledd3BokstavA = vilkaarPar8Pkt4Ledd3BokstavA;
    }

    public int getPensjonsgivendeInntekt() {
        return pensjonsgivendeInntekt;
    }

    public void setPensjonsgivendeInntekt(int pensjonsgivendeInntekt) {
        this.pensjonsgivendeInntekt = pensjonsgivendeInntekt;
    }

    public int getYngsteBarnFodselsaar() {
        return yngsteBarnFodselsaar;
    }

    public void setYngsteBarnFodselsaar(int yngsteBarnFodselsaar) {
        this.yngsteBarnFodselsaar = yngsteBarnFodselsaar;
    }

    public String getYrkesskadetillegg() {
        return yrkesskadetillegg;
    }

    public void setYrkesskadetillegg(String yrkesskadetillegg) {
        this.yrkesskadetillegg = yrkesskadetillegg;
    }

    public String getYrkesmessigAttforing() {
        return yrkesmessigAttforing;
    }

    public void setYrkesmessigAttforing(String yrkesmessigAttforing) {
        this.yrkesmessigAttforing = yrkesmessigAttforing;
    }

    public int getUtdanning() {
        return utdanning;
    }

    public void setUtdanning(int utdanning) {
        this.utdanning = utdanning;
    }

    public int getYrke() {
        return yrke;
    }

    public void setYrke(int yrke) {
        this.yrke = yrke;
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

    public int getFriinntektDato() {
        return friinntektDato;
    }

    public void setFriinntektDato(int friinntektDato) {
        this.friinntektDato = friinntektDato;
    }

    public int getVirkningsdato() {
        return virkningsdato;
    }

    public void setVirkningsdato(int virkningsdato) {
        this.virkningsdato = virkningsdato;
    }

    public String  getFodselsnummerEktefelle() {
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

    public String getUnntakPar12Pkt2() {
        return unntakPar12Pkt2;
    }

    public void setUnntakPar12Pkt2(String unntakPar12Pkt2) {
        this.unntakPar12Pkt2 = unntakPar12Pkt2;
    }

    public int getStonadstilfelleDato3B() {
        return stonadstilfelleDato3B;
    }

    public void setStonadstilfelleDato3B(int stonadstilfelleDato3B) {
        this.stonadstilfelleDato3B = stonadstilfelleDato3B;
    }

    public String getFravikPar2Pkt1Ledd3BokstavC() {
        return fravikPar2Pkt1Ledd3BokstavC;
    }

    public void setFravikPar2Pkt1Ledd3BokstavC(String fravikPar2Pkt1Ledd3BokstavC) {
        this.fravikPar2Pkt1Ledd3BokstavC = fravikPar2Pkt1Ledd3BokstavC;
    }

    public int getStonadstilfelleDato3C() {
        return stonadstilfelleDato3C;
    }

    public void setStonadstilfelleDato3C(int stonadstilfelleDato3C) {
        this.stonadstilfelleDato3C = stonadstilfelleDato3C;
    }

    public String getPensjonstrygdet() {
        return pensjonstrygdet;
    }

    public void setPensjonstrygdet(String pensjonstrygdet) {
        this.pensjonstrygdet = pensjonstrygdet;
    }

    public String getGrunnPensjonBeregnetPaaTrygdetidLikPoengaar() {
        return grunnPensjonBeregnetPaaTrygdetidLikPoengaar;
    }

    public void setGrunnPensjonBeregnetPaaTrygdetidLikPoengaar(String grunnPensjonBeregnetPaaTrygdetidLikPoengaar) {
        this.grunnPensjonBeregnetPaaTrygdetidLikPoengaar = grunnPensjonBeregnetPaaTrygdetidLikPoengaar;
    }

    public String getMinst20Aar() {
        return minst20Aar;
    }

    public void setMinst20Aar(String minst20Aar) {
        this.minst20Aar = minst20Aar;
    }

    public String getFolgerKonvensjonMedAndreLand() {
        return folgerKonvensjonMedAndreLand;
    }

    public void setFolgerKonvensjonMedAndreLand(String folgerKonvensjonMedAndreLand) {
        this.folgerKonvensjonMedAndreLand = folgerKonvensjonMedAndreLand;
    }

    public int getKonvensjonsLand() {
        return konvensjonsLand;
    }

    public void setKonvensjonsLand(int konvensjonsLand) {
        this.konvensjonsLand = konvensjonsLand;
    }

    public String getFravikBosattEOS() {
        return fravikBosattEOS;
    }

    public void setFravikBosattEOS(String fravikBosattEOS) {
        this.fravikBosattEOS = fravikBosattEOS;
    }

    public String getFravikPar8Pkt1() {
        return fravikPar8Pkt1;
    }

    public void setFravikPar8Pkt1(String fravikPar8Pkt1) {
        this.fravikPar8Pkt1 = fravikPar8Pkt1;
    }

    public String getTrygdetidLikPoengaar() {
        return trygdetidLikPoengaar;
    }

    public void setTrygdetidLikPoengaar(String trygdetidLikPoengaar) {
        this.trygdetidLikPoengaar = trygdetidLikPoengaar;
    }

    public String getBeregneFramtidigTrygdetid() {
        return beregneFramtidigTrygdetid;
    }

    public void setBeregneFramtidigTrygdetid(String beregneFramtidigTrygdetid) {
        this.beregneFramtidigTrygdetid = beregneFramtidigTrygdetid;
    }

    public String getBeregneFaktiskTrygdetid() {
        return beregneFaktiskTrygdetid;
    }

    public void setBeregneFaktiskTrygdetid(String beregneFaktiskTrygdetid) {
        this.beregneFaktiskTrygdetid = beregneFaktiskTrygdetid;
    }

    public String getUngUfor() {
        return ungUfor;
    }

    public void setUngUfor(String ungUfor) {
        this.ungUfor = ungUfor;
    }

    public String getGodkjentFlyktningUDI() {
        return godkjentFlyktningUDI;
    }

    public void setGodkjentFlyktningUDI(String godkjentFlyktningUDI) {
        this.godkjentFlyktningUDI = godkjentFlyktningUDI;
    }

    public String getOverkompensert() {
        return overkompensert;
    }

    public void setOverkompensert(String overkompensert) {
        this.overkompensert = overkompensert;
    }

    public int getTrygdetidFra1937Aar() {
        return trygdetidFra1937Aar;
    }

    public void setTrygdetidFra1937Aar(int trygdetidFra1937Aar) {
        this.trygdetidFra1937Aar = trygdetidFra1937Aar;
    }

    public int getTrygdetidFra1937Maaneder() {
        return trygdetidFra1937Maaneder;
    }

    public void setTrygdetidFra1937Maaneder(int trygdetidFra1937Maaneder) {
        this.trygdetidFra1937Maaneder = trygdetidFra1937Maaneder;
    }

    public int getTrygdetidFor1967Aar() {
        return trygdetidFor1967Aar;
    }

    public void setTrygdetidFor1967Aar(int trygdetidFor1967Aar) {
        this.trygdetidFor1967Aar = trygdetidFor1967Aar;
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

    public int getTrygdetidFor1967AarEktefelle() {
        return trygdetidFor1967AarEktefelle;
    }

    public void setTrygdetidFor1967AarEktefelle(int trygdetidFor1967AarEktefelle) {
        this.trygdetidFor1967AarEktefelle = trygdetidFor1967AarEktefelle;
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

    public String getFravikpar19Pkt3() {
        return fravikpar19Pkt3;
    }

    public void setFravikpar19Pkt3(String fravikpar19Pkt3) {
        this.fravikpar19Pkt3 = fravikpar19Pkt3;
    }

    public String getTrygdetidEndres() {
        return trygdetidEndres;
    }

    public void setTrygdetidEndres(String trygdetidEndres) {
        this.trygdetidEndres = trygdetidEndres;
    }

    public String getTrygdetidAnnetNordiskLand() {
        return trygdetidAnnetNordiskLand;
    }

    public void setTrygdetidAnnetNordiskLand(String trygdetidAnnetNordiskLand) {
        this.trygdetidAnnetNordiskLand = trygdetidAnnetNordiskLand;
    }

    public String getIkkeBeregneGrunnpensjon() {
        return ikkeBeregneGrunnpensjon;
    }

    public void setIkkeBeregneGrunnpensjon(String ikkeBeregneGrunnpensjon) {
        this.ikkeBeregneGrunnpensjon = ikkeBeregneGrunnpensjon;
    }

    public String getAvkorteSaertillegg() {
        return avkorteSaertillegg;
    }

    public void setAvkorteSaertillegg(String avkorteSaertillegg) {
        this.avkorteSaertillegg = avkorteSaertillegg;
    }

    public int getTilleggspensjonFraAnnetNordiskland() {
        return tilleggspensjonFraAnnetNordiskland;
    }

    public void setTilleggspensjonFraAnnetNordiskland(int tilleggspensjonFraAnnetNordiskland) {
        this.tilleggspensjonFraAnnetNordiskland = tilleggspensjonFraAnnetNordiskland;
    }

    public int getTilleggspensjonsland() {
        return tilleggspensjonsland;
    }

    public void setTilleggspensjonsland(int tilleggspensjonsland) {
        this.tilleggspensjonsland = tilleggspensjonsland;
    }

    public String getBeregningKonvensjon() {
        return beregningKonvensjon;
    }

    public void setBeregningKonvensjon(String beregningKonvensjon) {
        this.beregningKonvensjon = beregningKonvensjon;
    }

    public int getTrygdetidKonvensjonAar() {
        return trygdetidKonvensjonAar;
    }

    public void setTrygdetidKonvensjonAar(int trygdetidKonvensjonAar) {
        this.trygdetidKonvensjonAar = trygdetidKonvensjonAar;
    }

    public String getBeregneFolketrygd() {
        return beregneFolketrygd;
    }

    public void setBeregneFolketrygd(String beregneFolketrygd) {
        this.beregneFolketrygd = beregneFolketrygd;
    }

    public String getEosPar8Pkt4Ledd3BokstavA() {
        return eosPar8Pkt4Ledd3BokstavA;
    }

    public void setEosPar8Pkt4Ledd3BokstavA(String eosPar8Pkt4Ledd3BokstavA) {
        this.eosPar8Pkt4Ledd3BokstavA = eosPar8Pkt4Ledd3BokstavA;
    }

    public int getTeoretiskTrygdetidEOSAar() {
        return teoretiskTrygdetidEOSAar;
    }

    public void setTeoretiskTrygdetidEOSAar(int teoretiskTrygdetidEOSAar) {
        this.teoretiskTrygdetidEOSAar = teoretiskTrygdetidEOSAar;
    }

    public int getTeoretiskTrygdetidEOSMaaneder() {
        return teoretiskTrygdetidEOSMaaneder;
    }

    public void setTeoretiskTrygdetidEOSMaaneder(int teoretiskTrygdetidEOSMaaneder) {
        this.teoretiskTrygdetidEOSMaaneder = teoretiskTrygdetidEOSMaaneder;
    }

    public int getProrataTrygdetidEOSAar() {
        return prorataTrygdetidEOSAar;
    }

    public void setProrataTrygdetidEOSAar(int prorataTrygdetidEOSAar) {
        this.prorataTrygdetidEOSAar = prorataTrygdetidEOSAar;
    }

    public int getProrataTrygdetidEOSMaaneder() {
        return prorataTrygdetidEOSMaaneder;
    }

    public void setProrataTrygdetidEOSMaaneder(int prorataTrygdetidEOSMaaneder) {
        this.prorataTrygdetidEOSMaaneder = prorataTrygdetidEOSMaaneder;
    }

    public int getPensjonEOS() {
        return pensjonEOS;
    }

    public void setPensjonEOS(int pensjonEOS) {
        this.pensjonEOS = pensjonEOS;
    }

    public boolean[] getPoengaarIEOS() {
        return poengaarIEOS;
    }

    public void setPoengaarIEOS(boolean[] poengaarIEOS) {
        this.poengaarIEOS = poengaarIEOS;
    }

    public int getInntektForUforepensjon() {
        return inntektForUforepensjon;
    }

    public void setInntektForUforepensjon(int inntektForUforepensjon) {
        this.inntektForUforepensjon = inntektForUforepensjon;
    }

    public int getFaktiskNordiskTrygdetidAar() {
        return faktiskNordiskTrygdetidAar;
    }

    public void setFaktiskNordiskTrygdetidAar(int faktiskNordiskTrygdetidAar) {
        this.faktiskNordiskTrygdetidAar = faktiskNordiskTrygdetidAar;
    }

    public int getFaktiskNordiskTrygdetidMaaneder() {
        return faktiskNordiskTrygdetidMaaneder;
    }

    public void setFaktiskNordiskTrygdetidMaaneder(int faktiskNordiskTrygdetidMaaneder) {
        this.faktiskNordiskTrygdetidMaaneder = faktiskNordiskTrygdetidMaaneder;
    }

    public int getFaktiskeNordiskePoengaar() {
        return faktiskeNordiskePoengaar;
    }

    public void setFaktiskeNordiskePoengaar(int faktiskeNordiskePoengaar) {
        this.faktiskeNordiskePoengaar = faktiskeNordiskePoengaar;
    }

    public String getReaktivisering() {
        return reaktivisering;
    }

    public void setReaktivisering(String reaktivisering) {
        this.reaktivisering = reaktivisering;
    }

    public String getUnntakVentetid() {
        return unntakVentetid;
    }

    public void setUnntakVentetid(String unntakVentetid) {
        this.unntakVentetid = unntakVentetid;
    }

    public String getEktefelleInntektOver2G() {
        return ektefelleInntektOver2G;
    }

    public void setEktefelleInntektOver2G(String ektefelleInntektOver2G) {
        this.ektefelleInntektOver2G = ektefelleInntektOver2G;
    }

    public String getGarantiTilleggspensjon() {
        return garantiTilleggspensjon;
    }

    public void setGarantiTilleggspensjon(String garantiTilleggspensjon) {
        this.garantiTilleggspensjon = garantiTilleggspensjon;
    }

    public String getFrysp5AarArbeid() {
        return frysp5AarArbeid;
    }

    public void setFrysp5AarArbeid(String frysp5AarArbeid) {
        this.frysp5AarArbeid = frysp5AarArbeid;
    }

    public String getFryspTidsb() {
        return fryspTidsb;
    }

    public void setFryspTidsb(String fryspTidsb) {
        this.fryspTidsb = fryspTidsb;
    }

    public boolean[] getPoengaarIEOSIkkeMedIProrata() {
        return poengaarIEOSIkkeMedIProrata;
    }

    public void setPoengaarIEOSIkkeMedIProrata(boolean[] poengaarIEOSIkkeMedIProrata) {
        this.poengaarIEOSIkkeMedIProrata = poengaarIEOSIkkeMedIProrata;
    }

    public String getReduksjonGrunnpensjonEtterPar3Pkt2Ledd5() {
        return reduksjonGrunnpensjonEtterPar3Pkt2Ledd5;
    }

    public void setReduksjonGrunnpensjonEtterPar3Pkt2Ledd5(String reduksjonGrunnpensjonEtterPar3Pkt2Ledd5) {
        this.reduksjonGrunnpensjonEtterPar3Pkt2Ledd5 = reduksjonGrunnpensjonEtterPar3Pkt2Ledd5;
    }

    public String getEosOpplysning() {
        return eosOpplysning;
    }

    public void setEosOpplysning(String eosOpplysning) {
        this.eosOpplysning = eosOpplysning;
    }

    public String getLonnstilskudd() {
        return lonnstilskudd;
    }

    public void setLonnstilskudd(String lonnstilskudd) {
        this.lonnstilskudd = lonnstilskudd;
    }
}
