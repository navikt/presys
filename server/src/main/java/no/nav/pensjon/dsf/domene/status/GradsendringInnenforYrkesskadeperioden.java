package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;

@Segment(name = "YRKEGRAD", length = 38)
public class GradsendringInnenforYrkesskadeperioden {

    @Felt(name="YUG_DATO_AAMD", length = 5, start = 0) @PackedDecimal private int endringsDato;
    @Felt(name="YUG_OVRIGE", length = 5, start = 0) @PackedDecimal private int grad;

    public int getEndringsDato() {
        return endringsDato;
    }

    public void setEndringsDato(int endringsDato) {
        this.endringsDato = endringsDato;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }
}
