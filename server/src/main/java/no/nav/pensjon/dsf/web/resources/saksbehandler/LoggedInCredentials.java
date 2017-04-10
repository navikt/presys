package no.nav.pensjon.dsf.web.resources.saksbehandler;

/**
 * Created by d132988 on 10.04.2017.
 */
public class LoggedInCredentials {

    private String navn;
    private String jwt;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
