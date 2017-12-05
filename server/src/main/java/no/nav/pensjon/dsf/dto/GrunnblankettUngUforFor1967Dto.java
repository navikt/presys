package no.nav.pensjon.dsf.dto;

public class GrunnblankettUngUforFor1967Dto extends GrunnblankettDto {

    private int uforedato;
    private String fil;

    public int getUforedato() {
        return uforedato;
    }

    public void setUforedato(String uforedato) {
        this.uforedato = Integer.parseInt(uforedato);
    }

    public String getFil() {
        return fil;
    }

    public void setFil(String fil) {
        this.fil = fil;
    }
}
