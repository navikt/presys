package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.dsf.domene.Uforegrad;
import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@UnmappedField(name = "bup_garanti", length = 2, start = 10) //Pakket desimal med 2 desimaler
@UnmappedField(name = "friinntekt_fra_hist_ÅMD", length = 5, start = 29)
@UnmappedField(name = "filler", length = 4, start = 34)
@Segment(name = "UFØRHIST", length = 38)
public class UforeHistorikk {

    @Felt(name="uft_md", length = 5, start = 0)
    @PackedDecimal
    private int uftMaaned;

    @Felt(name="ufg", length = 2, start = 5)
    @PackedDecimal
    private int ufg;

    @Felt(name="ufkriterier", length = 1, start = 7)
    @PackedDecimal
    private int ufKriterier;

    @Felt(name="bup", length = 2, start = 8)
    @PackedDecimal(decimals = 2)
    private BigDecimal bup;

    @Felt(name="bup_gar_kode", length = 1, start = 12)
    private String bupGarantiKode;

    @Felt(name="opphørsdato_md", length = 5, start = 13)
    @PackedDecimal
    private int opphorsdatoMaaned;

    @Felt(name="opphørs_kode", length = 1, start = 18)
    private String opphorsKode;

    @Felt(name="redusert_ant_bup_r", length = 2, start = 19)
    @PackedDecimal
    private int redusertAntallBupAar;

    @Felt(name="yngste_barn_fr_hist", length = 3, start = 21)
    @PackedDecimal
    private int foedselsaarYngsteBarn;

    @Felt(name="virk_uførhist_åmd", length = 5, start = 24)
    @PackedDecimal
    private int virkningsdatoUfrHistorie;

    @SubSegment
    private List<Uforegrad> uforegrader = new ArrayList<>();

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

    public int getOpphorsdatoMaaned() {
        return opphorsdatoMaaned;
    }

    public void setOpphorsdatoMaaned(int opphorsdatoMaaned) {
        this.opphorsdatoMaaned = opphorsdatoMaaned;
    }

    public String getOpphorsKode() {
        return opphorsKode;
    }

    public void setOpphorsKode(String opphorsKode) {
        this.opphorsKode = opphorsKode;
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

    public void setUforegrader(List<Uforegrad> uforegrader) {
        this.uforegrader = uforegrader;
    }

    public List<Uforegrad> getUforegrader() {
        return uforegrader;
    }
}
