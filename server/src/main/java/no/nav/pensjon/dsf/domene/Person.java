package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.dsf.domene.grunnblanketter.TranHist;
import no.nav.pensjon.dsf.domene.status.Status;
import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Segment(name = "RF0PERSN", length = 58)
@UnmappedField(name = "tknr", length = 3, start = 31) //pakket
@UnmappedField(name = "spraak", length = 1, start = 34)
@UnmappedField(name = "sperre", length = 1, start = 38)
@UnmappedField(name = "SB_DATO_ÅMD", length = 5, start = 39) // SISTE STØNADSBREV DATO
@UnmappedField(name = "PI_66_65", length = 1, start = 44) //1 karakter i Rotsegment.  J = inntekt i 66. år skal sette lik inntekt i 65. år frem til P70.
@UnmappedField(name = "EØS_GARANTI", length = 1, start = 45) //Litt usikker på om dette er i bruk…, evnt kun en kode A,B,eller C
@UnmappedField(name = "BRUKER_ID", length = 8, start = 46) // BRUKERIDENT FOR DEN SOM SIST VAR INNE OG REGISTRERTE PÅ DENNE PERSONEN
@UnmappedField(name = "PERSN_KODE", length = 1, start = 54) //KODE FOR SKJERMET PERSONER (KODE 6/7/EGNE ANSATTE)
@UnmappedField(name = "filler", length = 3, start = 55)
public class Person {

    @Felt(name="fnr", length = 6, start = 0)
    @PackedDecimal
    private String fnr;

    @Felt(name="navn", length = 25, start = 6)
    private String navn;

    @Felt(name="ai67", length = 3, start = 35)
    @PackedDecimal
    private int ai67;  //ANTATT INNTEKT I 1967, IKKE DET SAMME SOM PGI DETTE ÅRET.

    @SubSegment
    private List<Inntekt> inntekter = new ArrayList<>();

    @SubSegment
    private List<EtteroppgjorAFP> etteroppgjor = new ArrayList<>();

    @SubSegment
    private List<Tilberpo> tilberpo = new ArrayList<>();

    @SubSegment
    private List<Status> status = new ArrayList<>();

    @SubSegment
    private List<TranHist> tranHister = new ArrayList<>();

    public List<EtteroppgjorAFP> getEtteroppgjor() {
        return etteroppgjor;
    }

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

    public int getAi67() {
        return ai67;
    }

    public void setAi67(int ai67) {
        this.ai67 = ai67;
    }

    public List<Tilberpo> getTilberpo() {
        return tilberpo;
    }

    public List<Status> getStatus() {
        return status;
    }

    public List<TranHist> getTranHister() {
        return tranHister;
    }
}
