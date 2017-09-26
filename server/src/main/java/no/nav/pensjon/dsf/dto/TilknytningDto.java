package no.nav.pensjon.dsf.dto;

public class TilknytningDto extends GrunnblankettDto {

    private String fnr;
    private String tilknytningskode;
    private String forsorgerTilleggFor1991;

    public String getFnr() {
        return fnr;
    }

    public void setFnr(String fnr) {
        this.fnr = fnr;
    }

    public String getTilknytningskode() {
        return tilknytningskode;
    }

    public void setTilknytningskode(String tilknytningskode) {
        this.tilknytningskode = tilknytningskode;
    }

    public String getForsorgerTilleggFor1991() {
        return forsorgerTilleggFor1991;
    }

    public void setForsorgerTilleggFor1991(String forsorgerTilleggFor1991) {
        this.forsorgerTilleggFor1991 = forsorgerTilleggFor1991;
    }
}
