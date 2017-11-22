package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@UnmappedField(name="FILLER", length = 3, start = 107)
@Segment(name = "GRUNNBE3", length = 110)//110
public class GRUNNBE3 {

    @Felt(name="NORSK_BOSATT", length = 1, start = 0) private String bosattNorge;
    @Felt(name="OMSORG_AVD_BA", length = 1, start = 1) private String omsorgAvdodesBarn;
    @Felt(name="VILKAAR_10_5", length = 1, start = 2) private String vilkaarPar10Pkt5;
    @Felt(name="FORVENTET_INNT", length = 3, start = 3) @PackedDecimal private int forventetInntekt;
    @Felt(name="FAI", length = 3, start = 6) @PackedDecimal private int framtidigArbeidsinntekt;
    @Felt(name="GP_OS_KODE", length = 1, start = 9) private String ytelse;
    @Felt(name="YSKADE_TILLEGG", length = 1, start = 10) private String yrkesskadeTillegg;
    @Felt(name="FRAMLEGGSDATO_AAMD", length = 5, start = 11) @PackedDecimal private int framleggsdato;
    @Felt(name="FRAMLEGGSKODE", length = 1, start = 16) private String framleggskode;
    @Felt(name="FNR_EK", length = 6, start = 17) @PackedDecimal private String fodselsnummerEktefelle;
    @Felt(name="NAVN_EK", length = 25, start = 23) private String navnEktefelle;
    @Felt(name="DODSDATO_AAMD", length = 5, start = 48) @PackedDecimal private int dodsdato;
    @Felt(name="NORSK_BOSATT_EK", length = 1, start = 53) private String bosattNorgeEktefelle;
    @Felt(name="VILKAAR_8_4_3A", length = 1, start = 54) private String vilkaarPar8Pkt3Ledd3bokstavA;
    @Felt(name="VERNEPLIKTAAR1", length = 3, start = 55) @PackedDecimal private int vernepliktaar1;
    @Felt(name="VERNEPLIKTAAR2", length = 3, start = 58) @PackedDecimal private int vernepliktaar2;
    @Felt(name="VERNEPLIKTAAR3", length = 3, start = 61) @PackedDecimal private int vernepliktaar3;
    @Felt(name="VERNEPLIKTAAR4", length = 3, start = 64) @PackedDecimal private int vernepliktaar4;
    @Felt(name="PIEK", length = 4, start = 67) @PackedDecimal private int pensjonsgivendeInntektSisteLeveaar;
    @Felt(name="STATSBORGER", length = 2, start = 71) @PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT", length = 2, start = 73) @PackedDecimal private int bosattLand;
    @Felt(name="PENSJONSTRYGDET", length = 1, start = 75) private String pensjonstrygdet;
    @Felt(name="MINST_20AAR", length = 1, start = 76) private String minst20AarBotid;
    @Felt(name="FRAVIK_KONVENSJON", length = 1, start = 77) private String fravikPgaKonvensjonAnnetLand;
    @Felt(name="FRAVIK_FLYKTN", length = 1, start = 78) private String flyktning;
    @Felt(name="OVERKOMP_UTL", length = 1, start = 79) private String overkompensasjonUtland;
    @Felt(name="IKKE_GP", length = 1, start = 80) private String skalIkkeBeregnesGrunnpenson;
    @Felt(name="BEREGNING_KONVENSJON", length = 1, start = 81) private String pensjonBeregnesEtterKonvensjonsregler;
    @Felt(name="TT_KONVENSJON_AAR", length = 2, start = 82) @PackedDecimal private int trygdetidKonvensjonsaar;
    @Felt(name="TT_FRAMT_DOD", length = 2, start = 84) @PackedDecimal private int framtidigTrygdetidFraDod;
    @Felt(name="TT_FRA_1937_AAR", length = 2, start = 86) @PackedDecimal private int faktiskTrygdetidAar;
    @Felt(name="TT_FRA_1937_MND", length = 2, start = 88) @PackedDecimal private int faktiskTrygdetidMaaneder;
    @Felt(name="TT_NORDEN_ANNET", length = 1, start = 90) private String trygdetidIAnnetNordiskLand;
    @Felt(name="VILKAAR_10_5_NR2", length = 1, start = 91) private String vilkaarPar10Pkt5nr2;
    @Felt(name="STI_AAMD", length = 5, start = 92) @PackedDecimal private int medlemFolketrygdenFra;
    @Felt(name="STATSBORGER_EK", length = 2, start = 97) @PackedDecimal private int statsborgerskapEktefelle;
    @Felt(name="BOSATT_EK", length = 2, start = 99) @PackedDecimal private int bosattEktefelle;
    @Felt(name="FRAVIK_FLYKT_EK", length = 1, start = 101) private String erEktefelleFlyktning;
    @Felt(name="TT_FRA_1937_AAR_EK", length = 2, start = 102) @PackedDecimal private int trygdetidFra1937EktefelleAar;
    @Felt(name="TT_FRA_1937_MND_EK", length = 2, start = 104) @PackedDecimal private int trygdetidFra1937EktefelleMaaneder;
    @Felt(name="OVERKOMP_UTL_EK", length = 1, start = 106) private String overkompensasjonUtlandEktefelle;

    public String getBosattNorge() {
        return bosattNorge;
    }

    public void setBosattNorge(String bosattNorge) {
        this.bosattNorge = bosattNorge;
    }

    public String getOmsorgAvdodesBarn() {
        return omsorgAvdodesBarn;
    }

    public void setOmsorgAvdodesBarn(String omsorgAvdodesBarn) {
        this.omsorgAvdodesBarn = omsorgAvdodesBarn;
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

    public int getFramtidigArbeidsinntekt() {
        return framtidigArbeidsinntekt;
    }

    public void setFramtidigArbeidsinntekt(int framtidigArbeidsinntekt) {
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt;
    }

    public String getYtelse() {
        return ytelse;
    }

    public void setYtelse(String ytelse) {
        this.ytelse = ytelse;
    }

    public String getYrkesskadeTillegg() {
        return yrkesskadeTillegg;
    }

    public void setYrkesskadeTillegg(String yrkesskadeTillegg) {
        this.yrkesskadeTillegg = yrkesskadeTillegg;
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

    public int getDodsdato() {
        return dodsdato;
    }

    public void setDodsdato(int dodsdato) {
        this.dodsdato = dodsdato;
    }

    public String getBosattNorgeEktefelle() {
        return bosattNorgeEktefelle;
    }

    public void setBosattNorgeEktefelle(String bosattNorgeEktefelle) {
        this.bosattNorgeEktefelle = bosattNorgeEktefelle;
    }

    public String getVilkaarPar8Pkt3Ledd3bokstavA() {
        return vilkaarPar8Pkt3Ledd3bokstavA;
    }

    public void setVilkaarPar8Pkt3Ledd3bokstavA(String vilkaarPar8Pkt3Ledd3bokstavA) {
        this.vilkaarPar8Pkt3Ledd3bokstavA = vilkaarPar8Pkt3Ledd3bokstavA;
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

    public int getPensjonsgivendeInntektSisteLeveaar() {
        return pensjonsgivendeInntektSisteLeveaar;
    }

    public void setPensjonsgivendeInntektSisteLeveaar(int pensjonsgivendeInntektSisteLeveaar) {
        this.pensjonsgivendeInntektSisteLeveaar = pensjonsgivendeInntektSisteLeveaar;
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

    public String getMinst20AarBotid() {
        return minst20AarBotid;
    }

    public void setMinst20AarBotid(String minst20AarBotid) {
        this.minst20AarBotid = minst20AarBotid;
    }

    public String getFravikPgaKonvensjonAnnetLand() {
        return fravikPgaKonvensjonAnnetLand;
    }

    public void setFravikPgaKonvensjonAnnetLand(String fravikPgaKonvensjonAnnetLand) {
        this.fravikPgaKonvensjonAnnetLand = fravikPgaKonvensjonAnnetLand;
    }

    public String getFlyktning() {
        return flyktning;
    }

    public void setFlyktning(String flyktning) {
        this.flyktning = flyktning;
    }

    public String getOverkompensasjonUtland() {
        return overkompensasjonUtland;
    }

    public void setOverkompensasjonUtland(String overkompensasjonUtland) {
        this.overkompensasjonUtland = overkompensasjonUtland;
    }

    public String getSkalIkkeBeregnesGrunnpenson() {
        return skalIkkeBeregnesGrunnpenson;
    }

    public void setSkalIkkeBeregnesGrunnpenson(String skalIkkeBeregnesGrunnpenson) {
        this.skalIkkeBeregnesGrunnpenson = skalIkkeBeregnesGrunnpenson;
    }

    public String getPensjonBeregnesEtterKonvensjonsregler() {
        return pensjonBeregnesEtterKonvensjonsregler;
    }

    public void setPensjonBeregnesEtterKonvensjonsregler(String pensjonBeregnesEtterKonvensjonsregler) {
        this.pensjonBeregnesEtterKonvensjonsregler = pensjonBeregnesEtterKonvensjonsregler;
    }

    public int getTrygdetidKonvensjonsaar() {
        return trygdetidKonvensjonsaar;
    }

    public void setTrygdetidKonvensjonsaar(int trygdetidKonvensjonsaar) {
        this.trygdetidKonvensjonsaar = trygdetidKonvensjonsaar;
    }

    public int getFramtidigTrygdetidFraDod() {
        return framtidigTrygdetidFraDod;
    }

    public void setFramtidigTrygdetidFraDod(int framtidigTrygdetidFraDod) {
        this.framtidigTrygdetidFraDod = framtidigTrygdetidFraDod;
    }

    public int getFaktiskTrygdetidAar() {
        return faktiskTrygdetidAar;
    }

    public void setFaktiskTrygdetidAar(int faktiskTrygdetidAar) {
        this.faktiskTrygdetidAar = faktiskTrygdetidAar;
    }

    public int getFaktiskTrygdetidMaaneder() {
        return faktiskTrygdetidMaaneder;
    }

    public void setFaktiskTrygdetidMaaneder(int faktiskTrygdetidMaaneder) {
        this.faktiskTrygdetidMaaneder = faktiskTrygdetidMaaneder;
    }

    public String getTrygdetidIAnnetNordiskLand() {
        return trygdetidIAnnetNordiskLand;
    }

    public void setTrygdetidIAnnetNordiskLand(String trygdetidIAnnetNordiskLand) {
        this.trygdetidIAnnetNordiskLand = trygdetidIAnnetNordiskLand;
    }

    public String getVilkaarPar10Pkt5nr2() {
        return vilkaarPar10Pkt5nr2;
    }

    public void setVilkaarPar10Pkt5nr2(String vilkaarPar10Pkt5nr2) {
        this.vilkaarPar10Pkt5nr2 = vilkaarPar10Pkt5nr2;
    }

    public int getMedlemFolketrygdenFra() {
        return medlemFolketrygdenFra;
    }

    public void setMedlemFolketrygdenFra(int medlemFolketrygdenFra) {
        this.medlemFolketrygdenFra = medlemFolketrygdenFra;
    }

    public int getStatsborgerskapEktefelle() {
        return statsborgerskapEktefelle;
    }

    public void setStatsborgerskapEktefelle(int statsborgerskapEktefelle) {
        this.statsborgerskapEktefelle = statsborgerskapEktefelle;
    }

    public int getBosattEktefelle() {
        return bosattEktefelle;
    }

    public void setBosattEktefelle(int bosattEktefelle) {
        this.bosattEktefelle = bosattEktefelle;
    }

    public String getErEktefelleFlyktning() {
        return erEktefelleFlyktning;
    }

    public void setErEktefelleFlyktning(String erEktefelleFlyktning) {
        this.erEktefelleFlyktning = erEktefelleFlyktning;
    }

    public int getTrygdetidFra1937EktefelleAar() {
        return trygdetidFra1937EktefelleAar;
    }

    public void setTrygdetidFra1937EktefelleAar(int trygdetidFra1937EktefelleAar) {
        this.trygdetidFra1937EktefelleAar = trygdetidFra1937EktefelleAar;
    }

    public int getTrygdetidFra1937EktefelleMaaneder() {
        return trygdetidFra1937EktefelleMaaneder;
    }

    public void setTrygdetidFra1937EktefelleMaaneder(int trygdetidFra1937EktefelleMaaneder) {
        this.trygdetidFra1937EktefelleMaaneder = trygdetidFra1937EktefelleMaaneder;
    }

    public String getOverkompensasjonUtlandEktefelle() {
        return overkompensasjonUtlandEktefelle;
    }

    public void setOverkompensasjonUtlandEktefelle(String overkompensasjonUtlandEktefelle) {
        this.overkompensasjonUtlandEktefelle = overkompensasjonUtlandEktefelle;
    }
}
