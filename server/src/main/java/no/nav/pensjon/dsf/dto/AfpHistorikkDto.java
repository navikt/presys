package no.nav.pensjon.dsf.dto;

import java.math.BigDecimal;

public class AfpHistorikkDto {

    private int afpDato;
    private BigDecimal tidligereErvervsinntektFaktor;
    private int framtidigErvervsinntekt;
    private int utbetalingsgrad;
    private int fullAFP;
    private int redusertAFP;
    private String etReg;

    public int getAfpDato() {
        return afpDato;
    }

    public void setAfpDato(int afpDato) {
        this.afpDato = afpDato;
    }

    public BigDecimal getTidligereErvervsinntektFaktor() {
        return tidligereErvervsinntektFaktor;
    }

    public void setTidligereErvervsinntektFaktor(BigDecimal tidligereErvervsinntektFaktor) {
        this.tidligereErvervsinntektFaktor = tidligereErvervsinntektFaktor;
    }

    public int getFramtidigErvervsinntekt() {
        return framtidigErvervsinntekt;
    }

    public void setFramtidigErvervsinntekt(int framtidigErvervsinntekt) {
        this.framtidigErvervsinntekt = framtidigErvervsinntekt;
    }

    public int getUtbetalingsgrad() {
        return utbetalingsgrad;
    }

    public void setUtbetalingsgrad(int utbetalingsgrad) {
        this.utbetalingsgrad = utbetalingsgrad;
    }

    public int getFullAFP() {
        return fullAFP;
    }

    public void setFullAFP(int fullAFP) {
        this.fullAFP = fullAFP;
    }

    public int getRedusertAFP() {
        return redusertAFP;
    }

    public void setRedusertAFP(int redusertAFP) {
        this.redusertAFP = redusertAFP;
    }

    public String getEtReg() {
        return etReg;
    }

    public void setEtReg(String etReg) {
        this.etReg = etReg;
    }
}
