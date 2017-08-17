package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "OPPHBL2 ", length = 4)
@UnmappedField(name = "filler", length = 1, start = 3)
public class OPPHBL2 {

    @Felt(name="ektefelletillegg_stoppes", length = 1, start = 0)
    private String ektefelletillegg_stoppes;

    @Felt(name="opphr_kode", length = 2, start = 1)
    private String opphorskode;


    public String getEktefelletillegg_stoppes() {
        return ektefelletillegg_stoppes;
    }

    public void setEktefelletillegg_stoppes(String ektefelletillegg_stoppes) {
        this.ektefelletillegg_stoppes = ektefelletillegg_stoppes;
    }

    public String getOpphorskode() {
        return opphorskode;
    }

    public void setOpphorskode(String opphorskode) {
        this.opphorskode = opphorskode;
    }
}
