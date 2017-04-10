package no.nav.pensjon.dsf.web.resources;


public class Person {
    private String fnr;
    private String navn;
    private int alder;
    private Kjonn kjonn;
    private SivilStatus sivilStatus;

    public Person(String fnr, String navn, int alder, Kjonn kjonn, SivilStatus sivilStatus) {
        this.fnr = fnr;
        this.navn = navn;
        this.alder = alder;
        this.kjonn = kjonn;
        this.sivilStatus = sivilStatus;
    }

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

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public Kjonn getKjonn() {
        return kjonn;
    }

    public void setKjonn(Kjonn kjonn) {
        this.kjonn = kjonn;
    }

    public SivilStatus getSivilStatus() {
        return sivilStatus;
    }

    public void setSivilStatus(SivilStatus sivilStatus) {
        this.sivilStatus = sivilStatus;
    }

    public enum Kjonn{
        MANN, KVINNE
    }
    public enum SivilStatus{
        GIFT, ENSLIG, PARTNER, SAMBOER
    }
}
