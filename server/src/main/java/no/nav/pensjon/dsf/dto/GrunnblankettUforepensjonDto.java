package no.nav.pensjon.dsf.dto;

import java.util.List;

public class GrunnblankettUforepensjonDto extends GrunnblankettDto {

    private String attforingUfor;
    private String navn;
    private String bosattNorge;
    private String ektefelletillegg;
    private String barnetillegg;
    private int vernepliktaar1;
    private int vernepliktaar2;
    private int vernepliktaar3;
    private int vernepliktaar4;
    private String vilkaarPar8Pkt4Ledd3BokstavA;
    private int pensjonsgivendeInntekt;
    private int yngsteBarnFodselsaar;
    private String yrkesskadetillegg;
    private String yrkesmessigAttforing;
    private int utdanning;
    private int yrke;
    private int uforegrad;
    private int uforetidspunkt;
    private int friinntektDato;
    private int virkningsdato;
    private String fodselsnummerEktefelle;
    private String navnEktefelle;
    private int statsborgerskap;
    private int bosattLand;
    private String unntakPar12Pkt2;
    private int stonadstilfelleDato3B;
    private String fravikPar2Pkt1Ledd3BokstavC;
    private int stonadstilfelleDato3C;
    private String pensjonstrygdet;
    private String  grunnPensjonBeregnetPaaTrygdetidLikPoengaar;
    private String minst20Aar;
    private String folgerKonvensjonMedAndreLand;
    private int konvensjonsLand;
    private String fravikBosattEOS;
    private String fravikPar8Pkt1;
    private String trygdetidLikPoengaar;
    private String beregneFramtidigTrygdetid;
    private String beregneFaktiskTrygdetid;
    private String ungUfor;
    private String godkjentFlyktningUDI;
    private String overkompensert;
    private int trygdetidFra1937Aar;
    private int trygdetidFra1937Maaneder;
    private int trygdetidFor1967Aar;
    private int trygdetidEtter1966Aar;
    private int trygdetidEtter1966Maaneder;
    private int trygdetidFor1967AarEktefelle;
    private int trygdetidEtter1966AarEktefelle;
    private int trygdetidEtter1966MaanederEktefelle;
    private String fravikpar19Pkt3;
    private String trygdetidEndres;
    private String trygdetidAnnetNordiskLand;
    private String ikkeBeregneGrunnpensjon;
    private String avkorteSaertillegg;
    private int tilleggspensjonFraAnnetNordiskland;
    private int tilleggspensjonsland;
    private String beregningKonvensjon;
    private int trygdetidKonvensjonAar;
    private String beregneFolketrygd;
    private String eosPar8Pkt4Ledd3BokstavA;
    private int teoretiskTrygdetidEOSAar;
    private int teoretiskTrygdetidEOSMaaneder;
    private int prorataTrygdetidEOSAar;
    private int prorataTrygdetidEOSMaaneder;
    private int pensjonEOS;
    private List<Integer> poengaarIEOS;
    private int inntektForUforepensjon;
    private int faktiskNordiskTrygdetidAar;
    private int faktiskNordiskTrygdetidMaaneder;
    private int faktiskeNordiskePoengaar;
    private String reaktivisering;
    private String unntakVentetid;
    private String ektefelleInntektOver2G;
    private String garantiTilleggspensjon;
    private String frysp5AarArbeid;
    private String fryspTidsb;
    private List<Integer> poengaarIEOSIkkeMedIProrata;
    private String reduksjonGrunnpensjonEtterPar3Pkt2Ledd5;
    private String eosOpplysning;
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


    public List<Integer> getPoengaarIEOS() {
        return poengaarIEOS;
    }

    public void setPoengaarIEOS(boolean[] poengaarIEOS) {
        this.poengaarIEOS = ConvertersUtil.bittabellTilAarstallFra1967(poengaarIEOS);
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

    public List<Integer> getPoengaarIEOSIkkeMedIProrata() {
        return poengaarIEOSIkkeMedIProrata;
    }

    public void setPoengaarIEOSIkkeMedIProrata(boolean[]  poengaarIEOSIkkeMedIProrata) {
        this.poengaarIEOSIkkeMedIProrata = ConvertersUtil.bittabellTilAarstallFra1967(poengaarIEOSIkkeMedIProrata);
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
