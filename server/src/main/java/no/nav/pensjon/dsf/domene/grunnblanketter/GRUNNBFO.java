package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBFO", length = 60)//FO
@UnmappedField(name = "filler", length = 4, start = 56)
public class GRUNNBFO {


    @Felt(name="EKTEFELLE_TILL", length = 1, start = 0) private String ektefelleTillegg;
    @Felt(name="ARBEIDSINNTEKT", length = 4, start = 1) @PackedDecimal private int arbeidsInntekt;
    @Felt(name="PENSJONSINNTEKT", length = 4, start = 5) @PackedDecimal private int pensjonsInntekt;
    @Felt(name="ARBEIDSINNTEKT_EK", length = 4, start = 9) @PackedDecimal private int arbeidsInntektEktefelle;
    @Felt(name="PENSJONSINNTEKT_EK", length = 4, start = 13) @PackedDecimal private int pensjonsInntektEktefelle;
    @Felt(name="BT_ANT", length = 2, start = 17) @PackedDecimal private int anntallBarnForForsorgertillegg;
    @Felt(name="MINST4G", length = 1, start = 19) private String minst4G;
    @Felt(name="FNR_EK", length = 6, start = 20) @PackedDecimal private int fodselsnummerEktefelle;
    @Felt(name="NAVN_EK", length = 25, start = 26) private String navnEktefelle;
    @Felt(name="INNT_PROVET_EOS_PENS", length = 1, start = 51) private String inntektsprovetEosPensjon;
    @Felt(name="TT_EOS_ANT_AAR", length = 2, start = 52) @PackedDecimal private int trygdetidEosAAr;
    @Felt(name="TT_EOS_ANT_MND", length = 2, start = 54) @PackedDecimal private int trygdetidEosMaaneder;

    public String getEktefelleTillegg() {
        return ektefelleTillegg;
    }

    public void setEktefelleTillegg(String ektefelleTillegg) {
        this.ektefelleTillegg = ektefelleTillegg;
    }

    public int getArbeidsInntekt() {
        return arbeidsInntekt;
    }

    public void setArbeidsInntekt(int arbeidsInntekt) {
        this.arbeidsInntekt = arbeidsInntekt;
    }

    public int getPensjonsInntekt() {
        return pensjonsInntekt;
    }

    public void setPensjonsInntekt(int pensjonsInntekt) {
        this.pensjonsInntekt = pensjonsInntekt;
    }

    public int getArbeidsInntektEktefelle() {
        return arbeidsInntektEktefelle;
    }

    public void setArbeidsInntektEktefelle(int arbeidsInntektEktefelle) {
        this.arbeidsInntektEktefelle = arbeidsInntektEktefelle;
    }

    public int getPensjonsInntektEktefelle() {
        return pensjonsInntektEktefelle;
    }

    public void setPensjonsInntektEktefelle(int pensjonsInntektEktefelle) {
        this.pensjonsInntektEktefelle = pensjonsInntektEktefelle;
    }

    public int getAnntallBarnForForsorgertillegg() {
        return anntallBarnForForsorgertillegg;
    }

    public void setAnntallBarnForForsorgertillegg(int anntallBarnForForsorgertillegg) {
        this.anntallBarnForForsorgertillegg = anntallBarnForForsorgertillegg;
    }

    public String getMinst4G() {
        return minst4G;
    }

    public void setMinst4G(String minst4G) {
        this.minst4G = minst4G;
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

    public String getInntektsprovetEosPensjon() {
        return inntektsprovetEosPensjon;
    }

    public void setInntektsprovetEosPensjon(String inntektsprovetEosPensjon) {
        this.inntektsprovetEosPensjon = inntektsprovetEosPensjon;
    }

    public int getTrygdetidEosAAr() {
        return trygdetidEosAAr;
    }

    public void setTrygdetidEosAAr(int trygdetidEosAAr) {
        this.trygdetidEosAAr = trygdetidEosAAr;
    }

    public int getTrygdetidEosMaaneder() {
        return trygdetidEosMaaneder;
    }

    public void setTrygdetidEosMaaneder(int trygdetidEosMaaneder) {
        this.trygdetidEosMaaneder = trygdetidEosMaaneder;
    }
}
