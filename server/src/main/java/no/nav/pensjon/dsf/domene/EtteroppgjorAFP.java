package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name="EOAFP", length = 60)
@UnmappedField(name = "filler", length = 10, start = 50)
public class EtteroppgjorAFP {

    @Felt(name="INNTEKTSÅR", length = 3, start = 0)
    @PackedDecimal
    private int inntektsAar;

    @Felt(name="PGI", length = 5, start = 3)
    @PackedDecimal
    private int pensjonsgivendeInntekt;

    @Felt(name="IFU", length = 5, start = 8)
    @PackedDecimal
    private int inntektForUttakAvAFP;

    @Felt(name="IFU_merke", length = 1, start = 13)
    private String registertViaDSFEllerInfotrygdIFU;

    @Felt(name="IEO", length = 5, start = 14)
    @PackedDecimal
    private int inntektEtterOpphor;

    @Felt(name="IEO_merke", length = 1, start = 19)
    private String registertViaDSFEllerInfotrygdIEO;

    @Felt(name="IIAP", length = 5, start = 20)
    @PackedDecimal
    private int inntektIAFPPerioden;

    @Felt(name="IIAP_merke", length = 1, start = 25)
    private String beregnetEllerRegistrertViaInfotrygd;

    @Felt(name="FAIP", length = 4, start = 26)
    @PackedDecimal
    private int oppgittFramtidigInntekt;

    @Felt(name="TEI_IAP", length = 4, start = 30)
    @PackedDecimal
    private int tidligereInntekt;

    @Felt(name="PFP", length = 4, start = 34)
    @PackedDecimal
    private int fullAFPiAvregningsperioden;

    @Felt(name="FPFP", length = 4, start = 38)
    @PackedDecimal
    private int faktiskUtbetalt;

    @Felt(name="DFMU", length = 4, start = 42)
    @PackedDecimal
    private int differanseForMyeUtbetalt;

    @Felt(name="DFLU", length = 4, start = 46)
    @PackedDecimal
    private int differanseForLiteUtbetalt;

    public int getInntektsAar() {
        return inntektsAar;
    }

    public void setInntektsAar(int inntektsAar) {
        this.inntektsAar = inntektsAar;
    }

    public int getPensjonsgivendeInntekt() {
        return pensjonsgivendeInntekt;
    }

    public void setPensjonsgivendeInntekt(int pensjonsgivendeInntekt) {
        this.pensjonsgivendeInntekt = pensjonsgivendeInntekt;
    }

    public int getInntektForUttakAvAFP() {
        return inntektForUttakAvAFP;
    }

    public void setInntektForUttakAvAFP(int inntektForUttakAvAFP) {
        this.inntektForUttakAvAFP = inntektForUttakAvAFP;
    }

    public String getRegistertViaDSFEllerInfotrygdIFU() {
        return registertViaDSFEllerInfotrygdIFU;
    }

    public void setRegistertViaDSFEllerInfotrygdIFU(String registertViaDSFEllerInfotrygdIFU) {
        this.registertViaDSFEllerInfotrygdIFU = registertViaDSFEllerInfotrygdIFU;
    }

    public int getInntektEtterOpphor() {
        return inntektEtterOpphor;
    }

    public void setInntektEtterOpphor(int inntektEtterOpphor) {
        this.inntektEtterOpphor = inntektEtterOpphor;
    }

    public String getRegistertViaDSFEllerInfotrygdIEO() {
        return registertViaDSFEllerInfotrygdIEO;
    }

    public void setRegistertViaDSFEllerInfotrygdIEO(String registertViaDSFEllerInfotrygdIEO) {
        this.registertViaDSFEllerInfotrygdIEO = registertViaDSFEllerInfotrygdIEO;
    }

    public int getInntektIAFPPerioden() {
        return inntektIAFPPerioden;
    }

    public void setInntektIAFPPerioden(int inntektIAFPPerioden) {
        this.inntektIAFPPerioden = inntektIAFPPerioden;
    }

    public String getBeregnetEllerRegistrertViaInfotrygd() {
        return beregnetEllerRegistrertViaInfotrygd;
    }

    public void setBeregnetEllerRegistrertViaInfotrygd(String beregnetEllerRegistrertViaInfotrygd) {
        this.beregnetEllerRegistrertViaInfotrygd = beregnetEllerRegistrertViaInfotrygd;
    }

    public int getOppgittFramtidigInntekt() {
        return oppgittFramtidigInntekt;
    }

    public void setOppgittFramtidigInntekt(int oppgittFramtidigInntekt) {
        this.oppgittFramtidigInntekt = oppgittFramtidigInntekt;
    }

    public int getTidligereInntekt() {
        return tidligereInntekt;
    }

    public void setTidligereInntekt(int tidligereInntekt) {
        this.tidligereInntekt = tidligereInntekt;
    }

    public int getFullAFPiAvregningsperioden() {
        return fullAFPiAvregningsperioden;
    }

    public void setFullAFPiAvregningsperioden(int fullAFPiAvregningsperioden) {
        this.fullAFPiAvregningsperioden = fullAFPiAvregningsperioden;
    }

    public int getFaktiskUtbetalt() {
        return faktiskUtbetalt;
    }

    public void setFaktiskUtbetalt(int faktiskUtbetalt) {
        this.faktiskUtbetalt = faktiskUtbetalt;
    }

    public int getDifferanseForMyeUtbetalt() {
        return differanseForMyeUtbetalt;
    }

    public void setDifferanseForMyeUtbetalt(int differanseForMyeUtbetalt) {
        this.differanseForMyeUtbetalt = differanseForMyeUtbetalt;
    }

    public int getDifferanseForLiteUtbetalt() {
        return differanseForLiteUtbetalt;
    }

    public void setDifferanseForLiteUtbetalt(int differanseForLiteUtbetalt) {
        this.differanseForLiteUtbetalt = differanseForLiteUtbetalt;
    }

}
