package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "BARN    ", length = 38)
@UnmappedField(name = "filler", length = 1, start = 37)
public class Barn {
    @Felt(name="fnr", length = 6, start = 0)
    @PackedDecimal
    private String fnr;

    @Felt(name="navn", length = 25, start = 6)
    private String navn;

    @Felt(name="tknr", length = 3, start = 31)
    @PackedDecimal
    private String tknr;

    @Felt(name="felles_barn", length = 1, start = 34)
    private String fellesBarn;

    @Felt(name="felles_før0591", length = 1, start = 35)
    private String fellesFor0591;

    @Felt(name="felles_etter0591", length = 1, start = 36)
    private String fellesEtter0591;

    public String getFnr() {
        return fnr;
    }

    public void setFnr(String fnr) {
        this.fnr = fnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTknr() {
        return tknr;
    }

    public void setTknr(String tknr) {
        this.tknr = tknr;
    }

    public String getFellesBarn() {
        return fellesBarn;
    }

    public void setFellesBarn(String fellesBarn) {
        this.fellesBarn = fellesBarn;
    }

    public String getFellesFor0591() {
        return fellesFor0591;
    }

    public void setFellesFor0591(String fellesFor0591) {
        this.fellesFor0591 = fellesFor0591;
    }

    public String getFellesEtter0591() {
        return fellesEtter0591;
    }

    public void setFellesEtter0591(String fellesEtter0591) {
        this.fellesEtter0591 = fellesEtter0591;
    }
}
