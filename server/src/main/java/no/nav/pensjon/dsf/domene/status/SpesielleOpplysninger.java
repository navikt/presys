package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "SPESOPPL", length = 56)
@UnmappedField(name="FILLER", length = 9, start = 47)
public class SpesielleOpplysninger {

    @Felt(name="STATSBORGER", length = 2, start = 0) @PackedDecimal private int statsborgerskap;
    @Felt(name="FRAVIK_FLYKTN", length = 1, start = 2) private String fravikFlyktning;
    @Felt(name="OVERKOMP_UTL", length = 1, start = 3) private String overkompensasjonUtland;
    @Felt(name="BOSATT", length = 2, start = 4) @PackedDecimal private int bosattLand;
    @Felt(name="FRAVIK_BOSATT", length = 1, start = 6) private String fravikBosatt;
    @Felt(name="FRAVIK_TRYGDET_3AAR", length = 1, start = 7) private String fravikTrygdet3Aar;
    @Felt(name="FRAVIK_19_3", length = 1, start = 8) private String fravikPar19Pkt3;
    @Felt(name="FRAVIK_8_1", length = 1, start = 9) private String fravikPar8Pkt1;
    @Felt(name="FRAVIK_10_1", length = 1, start = 10) private String fravikPar10Pkt1;
    @Felt(name="KONVENSJON", length = 1, start = 11) private String konvensjon;
    @Felt(name="IKKE_GP", length = 1, start = 12) private String ikkeGrunnpensjon;
    @Felt(name="TRYGDET_DOD", length = 1, start = 13) private String trygdetDod;
    @Felt(name="TRYGDET_3AAR_DOD", length = 1, start = 14) private String trygdet3AarDod;
    @Felt(name="UFOR_UNDER_BOTID", length = 1, start = 15) private String uforUnderBotid;
    @Felt(name="TT_FRAMT_UFT", length = 2, start = 16) @PackedDecimal private int trygdetidFramtidigUforetrygd;
    @Felt(name="TT_FRAMT_VED_FRAVIK_8_1", length = 2, start = 18) @PackedDecimal private int trygdetidFramtidigVentetidFravikPar8Pkt1;
    @Felt(name="TT_FRAMT_DOD", length = 2, start = 20) @PackedDecimal private int trygdetidFramtidigDod;
    @Felt(name="TT_FRAMT_VED_FRAVIK_10_1", length = 2, start = 22) @PackedDecimal private int trygdetidFramtidigVentetidFravikPar10Pkt1;
    @Felt(name="TT_VENT_UTL", length = 2, start = 24) @PackedDecimal private int trygdetidFramtidigVentetidUtland;
    @Felt(name="IKKE_TT_FRAMT_DOD", length = 1, start = 26) private String ikkeTrygdetidFramtidigDod;
    @Felt(name="PENSJONSTRYGDET", length = 1, start = 27) private String pensjonstrygdet;
    @Felt(name="MINST_20AAR_BOTID", length = 1, start = 28) private String minst20AarBotid;
    @Felt(name="FRAVIK_BOSATT_KONVENSJON", length = 1, start = 29) private String fravikBosattKonvensjon;
    @Felt(name="KONVENSJON_LAND", length = 2, start = 30) @PackedDecimal private int konvensjonsland;
    @Felt(name="FRAVIK_BOSATT_EOS", length = 1, start = 32) private String fravikBosattEos;
    @Felt(name="TP_NORDISK", length = 3, start = 33) @PackedDecimal private int tjenestepensjonNordisk;
    @Felt(name="TP_NORDISK_LAND", length = 2, start = 36) @PackedDecimal private int tjenestepensjonNordiskLand;
    @Felt(name="TT_KONVENSJON_AAR", length = 2, start = 38) @PackedDecimal private int trygdetidKonvensjonAar;
    @Felt(name="UNNTAK_12_2", length = 1, start = 40) private String unntakPar12Pkt2;
    @Felt(name="TT_PAA", length = 1, start = 41) private String trygdetidPoengaar;
    @Felt(name="TT_FRAMTIDIG", length = 1, start = 42) private String trygdetidFramtidig;
    @Felt(name="TT_FAKTISK", length = 1, start = 43) private String trygdetidFaktisk;
    @Felt(name="FRAVIK_5_1", length = 1, start = 44) private String fravikPar5Pkt1;
    @Felt(name="UNG_UFOR", length = 1, start = 45) private String ungUfor;
    @Felt(name="KONVENSJON_TP", length = 1, start = 46) private String konvensjonTjenestepensjon;

    public int getStatsborgerskap() {
        return statsborgerskap;
    }

    public void setStatsborgerskap(int statsborgerskap) {
        this.statsborgerskap = statsborgerskap;
    }

    public String getFravikFlyktning() {
        return fravikFlyktning;
    }

    public void setFravikFlyktning(String fravikFlyktning) {
        this.fravikFlyktning = fravikFlyktning;
    }

    public String getOverkompensasjonUtland() {
        return overkompensasjonUtland;
    }

    public void setOverkompensasjonUtland(String overkompensasjonUtland) {
        this.overkompensasjonUtland = overkompensasjonUtland;
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

    public String getFravikPar8Pkt1() {
        return fravikPar8Pkt1;
    }

    public void setFravikPar8Pkt1(String fravikPar8Pkt1) {
        this.fravikPar8Pkt1 = fravikPar8Pkt1;
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

    public String getIkkeGrunnpensjon() {
        return ikkeGrunnpensjon;
    }

    public void setIkkeGrunnpensjon(String ikkeGrunnpensjon) {
        this.ikkeGrunnpensjon = ikkeGrunnpensjon;
    }

    public String getTrygdetDod() {
        return trygdetDod;
    }

    public void setTrygdetDod(String trygdetDod) {
        this.trygdetDod = trygdetDod;
    }

    public String getTrygdet3AarDod() {
        return trygdet3AarDod;
    }

    public void setTrygdet3AarDod(String trygdet3AarDod) {
        this.trygdet3AarDod = trygdet3AarDod;
    }

    public String getUforUnderBotid() {
        return uforUnderBotid;
    }

    public void setUforUnderBotid(String uforUnderBotid) {
        this.uforUnderBotid = uforUnderBotid;
    }

    public int getTrygdetidFramtidigUforetrygd() {
        return trygdetidFramtidigUforetrygd;
    }

    public void setTrygdetidFramtidigUforetrygd(int trygdetidFramtidigUforetrygd) {
        this.trygdetidFramtidigUforetrygd = trygdetidFramtidigUforetrygd;
    }

    public int getTrygdetidFramtidigVentetidFravikPar8Pkt1() {
        return trygdetidFramtidigVentetidFravikPar8Pkt1;
    }

    public void setTrygdetidFramtidigVentetidFravikPar8Pkt1(int trygdetidFramtidigVentetidFravikPar8Pkt1) {
        this.trygdetidFramtidigVentetidFravikPar8Pkt1 = trygdetidFramtidigVentetidFravikPar8Pkt1;
    }

    public int getTrygdetidFramtidigDod() {
        return trygdetidFramtidigDod;
    }

    public void setTrygdetidFramtidigDod(int trygdetidFramtidigDod) {
        this.trygdetidFramtidigDod = trygdetidFramtidigDod;
    }

    public int getTrygdetidFramtidigVentetidFravikPar10Pkt1() {
        return trygdetidFramtidigVentetidFravikPar10Pkt1;
    }

    public void setTrygdetidFramtidigVentetidFravikPar10Pkt1(int trygdetidFramtidigVentetidFravikPar10Pkt1) {
        this.trygdetidFramtidigVentetidFravikPar10Pkt1 = trygdetidFramtidigVentetidFravikPar10Pkt1;
    }

    public int getTrygdetidFramtidigVentetidUtland() {
        return trygdetidFramtidigVentetidUtland;
    }

    public void setTrygdetidFramtidigVentetidUtland(int trygdetidFramtidigVentetidUtland) {
        this.trygdetidFramtidigVentetidUtland = trygdetidFramtidigVentetidUtland;
    }

    public String getIkkeTrygdetidFramtidigDod() {
        return ikkeTrygdetidFramtidigDod;
    }

    public void setIkkeTrygdetidFramtidigDod(String ikkeTrygdetidFramtidigDod) {
        this.ikkeTrygdetidFramtidigDod = ikkeTrygdetidFramtidigDod;
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

    public String getFravikBosattKonvensjon() {
        return fravikBosattKonvensjon;
    }

    public void setFravikBosattKonvensjon(String fravikBosattKonvensjon) {
        this.fravikBosattKonvensjon = fravikBosattKonvensjon;
    }

    public int getKonvensjonsland() {
        return konvensjonsland;
    }

    public void setKonvensjonsland(int konvensjonsland) {
        this.konvensjonsland = konvensjonsland;
    }

    public String getFravikBosattEos() {
        return fravikBosattEos;
    }

    public void setFravikBosattEos(String fravikBosattEos) {
        this.fravikBosattEos = fravikBosattEos;
    }

    public int getTjenestepensjonNordisk() {
        return tjenestepensjonNordisk;
    }

    public void setTjenestepensjonNordisk(int tjenestepensjonNordisk) {
        this.tjenestepensjonNordisk = tjenestepensjonNordisk;
    }

    public int getTjenestepensjonNordiskLand() {
        return tjenestepensjonNordiskLand;
    }

    public void setTjenestepensjonNordiskLand(int tjenestepensjonNordiskLand) {
        this.tjenestepensjonNordiskLand = tjenestepensjonNordiskLand;
    }

    public int getTrygdetidKonvensjonAar() {
        return trygdetidKonvensjonAar;
    }

    public void setTrygdetidKonvensjonAar(int trygdetidKonvensjonAar) {
        this.trygdetidKonvensjonAar = trygdetidKonvensjonAar;
    }

    public String getUnntakPar12Pkt2() {
        return unntakPar12Pkt2;
    }

    public void setUnntakPar12Pkt2(String unntakPar12Pkt2) {
        this.unntakPar12Pkt2 = unntakPar12Pkt2;
    }

    public String getTrygdetidPoengaar() {
        return trygdetidPoengaar;
    }

    public void setTrygdetidPoengaar(String trygdetidPoengaar) {
        this.trygdetidPoengaar = trygdetidPoengaar;
    }

    public String getTrygdetidFramtidig() {
        return trygdetidFramtidig;
    }

    public void setTrygdetidFramtidig(String trygdetidFramtidig) {
        this.trygdetidFramtidig = trygdetidFramtidig;
    }

    public String getTrygdetidFaktisk() {
        return trygdetidFaktisk;
    }

    public void setTrygdetidFaktisk(String trygdetidFaktisk) {
        this.trygdetidFaktisk = trygdetidFaktisk;
    }

    public String getFravikPar5Pkt1() {
        return fravikPar5Pkt1;
    }

    public void setFravikPar5Pkt1(String fravikPar5Pkt1) {
        this.fravikPar5Pkt1 = fravikPar5Pkt1;
    }

    public String getUngUfor() {
        return ungUfor;
    }

    public void setUngUfor(String ungUfor) {
        this.ungUfor = ungUfor;
    }

    public String getKonvensjonTjenestepensjon() {
        return konvensjonTjenestepensjon;
    }

    public void setKonvensjonTjenestepensjon(String konvensjonTjenestepensjon) {
        this.konvensjonTjenestepensjon = konvensjonTjenestepensjon;
    }
}
