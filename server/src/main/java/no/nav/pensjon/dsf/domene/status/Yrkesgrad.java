package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;

@Segment(name = "YRKEGRAD", length = 7)
public class Yrkesgrad {

    @Felt(name="YUG_DATO_AAMD", length = 5, start = 0) @PackedDecimal private int gjeldendeYrkesgradDato;
    @Felt(name="YUG_OVRIG", length = 2, start = 5) @PackedDecimal private int gjeldendeYrkesgradOvrig;

    public int getGjeldendeYrkesgradDato() {
        return gjeldendeYrkesgradDato;
    }

    public void setGjeldendeYrkesgradDato(int gjeldendeYrkesgradDato) {
        this.gjeldendeYrkesgradDato = gjeldendeYrkesgradDato;
    }

    public int getGjeldendeYrkesgradOvrig() {
        return gjeldendeYrkesgradOvrig;
    }

    public void setGjeldendeYrkesgradOvrig(int gjeldendeYrkesgradOvrig) {
        this.gjeldendeYrkesgradOvrig = gjeldendeYrkesgradOvrig;
    }
}
