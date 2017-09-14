package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "ENDRBLAN", length = 110)
@UnmappedField(name="FILLER", length = 2, start = 108)
public class ENDRBLAN {

    @Felt(name="FAI" , length = 3, start = 0) @PackedDecimal private int framtidigArbeidsinntekt;
    @Felt(name="APD_MAX" , length = 1, start = 3) private String hoyestePensjonsgrad;
    @Felt(name="APD" , length = 2, start = 4) @PackedDecimal private int alderspensjonsdelIProsent;
    @Felt(name="UFG" , length = 2, start = 6) @PackedDecimal private int uforegrad;
    @Felt(name="FORVENTET_INNT" , length = 3, start = 8) @PackedDecimal private int forventetInntekt;
    @Felt(name="O_TIL_PENSJON" , length = 1, start = 11) private String overgangsstonadTilPensjon;
    @Felt(name="TP_PROSENT" , length = 2, start = 12) @PackedDecimal private int tilleggspensjonForGjenlevendePensjonIProsent;
    @Felt(name="FRAMLEGGSDATO_AAMD" , length = 5, start = 14) @PackedDecimal private int framleggsdato;
    @Felt(name="OPPHOREO" , length = 1, start = 19) private String opphortOvergangsstonadGjennlevende;
    @Felt(name="NAVNNY" , length = 25, start = 20) private String nyttNavnPensjonist;
    @Felt(name="NAVNNYEK" , length = 25, start = 45) private String nyttNavnEps;
    @Felt(name="FNR_EK" , length = 6, start = 70) @PackedDecimal private String fodselsnummerEktefelle;
    @Felt(name="NAVN_EK" , length = 25, start = 76) private String navnEktefelle;
    @Felt(name="SKILSMIS" , length = 1, start = 101) private String skilsmisse;
    @Felt(name="FLYTTFRA" , length = 1, start = 102) private String flyttetFraHverandre;
    @Felt(name="FLYTTSAM" , length = 1, start = 103) private String flyttetSammen;
    @Felt(name="INNT_MINST_4G" , length = 1, start = 104) private String inntektMinst4G;
    @Felt(name="INNT_UNDER_4G" , length = 1, start = 105) private String inntektUnder4G;
    @Felt(name="YUG" , length = 2, start = 106) @PackedDecimal private int yrkeUforegrad;

    public int getFramtidigArbeidsinntekt() {
        return framtidigArbeidsinntekt;
    }

    public void setFramtidigArbeidsinntekt(int framtidigArbeidsinntekt) {
        this.framtidigArbeidsinntekt = framtidigArbeidsinntekt;
    }

    public String getHoyestePensjonsgrad() {
        return hoyestePensjonsgrad;
    }

    public void setHoyestePensjonsgrad(String hoyestePensjonsgrad) {
        this.hoyestePensjonsgrad = hoyestePensjonsgrad;
    }

    public int getAlderspensjonsdelIProsent() {
        return alderspensjonsdelIProsent;
    }

    public void setAlderspensjonsdelIProsent(int alderspensjonsdelIProsent) {
        this.alderspensjonsdelIProsent = alderspensjonsdelIProsent;
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

    public String getOvergangsstonadTilPensjon() {
        return overgangsstonadTilPensjon;
    }

    public void setOvergangsstonadTilPensjon(String overgangsstonadTilPensjon) {
        this.overgangsstonadTilPensjon = overgangsstonadTilPensjon;
    }

    public int getTilleggspensjonForGjenlevendePensjonIProsent() {
        return tilleggspensjonForGjenlevendePensjonIProsent;
    }

    public void setTilleggspensjonForGjenlevendePensjonIProsent(int tilleggspensjonForGjenlevendePensjonIProsent) {
        this.tilleggspensjonForGjenlevendePensjonIProsent = tilleggspensjonForGjenlevendePensjonIProsent;
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

    public String getNyttNavnPensjonist() {
        return nyttNavnPensjonist;
    }

    public void setNyttNavnPensjonist(String nyttNavnPensjonist) {
        this.nyttNavnPensjonist = nyttNavnPensjonist;
    }

    public String getNyttNavnEps() {
        return nyttNavnEps;
    }

    public void setNyttNavnEps(String nyttNavnEps) {
        this.nyttNavnEps = nyttNavnEps;
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

    public String getInntektMinst4G() {
        return inntektMinst4G;
    }

    public void setInntektMinst4G(String inntektMinst4G) {
        this.inntektMinst4G = inntektMinst4G;
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
}
