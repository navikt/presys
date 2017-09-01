package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBU2" , length = 112)
@UnmappedField(name = "filler", length = 6, start = 106)
@UnmappedField(name="PRIMDIAG", length = 6, start = 34)
@UnmappedField(name="SEKUDIAG", length = 6, start = 40)
public class GRUNNBU2 {

    @Felt(name="ATT_UF", length = 1, start = 0) private String attforingUfor;
    @Felt(name="EKTEFELLE_TILL", length = 1, start = 1) private String ektefelleTillegg;
    @Felt(name="NBOSATT", length = 1, start = 2) private String bosattNorge;
    @Felt(name="BT_ANT", length = 2, start = 3)@PackedDecimal private int antaBarnMedBarnetillegg;
    @Felt(name="YSKADE_TILLEGG", length = 1, start = 5) private String yrkesskadetillegg;
    @Felt(name="VERNEPLIKTAAR1", length = 3, start = 6) @PackedDecimal private int vernepliktaar1;
    @Felt(name="VERNEPLIKTAAR2", length = 3, start = 9) @PackedDecimal private int vernepliktaar2;
    @Felt(name="VERNEPLIKTAAR3", length = 3, start = 12) @PackedDecimal private int vernepliktaar3;
    @Felt(name="VERNEPLIKTAAR4", length = 3, start = 15) @PackedDecimal private int vernepliktaar4;
    @Felt(name="UTDANNING", length = 1, start = 18) private String utdanning;
    @Felt(name="VILKAAR_8_4_3A", length = 1, start = 19) private String vilkaarPar8Pkt4Ledd3Bokatava;
    @Felt(name="PI", length = 4, start = 20)@PackedDecimal private int pensjonsgivendeInntekt;
    @Felt(name="UFG", length = 2, start = 24)@PackedDecimal private int uforegrad;
    @Felt(name="UFT_AAMD", length = 5, start = 26)@PackedDecimal private int uforetidspunkt;
    @Felt(name="YRKESM_ATTF", length = 1, start = 31) private String yrkesmessigAttforing;
    @Felt(name="YRKE", length = 2, start = 32)@PackedDecimal private int yrke;
    @Felt(name="FNR_EK", length = 6, start = 46)@PackedDecimal private int fodselsnummerEktefelle;
    @Felt(name="NAVN_EK", length = 25, start = 52) private String navnEktefelle;
    @Felt(name="MINST4G", length = 1, start = 77) private String ektefellesInntektMinst4G;
    @Felt(name="STATSBORGER", length = 2, start = 78)@PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT", length = 2, start = 80)@PackedDecimal private int bosattLand;
    @Felt(name="PENSJONSTRYGDET", length = 1, start = 82) private String pensjonstrygdet;
    @Felt(name="MINST_20_AAR", length = 1, start = 83) private String minst20AArBotid;
    @Felt(name="KONVENSJON", length = 1, start = 84) private String konvensjon;
    @Felt(name="FRAVIK_FLYKT", length = 1, start = 85) private String erFlyktning;
    @Felt(name="OVERKOMP_UTL", length = 1, start = 86) private String overkompensasjonUtland;
    @Felt(name="IKKE_GP", length = 1, start = 87) private String ikkeGrunnpensjon;
    @Felt(name="BEREGNING_KONV", length = 1, start = 88) private String beregnesEtterKonvensjonbestemmelser;
    @Felt(name="TT_KONVENSJON_AAR", length = 2, start = 89)@PackedDecimal private int trygdetidAntallKonvensjonsaar;
    @Felt(name="TT_FRA1937_AAR", length = 2, start = 91)@PackedDecimal private int trygdetidFra1937Aar;
    @Felt(name="TT_FRA1937_MND", length = 2, start = 93)@PackedDecimal private int trygdetidFra1937Maaneder;
    @Felt(name="TT_NORDEN_ANNET", length = 1, start = 95) private String nordiskTrygdetid;
    @Felt(name="FRAVIK_8_1_NR3", length = 1, start = 96) private String fravikPar8Pkt1LeddNr3;
    @Felt(name="STI_AAMD", length = 5, start = 97)@PackedDecimal private int stonadstilfelletsInntreden;
    @Felt(name="INNTEKT_FOR_UP", length = 4, start = 102)@PackedDecimal private int inntektForUforhet;

    public String getAttforingUfor() {
        return attforingUfor;
    }

    public void setAttforingUfor(String attforingUfor) {
        this.attforingUfor = attforingUfor;
    }

    public String getEktefelleTillegg() {
        return ektefelleTillegg;
    }

    public void setEktefelleTillegg(String ektefelleTillegg) {
        this.ektefelleTillegg = ektefelleTillegg;
    }

    public String getBosattNorge() {
        return bosattNorge;
    }

    public void setBosattNorge(String bosattNorge) {
        this.bosattNorge = bosattNorge;
    }

    public int getAntaBarnMedBarnetillegg() {
        return antaBarnMedBarnetillegg;
    }

    public void setAntaBarnMedBarnetillegg(int antaBarnMedBarnetillegg) {
        this.antaBarnMedBarnetillegg = antaBarnMedBarnetillegg;
    }

    public String getYrkesskadetillegg() {
        return yrkesskadetillegg;
    }

    public void setYrkesskadetillegg(String yrkesskadetillegg) {
        this.yrkesskadetillegg = yrkesskadetillegg;
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

    public String getUtdanning() {
        return utdanning;
    }

    public void setUtdanning(String utdanning) {
        this.utdanning = utdanning;
    }

    public String getVilkaarPar8Pkt4Ledd3Bokatava() {
        return vilkaarPar8Pkt4Ledd3Bokatava;
    }

    public void setVilkaarPar8Pkt4Ledd3Bokatava(String vilkaarPar8Pkt4Ledd3Bokatava) {
        this.vilkaarPar8Pkt4Ledd3Bokatava = vilkaarPar8Pkt4Ledd3Bokatava;
    }

    public int getPensjonsgivendeInntekt() {
        return pensjonsgivendeInntekt;
    }

    public void setPensjonsgivendeInntekt(int pensjonsgivendeInntekt) {
        this.pensjonsgivendeInntekt = pensjonsgivendeInntekt;
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

    public String getYrkesmessigAttforing() {
        return yrkesmessigAttforing;
    }

    public void setYrkesmessigAttforing(String yrkesmessigAttforing) {
        this.yrkesmessigAttforing = yrkesmessigAttforing;
    }

    public int getYrke() {
        return yrke;
    }

    public void setYrke(int yrke) {
        this.yrke = yrke;
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

    public String getEktefellesInntektMinst4G() {
        return ektefellesInntektMinst4G;
    }

    public void setEktefellesInntektMinst4G(String ektefellesInntektMinst4G) {
        this.ektefellesInntektMinst4G = ektefellesInntektMinst4G;
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

    public String getPensjonstrygdet() {
        return pensjonstrygdet;
    }

    public void setPensjonstrygdet(String pensjonstrygdet) {
        this.pensjonstrygdet = pensjonstrygdet;
    }

    public String getMinst20AArBotid() {
        return minst20AArBotid;
    }

    public void setMinst20AArBotid(String minst20AArBotid) {
        this.minst20AArBotid = minst20AArBotid;
    }

    public String getKonvensjon() {
        return konvensjon;
    }

    public void setKonvensjon(String konvensjon) {
        this.konvensjon = konvensjon;
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

    public String getIkkeGrunnpensjon() {
        return ikkeGrunnpensjon;
    }

    public void setIkkeGrunnpensjon(String ikkeGrunnpensjon) {
        this.ikkeGrunnpensjon = ikkeGrunnpensjon;
    }

    public String getBeregnesEtterKonvensjonbestemmelser() {
        return beregnesEtterKonvensjonbestemmelser;
    }

    public void setBeregnesEtterKonvensjonbestemmelser(String beregnesEtterKonvensjonbestemmelser) {
        this.beregnesEtterKonvensjonbestemmelser = beregnesEtterKonvensjonbestemmelser;
    }

    public int getTrygdetidAntallKonvensjonsaar() {
        return trygdetidAntallKonvensjonsaar;
    }

    public void setTrygdetidAntallKonvensjonsaar(int trygdetidAntallKonvensjonsaar) {
        this.trygdetidAntallKonvensjonsaar = trygdetidAntallKonvensjonsaar;
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

    public String getNordiskTrygdetid() {
        return nordiskTrygdetid;
    }

    public void setNordiskTrygdetid(String nordiskTrygdetid) {
        this.nordiskTrygdetid = nordiskTrygdetid;
    }

    public String getFravikPar8Pkt1LeddNr3() {
        return fravikPar8Pkt1LeddNr3;
    }

    public void setFravikPar8Pkt1LeddNr3(String fravikPar8Pkt1LeddNr3) {
        this.fravikPar8Pkt1LeddNr3 = fravikPar8Pkt1LeddNr3;
    }

    public int getStonadstilfelletsInntreden() {
        return stonadstilfelletsInntreden;
    }

    public void setStonadstilfelletsInntreden(int stonadstilfelletsInntreden) {
        this.stonadstilfelletsInntreden = stonadstilfelletsInntreden;
    }

    public int getInntektForUforhet() {
        return inntektForUforhet;
    }

    public void setInntektForUforhet(int inntektForUforhet) {
        this.inntektForUforhet = inntektForUforhet;
    }
}
