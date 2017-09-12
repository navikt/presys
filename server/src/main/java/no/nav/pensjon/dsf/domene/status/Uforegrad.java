package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@UnmappedField(name="FRIINNTEKT_FRA_GRAD_ÅMD", length = 5, start = 15)
@Segment(name = "UFØRGRAD", length = 20)

public class Uforegrad {

    @Felt(name="UFG_DATO_ÅMD", length = 5, start = 0)
    @PackedDecimal
    private int uforegradDato;

    @Felt(name="UFG_ØVRIGE", length = 2, start = 5)
    @PackedDecimal
    private int uforegradOvrige;

    @Felt(name="YNGSTE_BARN_FØR_GRAD", length = 3, start = 7)
    @PackedDecimal
    private int yngsteBarnFoerGrad;

    @Felt(name="VIRK_UFØRGRAD_ÅMD", length = 5, start = 10)
    @PackedDecimal
    private int virkningsdatoUforegrad;

    public int getUforegradDato() {
        return uforegradDato;
    }

    public void setUforegradDato(int uforegradDato) {
        this.uforegradDato = uforegradDato;
    }

    public int getUforegradOvrige() {
        return uforegradOvrige;
    }

    public void setUforegradOvrige(int uforegradOvrige) {
        this.uforegradOvrige = uforegradOvrige;
    }

    public int getYngsteBarnFoerGrad() {
        return yngsteBarnFoerGrad;
    }

    public void setYngsteBarnFoerGrad(int yngsteBarnFoerGrad) {
        this.yngsteBarnFoerGrad = yngsteBarnFoerGrad;
    }

    public int getVirkningsdatoUforegrad() {
        return virkningsdatoUforegrad;
    }

    public void setVirkningsdatoUforegrad(int virkningsdatoUforegrad) {
        this.virkningsdatoUforegrad = virkningsdatoUforegrad;
    }
}
