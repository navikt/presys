package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;

import java.math.BigDecimal;

@Segment(name = "AFPHIST ", length = 20)
public class AfpHistorikk {

    @Felt(name="AFPDATO_AAMD", length = 5, start = 0) @PackedDecimal private int afpDato;
    @Felt(name="TEI_FAKTOR", length = 3, start = 5) @PackedDecimal(decimals = 2) private BigDecimal tidligereErvervsinntektFaktor;
    @Felt(name="FEI_I_100KR", length = 3, start = 8) @PackedDecimal private int framtidigErvervsinntekt;
    @Felt(name="GRAD_UTBET", length = 2, start = 11) @PackedDecimal private int utbetalingsgrad;
    @Felt(name="FULL_AFP", length = 3, start = 13) @PackedDecimal private int fullAFP;
    @Felt(name="RED_AFP", length = 3, start = 16) @PackedDecimal private int redusertAFP;
    @Felt(name="ET_REG", length = 1, start = 19) private String etReg;

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
