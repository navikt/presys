package no.nav.pensjon.dsf.dto;

public class PersonDto {

    private String fnr;

    private String navn;

    private boolean availableForLookup;

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

    public boolean isAvailableForLookup() {
        return availableForLookup;
    }

    public void setAvailableForLookup(boolean availableForLookup) {
        this.availableForLookup = availableForLookup;
    }
}
