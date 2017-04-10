package no.nav.pensjon.dsf.web.resources.saksbehandler;

/**
 * Created by d132988 on 10.04.2017.
 */
public class Credentials {

    private String brukernavn;
    private String passord;

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}
