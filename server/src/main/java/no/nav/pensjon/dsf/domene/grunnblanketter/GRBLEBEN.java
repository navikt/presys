package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRBLEBEN", length = 40)
@UnmappedField(name = "filler", length = 2, start = 38)
public class GRBLEBEN {

    @Felt(name="FNR_DOD", length = 6, start = 0) @PackedDecimal private String fodselsnummerAvdod;
    @Felt(name="NAVN", length = 25, start = 6) private String navnYngsteBarn;
    @Felt(name="DODSDATO_AAMD", length = 5, start = 31) @PackedDecimal private int dodsdato;
    @Felt(name="DOD_AV_YRKESSKADE", length = 1, start = 36) private String dodAvYrkesskade;
    @Felt(name="PLEIEBARN", length = 1, start = 37) private String pleiebarn;


    public String getFodselsnummerAvdod() {
        return fodselsnummerAvdod;
    }

    public void setFodselsnummerAvdod(String fodselsnummerAvdod) {
        this.fodselsnummerAvdod = fodselsnummerAvdod;
    }

    public String getNavnYngsteBarn() {
        return navnYngsteBarn;
    }

    public void setNavnYngsteBarn(String navnYngsteBarn) {
        this.navnYngsteBarn = navnYngsteBarn;
    }

    public int getDodsdato() {
        return dodsdato;
    }

    public void setDodsdato(int dodsdato) {
        this.dodsdato = dodsdato;
    }

    public String getDodAvYrkesskade() {
        return dodAvYrkesskade;
    }

    public void setDodAvYrkesskade(String dodAvYrkesskade) {
        this.dodAvYrkesskade = dodAvYrkesskade;
    }

    public String getPleiebarn() {
        return pleiebarn;
    }

    public void setPleiebarn(String pleiebarn) {
        this.pleiebarn = pleiebarn;
    }
}
