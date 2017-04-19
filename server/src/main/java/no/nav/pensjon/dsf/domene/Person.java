package no.nav.pensjon.dsf.domene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d132988 on 19.04.2017.
 */
public class Person {

    private String fnr;
    private String navn;
    private String tknr;
    private String sprak;
    private int ai67;
    private String sperre;
    private List<Inntekt> inntekter = new ArrayList<>();

    public List<Inntekt> getInntekter() {
        return inntekter;
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

    public String getTknr() {
        return tknr;
    }

    public void setTknr(String tknr) {
        this.tknr = tknr;
    }

    public String getSprak() {
        return sprak;
    }

    public void setSprak(String sprak) {
        this.sprak = sprak;
    }

    public int getAi67() {
        return ai67;
    }

    public void setAi67(int ai67) {
        this.ai67 = ai67;
    }

    public String getSperre() {
        return sperre;
    }

    public void setSperre(String sperre) {
        this.sperre = sperre;
    }
}
