package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
@Segment(name = "GRUNNBUF" , length = 10)
public class GRUNNBUF {

    @Felt(name="UFT_AAMD", length = 8, start = 0) private String uforedato;
    @Felt(name="FIL", length = 2, start = 8) private String fil;

    public String getUforedato() {
        return uforedato;
    }

    public void setUforedato(String uforedato) {
        this.uforedato = uforedato;
    }

    public String getFil() {
        return fil;
    }

    public void setFil(String fil) {
        this.fil = fil;
    }
}
