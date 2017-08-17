package no.nav.pensjon.dsf.dto;

public class Opphorsblankett2Dto extends GrunnblankettDto {

    private String ektefelletillegg_stoppes;
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
