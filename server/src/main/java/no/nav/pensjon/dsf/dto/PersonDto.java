package no.nav.pensjon.dsf.dto;

/**
 * Created by s150563 on 13.06.2017.
 */
public class PersonDto {

    private String fnr;

    private String navn;

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
}
