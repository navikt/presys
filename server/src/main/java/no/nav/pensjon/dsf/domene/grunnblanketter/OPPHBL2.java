package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "OPPHBL2 ", length = 4)
@UnmappedField(name = "filler", length = 1, start = 3)
public class OPPHBL2 {

    @Felt(name="ektefelletilleggStoppes", length = 1, start = 0)
    private String ektefelletilleggStoppes;

    @Felt(name="opphrKode", length = 2, start = 1)
    private String opphorskode;


    public String getEktefelletilleggStoppes() {
        return ektefelletilleggStoppes;
    }

    public void setEktefelletilleggStoppes(String ektefelletilleggStoppes) {
        this.ektefelletilleggStoppes = ektefelletilleggStoppes;
    }

    public String getOpphorskode() {
        return opphorskode;
    }

    public void setOpphorskode(String opphorskode) {
        this.opphorskode = opphorskode;
    }
}
