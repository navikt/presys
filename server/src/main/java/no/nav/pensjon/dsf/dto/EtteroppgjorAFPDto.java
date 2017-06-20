package no.nav.pensjon.dsf.dto;

public class EtteroppgjorAFPDto {

    private int inntektsAar;
    private int pensjonsgivendeInntekt;
    private int inntektForUttakAvAFP;
    private String registertViaDSFEllerInfotrygdIFU;
    private int inntektEtterOpphor;
    private String registertViaDSFEllerInfotrygdIEO;
    private int inntektIAFPPerioden;
    private String beregnetEllerRegistrertViaInfotrygd;
    private int oppgittFramtidigInntekt;
    private int tidligereInntekt;
    private int fullAFPiAvregningsperioden;
    private int faktiskUtbetalt;
    private int differanseForMyeUtbetalt;

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

    private int differanseForLiteUtbetalt;
}
