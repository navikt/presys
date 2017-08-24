package no.nav.pensjon.dsf.dto;

public class BarnDto extends GrunnblankettDto {

    private String fnr;
    private String navn;
    private String fellesBarn;
    private String fellesFor0591;
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
