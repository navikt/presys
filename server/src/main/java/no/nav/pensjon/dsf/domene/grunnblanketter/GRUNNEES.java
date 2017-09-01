package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@UnmappedField(name="FILLER", length = 29, start = 70)
@Segment(name = "GRUNNEES", length = 98)//99
public class GRUNNEES {

    //Feltene nedenfor tilhører gjenlendene/søke
    @Felt(name="STATSBORGER", length = 2, start = 0) @PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT", length = 2, start = 2) @PackedDecimal private int bosattLand;
    @Felt(name="MEDLEM", length = 1, start = 4) private String medlem;
    @Felt(name="TT_LIK_PAA", length = 1, start = 5) private String trygdatidLikPensjonsAar;
    @Felt(name="MINST_20AAR", length = 1, start = 6) private String minst20AarBotid;
    @Felt(name="KONVENSJON_LAND", length = 2, start = 7) @PackedDecimal private int konvensjonsLand;
    @Felt(name="FRAVIK_BOSATT_EOS", length = 1, start = 9) private String fravikBosattEos;
    @Felt(name="UNG_UFOR", length = 1, start = 10) private String ungUfor;
    @Felt(name="FRAVIK_FLYKT", length = 1, start = 11) private String erFlyktning;
    @Felt(name="TT_ENDRES", length = 1, start = 12) private String trygdetidEndres;

    //Feltene nedenfor tilhører avdøde
    @Felt(name="STATSBORGER_EK", length = 2, start = 13) @PackedDecimal private int statsborgerskapEktefelle;
    @Felt(name="BOSATT_EK", length = 2, start = 15) @PackedDecimal private int bosattLandEktefelle;
    @Felt(name="FRAVIK_FLYKT_EK", length = 1, start = 17) private String fravikFlyktningEktefelle;
    @Felt(name="FRAVIK_17_3_4A", length = 1, start = 18) private String fravikPar17Pkt3Ledd4BokstavA;
    @Felt(name="FRAVIK_17_3_4B", length = 1, start = 19) private String fravikPar17Pkt3Ledd4BokstavB;
    @Felt(name="OVERKOMP_UTL_EK", length = 1, start = 20) private String overkompensasjonUtlandEktefelle;
    @Felt(name="TT_FRA_1937_AAR_EK", length = 2, start = 21) @PackedDecimal private int trygdetidFra1937AArEktefelle;
    @Felt(name="TT_FRA_1937_MND_EK", length = 2, start = 23) @PackedDecimal private int trygdetidFra1937MaanederEktefelle;
    @Felt(name="TT_KONVENSJON_AAR_EK", length = 2, start = 25) @PackedDecimal private int trygdetidKonvensjonAarEktefelle;
    @Felt(name="BEREGN_FOLKETRYGD", length = 1, start = 27) private String beregnFolketrygd;
    @Felt(name="EOS_3_17A", length = 1, start = 28) private String eosPar3Pkt17BokstavA;
    //EOS_AAR (1967:2014)           BIT(1),
    @Felt(name="EOS_AAR (1967:2014)", length = 6, start = 29) private String eosAar;
    //EOS_AAR_IKKE_PRO_RATA (1967:2014)     BIT(1),
    @Felt(name="EOS_AAR_IKKE_PRO_RATA (1967:2014)", length = 6, start = 35) private String eosAarIkkeProrata;
    @Felt(name="TT_TEORETISK_AAR", length = 2, start = 41) @PackedDecimal private int trygdetidTeoretiskAar;
    @Felt(name="TT_TEORETISK_MND", length = 2, start = 43) @PackedDecimal private int trygdetidTeoretiskMaaneder;
    @Felt(name="TT_PRORATA_AAR", length = 2, start = 45) @PackedDecimal private int trygdetidProrataAar;
    @Felt(name="TT_PRORATA_MND", length = 2, start = 47) @PackedDecimal private int trygdetidProrataMaaneder;
    @Felt(name="PENSJON_EOS", length = 3, start = 49) @PackedDecimal private int pensjonEos;
    //EOS_AAR_PRO_RATA2(1967:2014)      BIT(1),
    @Felt(name="EOS_AAR_PRO_RATA2(1967:2014)", length = 6, start = 52) private String eosAarProrata2;
    @Felt(name="TT_PRORATA2_AAR", length = 2, start = 58) @PackedDecimal private int trygdetidProrata2Aar;
    @Felt(name="TT_PRORATA2_MND", length = 2, start = 60) @PackedDecimal private int trygdetidProrata2Maaneder;
    @Felt(name="TT_FAKTISK_NORDISK_AAR", length = 2, start = 62) @PackedDecimal private int trygdetidFaktiskNordiskAar;
    @Felt(name="TT_FAKTISK_NORDISK_MND", length = 2, start = 64) @PackedDecimal private int trygdetidFaktiskNordiskMaaneder;
    @Felt(name="PAA_FAKTISK_NORDISK", length = 2, start = 66) @PackedDecimal private int pensjonsaarFaktiskNordisk;
    @Felt(name="INNT_PROVET_EOS_PENS", length = 1, start = 68) private String inntektsprovetEosPensjon;
    @Felt(name="EOS_OPPLYSN", length = 1, start = 69) private String eosOpplysning;

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

    public String getMedlem() {
        return medlem;
    }

    public void setMedlem(String medlem) {
        this.medlem = medlem;
    }

    public String getTrygdatidLikPensjonsAar() {
        return trygdatidLikPensjonsAar;
    }

    public void setTrygdatidLikPensjonsAar(String trygdatidLikPensjonsAar) {
        this.trygdatidLikPensjonsAar = trygdatidLikPensjonsAar;
    }

    public String getMinst20AarBotid() {
        return minst20AarBotid;
    }

    public void setMinst20AarBotid(String minst20AarBotid) {
        this.minst20AarBotid = minst20AarBotid;
    }

    public int getKonvensjonsLand() {
        return konvensjonsLand;
    }

    public void setKonvensjonsLand(int konvensjonsLand) {
        this.konvensjonsLand = konvensjonsLand;
    }

    public String getFravikBosattEos() {
        return fravikBosattEos;
    }

    public void setFravikBosattEos(String fravikBosattEos) {
        this.fravikBosattEos = fravikBosattEos;
    }

    public String getUngUfor() {
        return ungUfor;
    }

    public void setUngUfor(String ungUfor) {
        this.ungUfor = ungUfor;
    }

    public String getErFlyktning() {
        return erFlyktning;
    }

    public void setErFlyktning(String erFlyktning) {
        this.erFlyktning = erFlyktning;
    }

    public String getTrygdetidEndres() {
        return trygdetidEndres;
    }

    public void setTrygdetidEndres(String trygdetidEndres) {
        this.trygdetidEndres = trygdetidEndres;
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

    public String getFravikFlyktningEktefelle() {
        return fravikFlyktningEktefelle;
    }

    public void setFravikFlyktningEktefelle(String fravikFlyktningEktefelle) {
        this.fravikFlyktningEktefelle = fravikFlyktningEktefelle;
    }

    public String getFravikPar17Pkt3Ledd4BokstavA() {
        return fravikPar17Pkt3Ledd4BokstavA;
    }

    public void setFravikPar17Pkt3Ledd4BokstavA(String fravikPar17Pkt3Ledd4BokstavA) {
        this.fravikPar17Pkt3Ledd4BokstavA = fravikPar17Pkt3Ledd4BokstavA;
    }

    public String getFravikPar17Pkt3Ledd4BokstavB() {
        return fravikPar17Pkt3Ledd4BokstavB;
    }

    public void setFravikPar17Pkt3Ledd4BokstavB(String fravikPar17Pkt3Ledd4BokstavB) {
        this.fravikPar17Pkt3Ledd4BokstavB = fravikPar17Pkt3Ledd4BokstavB;
    }

    public String getOverkompensasjonUtlandEktefelle() {
        return overkompensasjonUtlandEktefelle;
    }

    public void setOverkompensasjonUtlandEktefelle(String overkompensasjonUtlandEktefelle) {
        this.overkompensasjonUtlandEktefelle = overkompensasjonUtlandEktefelle;
    }

    public int getTrygdetidFra1937AArEktefelle() {
        return trygdetidFra1937AArEktefelle;
    }

    public void setTrygdetidFra1937AArEktefelle(int trygdetidFra1937AArEktefelle) {
        this.trygdetidFra1937AArEktefelle = trygdetidFra1937AArEktefelle;
    }

    public int getTrygdetidFra1937MaanederEktefelle() {
        return trygdetidFra1937MaanederEktefelle;
    }

    public void setTrygdetidFra1937MaanederEktefelle(int trygdetidFra1937MaanederEktefelle) {
        this.trygdetidFra1937MaanederEktefelle = trygdetidFra1937MaanederEktefelle;
    }

    public int getTrygdetidKonvensjonAarEktefelle() {
        return trygdetidKonvensjonAarEktefelle;
    }

    public void setTrygdetidKonvensjonAarEktefelle(int trygdetidKonvensjonAarEktefelle) {
        this.trygdetidKonvensjonAarEktefelle = trygdetidKonvensjonAarEktefelle;
    }

    public String getBeregnFolketrygd() {
        return beregnFolketrygd;
    }

    public void setBeregnFolketrygd(String beregnFolketrygd) {
        this.beregnFolketrygd = beregnFolketrygd;
    }

    public String getEosPar3Pkt17BokstavA() {
        return eosPar3Pkt17BokstavA;
    }

    public void setEosPar3Pkt17BokstavA(String eosPar3Pkt17BokstavA) {
        this.eosPar3Pkt17BokstavA = eosPar3Pkt17BokstavA;
    }

    public String getEosAar() {
        return eosAar;
    }

    public void setEosAar(String eosAar) {
        this.eosAar = eosAar;
    }

    public String getEosAarIkkeProrata() {
        return eosAarIkkeProrata;
    }

    public void setEosAarIkkeProrata(String eosAarIkkeProrata) {
        this.eosAarIkkeProrata = eosAarIkkeProrata;
    }

    public int getTrygdetidTeoretiskAar() {
        return trygdetidTeoretiskAar;
    }

    public void setTrygdetidTeoretiskAar(int trygdetidTeoretiskAar) {
        this.trygdetidTeoretiskAar = trygdetidTeoretiskAar;
    }

    public int getTrygdetidTeoretiskMaaneder() {
        return trygdetidTeoretiskMaaneder;
    }

    public void setTrygdetidTeoretiskMaaneder(int trygdetidTeoretiskMaaneder) {
        this.trygdetidTeoretiskMaaneder = trygdetidTeoretiskMaaneder;
    }

    public int getTrygdetidProrataAar() {
        return trygdetidProrataAar;
    }

    public void setTrygdetidProrataAar(int trygdetidProrataAar) {
        this.trygdetidProrataAar = trygdetidProrataAar;
    }

    public int getTrygdetidProrataMaaneder() {
        return trygdetidProrataMaaneder;
    }

    public void setTrygdetidProrataMaaneder(int trygdetidProrataMaaneder) {
        this.trygdetidProrataMaaneder = trygdetidProrataMaaneder;
    }

    public int getPensjonEos() {
        return pensjonEos;
    }

    public void setPensjonEos(int pensjonEos) {
        this.pensjonEos = pensjonEos;
    }

    public String getEosAarProrata2() {
        return eosAarProrata2;
    }

    public void setEosAarProrata2(String eosAarProrata2) {
        this.eosAarProrata2 = eosAarProrata2;
    }

    public int getTrygdetidProrata2Aar() {
        return trygdetidProrata2Aar;
    }

    public void setTrygdetidProrata2Aar(int trygdetidProrata2Aar) {
        this.trygdetidProrata2Aar = trygdetidProrata2Aar;
    }

    public int getTrygdetidProrata2Maaneder() {
        return trygdetidProrata2Maaneder;
    }

    public void setTrygdetidProrata2Maaneder(int trygdetidProrata2Maaneder) {
        this.trygdetidProrata2Maaneder = trygdetidProrata2Maaneder;
    }

    public int getTrygdetidFaktiskNordiskAar() {
        return trygdetidFaktiskNordiskAar;
    }

    public void setTrygdetidFaktiskNordiskAar(int trygdetidFaktiskNordiskAar) {
        this.trygdetidFaktiskNordiskAar = trygdetidFaktiskNordiskAar;
    }

    public int getTrygdetidFaktiskNordiskMaaneder() {
        return trygdetidFaktiskNordiskMaaneder;
    }

    public void setTrygdetidFaktiskNordiskMaaneder(int trygdetidFaktiskNordiskMaaneder) {
        this.trygdetidFaktiskNordiskMaaneder = trygdetidFaktiskNordiskMaaneder;
    }

    public int getPensjonsaarFaktiskNordisk() {
        return pensjonsaarFaktiskNordisk;
    }

    public void setPensjonsaarFaktiskNordisk(int pensjonsaarFaktiskNordisk) {
        this.pensjonsaarFaktiskNordisk = pensjonsaarFaktiskNordisk;
    }

    public String getInntektsprovetEosPensjon() {
        return inntektsprovetEosPensjon;
    }

    public void setInntektsprovetEosPensjon(String inntektsprovetEosPensjon) {
        this.inntektsprovetEosPensjon = inntektsprovetEosPensjon;
    }

    public String getEosOpplysning() {
        return eosOpplysning;
    }

    public void setEosOpplysning(String eosOpplysning) {
        this.eosOpplysning = eosOpplysning;
    }
}
