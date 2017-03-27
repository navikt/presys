package no.nav.pensjon.dsf.web.resources;


public class Person {
    private String fnr;
    private String navn;
    private int alder;
    private Kjonn kjonn;

    public Person(String fnr, String navn, int alder, Kjonn kjonn) {
        this.fnr = fnr;
        this.navn = navn;
        this.alder = alder;
        this.kjonn = kjonn;
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

    public static enum Kjonn{
        MANN, KVINNE
    }
}
