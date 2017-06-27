package no.nav.pensjon.dsf.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UforeHistorikkDto {

    private int uftMaaned;
    private int ufg;
    private int ufKriterier;
    private BigDecimal bup;
    private String bupGarantiKode;
    private int opphørsdatoMaaned;
    private String opphørsKode;
    private int redusertAntallBupAar;
    private int foedselsaarYngsteBarn;
    private int virkningsdatoUfrHistorie;
    private List<UforegradDto> uforegrader = new ArrayList<>();

    public List<UforegradDto> getUforegrader() {
        return uforegrader;
    }

    public void setUforegrader(List<UforegradDto> uforegrader) {
        this.uforegrader = uforegrader;
    }

    public int getUftMaaned() {
        return uftMaaned;
    }

    public void setUftMaaned(int uftMaaned) {
        this.uftMaaned = uftMaaned;
    }

    public int getUfg() {
        return ufg;
    }

    public void setUfg(int ufg) {
        this.ufg = ufg;
    }

    public int getUfKriterier() {
        return ufKriterier;
    }

    public void setUfKriterier(int ufKriterier) {
        this.ufKriterier = ufKriterier;
    }

    public BigDecimal getBup() {
        return bup;
    }

    public void setBup(BigDecimal bup) {
        this.bup = bup;
    }

    public String getBupGarantiKode() {
        return bupGarantiKode;
    }

    public void setBupGarantiKode(String bupGarantiKode) {
        this.bupGarantiKode = bupGarantiKode;
    }

    public int getOpphørsdatoMaaned() {
        return opphørsdatoMaaned;
    }

    public void setOpphørsdatoMaaned(int opphørsdatoMaaned) {
        this.opphørsdatoMaaned = opphørsdatoMaaned;
    }

    public String getOpphørsKode() {
        return opphørsKode;
    }

    public void setOpphørsKode(String opphørsKode) {
        this.opphørsKode = opphørsKode;
    }

    public int getRedusertAntallBupAar() {
        return redusertAntallBupAar;
    }

    public void setRedusertAntallBupAar(int redusertAntallBupAar) {
        this.redusertAntallBupAar = redusertAntallBupAar;
    }

    public int getFoedselsaarYngsteBarn() {
        return foedselsaarYngsteBarn;
    }

    public void setFoedselsaarYngsteBarn(int foedselsaarYngsteBarn) {
        this.foedselsaarYngsteBarn = foedselsaarYngsteBarn;
    }

    public int getVirkningsdatoUfrHistorie() {
        return virkningsdatoUfrHistorie;
    }

    public void setVirkningsdatoUfrHistorie(int virkningsdatoUfrHistorie) {
        this.virkningsdatoUfrHistorie = virkningsdatoUfrHistorie;
    }
}
