package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "ENBLAN1 " , length = 160)
@UnmappedField(name="FILLER", length = 3, start = 157)
public class ENBLAN1 {

    @Felt(name="FAI" , length = 3, start = 0) @PackedDecimal private int framtidigArbeidsinntekt;
    @Felt(name="UFG" , length = 2, start = 3) @PackedDecimal private int uforegrad;
    @Felt(name="FORVENTET_INNT" , length = 3, start = 5) @PackedDecimal private int forventetInntekt;
    @Felt(name="O_TIL_PENSJON", length = 1, start = 8) private String fraOvergangsstonadTilPensjon;
    @Felt(name="FRADRAG_2G", length = 1, start = 9) private String fradrag2G;
    @Felt(name="FRAMLEGGSDATO_AAMD" , length = 5, start = 10) @PackedDecimal private int framleggsdato;
    @Felt(name="OPPHOREO", length = 1, start = 15) private String opphortOvergangsstonadGjennlevende;
    @Felt(name="NAVNNY", length = 25, start = 16) private String nyttNavnStonadsmottaker;
    @Felt(name="NAVNNYEK", length = 25, start = 41) private String nyttNavnEktefelle;
    @Felt(name="FNR_EK" , length = 6, start = 66) @PackedDecimal private String fodselsnummerEktefelle;
    @Felt(name="NAVN_EK ", length = 25, start = 72) private String navnEktefelle;
    @Felt(name="SKILSMIS", length = 1, start = 97) private String skilsmisse;
    @Felt(name="FLYTTFRA", length = 1, start = 98) private String flyttetFraHverandre;
    @Felt(name="FLYTTSAM", length = 1, start = 99) private String flyttetSammen;
    @Felt(name="INNT_MINST_4G", length = 1, start = 100) private String inntektMins4G;
    @Felt(name="INNT_UNDER_4G", length = 1, start = 101) private String inntektUnder4G;
    @Felt(name="YUG" , length = 2, start = 102) @PackedDecimal private int yrkeUforegrad;
    @Felt(name="PENSJONSINNTEKT " , length = 4, start = 104) @PackedDecimal private int pensjonsinntekt;
    @Felt(name="ARBEIDSINNTEKT" , length = 4, start = 108) @PackedDecimal private int arbeidsinntekt;
    @Felt(name="PENSJONSINNTEKT_EK " , length = 4, start = 112) @PackedDecimal private int pensjonsinntektEktefelle;
    @Felt(name="ARBEIDSINNTEKT_EK" , length = 4, start = 116) @PackedDecimal private int arbeidsinntektEktefelle;
    @Felt(name="STATSBORGER" , length = 2, start = 120) @PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT" , length = 2, start = 122) @PackedDecimal private int bosattLand;
    @Felt(name="TP_NORDISK" , length = 4, start = 124) @PackedDecimal private int tilleggspensjonNordiskLand;
    @Felt(name="TP_NORDISK_LAND " , length = 2, start = 128) @PackedDecimal private int tilleggsPensjonFraNordiskLand;
    @Felt(name="PENSJON_EOS" , length = 4, start = 130) @PackedDecimal private int pensjonFraEOS;
    @Felt(name="SIVILSTATUS ", length = 1, start = 134) private String sivilstatus;
    @Felt(name="OPPHOR_SAMBO", length = 1, start = 135) private String opphorSamboer;
    @Felt(name="INNTEKT_FOR_UP" , length = 4, start = 136) @PackedDecimal private int inntektForUforepensjon;
    @Felt(name="INNT_DATO_AAMD" , length = 5, start = 140) @PackedDecimal private int inntektsdato;
    @Felt(name="REAKTIVISERING", length = 1, start = 145) private String reaktivisering;
    @Felt(name="UNNTAK_VENTETID ", length = 1, start = 146) private String unntattForVentetid;
    @Felt(name="FRYSP_5AAR_ARB", length = 1, start = 147) private String frysperiode5Aar;
    @Felt(name="FRYSP_TIDSB ", length = 1, start = 148) private String frysperiodeTidspunkt;
    @Felt(name="EK_INNT_OVER_2G ", length = 1, start = 149) private String inntektOver2GEktefelle;
    @Felt(name="INNT_PROVET_EOS_PENS", length = 1, start = 150) private String inntektsprovetIEOS;
    @Felt(name="TT_EOS_ANT_AAR" , length = 2, start = 151) @PackedDecimal private int trygdetidEOSAar;
    @Felt(name="TT_EOS_ANT_MND" , length = 2, start = 153) @PackedDecimal private int trygdetidEOSMaaneder;
    @Felt(name="RED_GP_3_2_5", length = 1, start = 155) private String epsInntektOverG;
    @Felt(name="LONNSTILSKUDD", length = 1, start = 156) private String lonnstilskudd;

    public int getFramtidigArbeidsinntekt() {
        return framtidigArbeidsinntekt;
    }

    public void setFramtidigArbeidsinntekt(int framtidigArbeidsinntekt) {
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt;
    }

    public int getUforegrad() {
        return uforegrad;
    }

    public void setUforegrad(int uforegrad) {
        this.uforegrad = uforegrad;
    }

    public int getForventetInntekt() {
        return forventetInntekt;
    }

    public void setForventetInntekt(int forventetInntekt) {
        this.forventetInntekt = forventetInntekt;
    }

    public String getFraOvergangsstonadTilPensjon() {
        return fraOvergangsstonadTilPensjon;
    }

    public void setFraOvergangsstonadTilPensjon(String fraOvergangsstonadTilPensjon) {
        this.fraOvergangsstonadTilPensjon = fraOvergangsstonadTilPensjon;
    }

    public String getFradrag2G() {
        return fradrag2G;
    }

    public void setFradrag2G(String fradrag2G) {
        this.fradrag2G = fradrag2G;
    }

    public int getFramleggsdato() {
        return framleggsdato;
    }

    public void setFramleggsdato(int framleggsdato) {
        this.framleggsdato = framleggsdato;
    }

    public String getOpphortOvergangsstonadGjennlevende() {
        return opphortOvergangsstonadGjennlevende;
    }

    public void setOpphortOvergangsstonadGjennlevende(String opphortOvergangsstonadGjennlevende) {
        this.opphortOvergangsstonadGjennlevende = opphortOvergangsstonadGjennlevende;
    }

    public String getNyttNavnStonadsmottaker() {
        return nyttNavnStonadsmottaker;
    }

    public void setNyttNavnStonadsmottaker(String nyttNavnStonadsmottaker) {
        this.nyttNavnStonadsmottaker = nyttNavnStonadsmottaker;
    }

    public String getNyttNavnEktefelle() {
        return nyttNavnEktefelle;
    }

    public void setNyttNavnEktefelle(String nyttNavnEktefelle) {
        this.nyttNavnEktefelle = nyttNavnEktefelle;
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

    public String getSkilsmisse() {
        return skilsmisse;
    }

    public void setSkilsmisse(String skilsmisse) {
        this.skilsmisse = skilsmisse;
    }

    public String getFlyttetFraHverandre() {
        return flyttetFraHverandre;
    }

    public void setFlyttetFraHverandre(String flyttetFraHverandre) {
        this.flyttetFraHverandre = flyttetFraHverandre;
    }

    public String getFlyttetSammen() {
        return flyttetSammen;
    }

    public void setFlyttetSammen(String flyttetSammen) {
        this.flyttetSammen = flyttetSammen;
    }

    public String getInntektMins4G() {
        return inntektMins4G;
    }

    public void setInntektMins4G(String inntektMins4G) {
        this.inntektMins4G = inntektMins4G;
    }

    public String getInntektUnder4G() {
        return inntektUnder4G;
    }

    public void setInntektUnder4G(String inntektUnder4G) {
        this.inntektUnder4G = inntektUnder4G;
    }

    public int getYrkeUforegrad() {
        return yrkeUforegrad;
    }

    public void setYrkeUforegrad(int yrkeUforegrad) {
        this.yrkeUforegrad = yrkeUforegrad;
    }

    public int getPensjonsinntekt() {
        return pensjonsinntekt;
    }

    public void setPensjonsinntekt(int pensjonsinntekt) {
        this.pensjonsinntekt = pensjonsinntekt;
    }

    public int getArbeidsinntekt() {
        return arbeidsinntekt;
    }

    public void setArbeidsinntekt(int arbeidsinntekt) {
        this.arbeidsinntekt = arbeidsinntekt;
    }

    public int getPensjonsinntektEktefelle() {
        return pensjonsinntektEktefelle;
    }

    public void setPensjonsinntektEktefelle(int pensjonsinntektEktefelle) {
        this.pensjonsinntektEktefelle = pensjonsinntektEktefelle;
    }

    public int getArbeidsinntektEktefelle() {
        return arbeidsinntektEktefelle;
    }

    public void setArbeidsinntektEktefelle(int arbeidsinntektEktefelle) {
        this.arbeidsinntektEktefelle = arbeidsinntektEktefelle;
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

    public int getTilleggspensjonNordiskLand() {
        return tilleggspensjonNordiskLand;
    }

    public void setTilleggspensjonNordiskLand(int tilleggspensjonNordiskLand) {
        this.tilleggspensjonNordiskLand = tilleggspensjonNordiskLand;
    }

    public int getTilleggsPensjonFraNordiskLand() {
        return tilleggsPensjonFraNordiskLand;
    }

    public void setTilleggsPensjonFraNordiskLand(int tilleggsPensjonFraNordiskLand) {
        this.tilleggsPensjonFraNordiskLand = tilleggsPensjonFraNordiskLand;
    }

    public int getPensjonFraEOS() {
        return pensjonFraEOS;
    }

    public void setPensjonFraEOS(int pensjonFraEOS) {
        this.pensjonFraEOS = pensjonFraEOS;
    }

    public String getSivilstatus() {
        return sivilstatus;
    }

    public void setSivilstatus(String sivilstatus) {
        this.sivilstatus = sivilstatus;
    }

    public String getOpphorSamboer() {
        return opphorSamboer;
    }

    public void setOpphorSamboer(String opphorSamboer) {
        this.opphorSamboer = opphorSamboer;
    }

    public int getInntektForUforepensjon() {
        return inntektForUforepensjon;
    }

    public void setInntektForUforepensjon(int inntektForUforepensjon) {
        this.inntektForUforepensjon = inntektForUforepensjon;
    }

    public int getInntektsdato() {
        return inntektsdato;
    }

    public void setInntektsdato(int inntektsdato) {
        this.inntektsdato = inntektsdato;
    }

    public String getReaktivisering() {
        return reaktivisering;
    }

    public void setReaktivisering(String reaktivisering) {
        this.reaktivisering = reaktivisering;
    }

    public String getUnntattForVentetid() {
        return unntattForVentetid;
    }

    public void setUnntattForVentetid(String unntattForVentetid) {
        this.unntattForVentetid = unntattForVentetid;
    }

    public String getFrysperiode5Aar() {
        return frysperiode5Aar;
    }

    public void setFrysperiode5Aar(String frysperiode5Aar) {
        this.frysperiode5Aar = frysperiode5Aar;
    }

    public String getFrysperiodeTidspunkt() {
        return frysperiodeTidspunkt;
    }

    public void setFrysperiodeTidspunkt(String frysperiodeTidspunkt) {
        this.frysperiodeTidspunkt = frysperiodeTidspunkt;
    }

    public String getInntektOver2GEktefelle() {
        return inntektOver2GEktefelle;
    }

    public void setInntektOver2GEktefelle(String inntektOver2GEktefelle) {
        this.inntektOver2GEktefelle = inntektOver2GEktefelle;
    }

    public String getInntektsprovetIEOS() {
        return inntektsprovetIEOS;
    }

    public void setInntektsprovetIEOS(String inntektsprovetIEOS) {
        this.inntektsprovetIEOS = inntektsprovetIEOS;
    }

    public int getTrygdetidEOSAar() {
        return trygdetidEOSAar;
    }

    public void setTrygdetidEOSAar(int trygdetidEOSAar) {
        this.trygdetidEOSAar = trygdetidEOSAar;
    }

    public int getTrygdetidEOSMaaneder() {
        return trygdetidEOSMaaneder;
    }

    public void setTrygdetidEOSMaaneder(int trygdetidEOSMaaneder) {
        this.trygdetidEOSMaaneder = trygdetidEOSMaaneder;
    }

    public String getEpsInntektOverG() {
        return epsInntektOverG;
    }

    public void setEpsInntektOverG(String epsInntektOverG) {
        this.epsInntektOverG = epsInntektOverG;
    }

    public String getLonnstilskudd() {
        return lonnstilskudd;
    }

    public void setLonnstilskudd(String lonnstilskudd) {
        this.lonnstilskudd = lonnstilskudd;
    }
}
