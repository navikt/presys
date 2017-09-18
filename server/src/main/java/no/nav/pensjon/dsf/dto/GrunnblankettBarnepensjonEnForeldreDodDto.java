package no.nav.pensjon.dsf.dto;

public class GrunnblankettBarnepensjonEnForeldreDodDto extends GrunnblankettDto {

    private String fodselsnummerAvdod;
    private String navnYngsteBarn;
    private int dodsdato;
    private String dodAvYrkesskade;
    private String pleiebarn;

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
