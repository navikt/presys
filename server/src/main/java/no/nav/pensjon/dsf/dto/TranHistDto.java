package no.nav.pensjon.dsf.dto;

import java.util.ArrayList;
import java.util.List;

public class TranHistDto {
    private int vtp_key;
    private String grunnblankettkode;
    private String prioritetskode;
    private int virkningsdato;
    private int registreringsdato;
    private int trygdekontornummer;
    private String sivilstand;
    private String spraak;
    private String transaksjonsreturkode;
    private String terminalId;
    private String autoTerminalId;
    private GrunnblankettDto grunnblankett;
    private List<BarnDto> barn = new ArrayList<>();

    public int getVtp_key() {
        return vtp_key;
    }

    public void setVtp_key(int vtp_key) {
        this.vtp_key = vtp_key;
    }

    public String getGrunnblankettkode() {
        return grunnblankettkode;
    }

    public void setGrunnblankettkode(String grunnblankettkode) {
        this.grunnblankettkode = grunnblankettkode;
    }

    public String getPrioritetskode() {
        return prioritetskode;
    }

    public void setPrioritetskode(String prioritetskode) {
        this.prioritetskode = prioritetskode;
    }

    public int getVirkningsdato() {
        return virkningsdato;
    }

    public void setVirkningsdato(int virkningsdato) {
        this.virkningsdato = virkningsdato;
    }

    public int getRegistreringsdato() {
        return registreringsdato;
    }

    public void setRegistreringsdato(int registreringsdato) {
        this.registreringsdato = registreringsdato;
    }

    public int getTrygdekontornummer() {
        return trygdekontornummer;
    }

    public void setTrygdekontornummer(int trygdekontornummer) {
        this.trygdekontornummer = trygdekontornummer;
    }

    public String getSivilstand() {
        return sivilstand;
    }

    public void setSivilstand(String sivilstand) {
        this.sivilstand = sivilstand;
    }

    public String getSpraak() {
        return spraak;
    }

    public void setSpraak(String spraak) {
        this.spraak = spraak;
    }

    public String getTransaksjonsreturkode() {
        return transaksjonsreturkode;
    }

    public void setTransaksjonsreturkode(String transaksjonsreturkode) {
        this.transaksjonsreturkode = transaksjonsreturkode;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAutoTerminalId() {
        return autoTerminalId;
    }

    public void setAutoTerminalId(String autoTerminalId) {
        this.autoTerminalId = autoTerminalId;
    }

    public GrunnblankettDto getGrunnblankett() {
        return grunnblankett;
    }

    public void setGrunnblankett(GrunnblankettDto grunnblankett) {
        this.grunnblankett = grunnblankett;
    }

    public List<BarnDto> getBarn() {
        return barn;
    }

    public void setBarn(List<BarnDto> barn) {
        this.barn = barn;
    }
}
