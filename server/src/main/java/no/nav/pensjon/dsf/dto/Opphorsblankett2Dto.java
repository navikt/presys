package no.nav.pensjon.dsf.dto;

public class Opphorsblankett2Dto extends GrunnblankettDto {

    private String ektefelletilleggStoppes;
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
