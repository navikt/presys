package no.nav.pensjon.dsf.dto;

public class GradsendringInnenforYrkesskadeperiodenDto {

    private int endringsDato;
    private int grad;

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
