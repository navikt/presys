package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.SubSegment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d132988 on 19.04.2017.
 */

@Segment(name = "RF0PERSN", length = 58)
public class Person {
    /*
    * Umappede felter:
    * start, lengde, navn: beskrivelse
    * 31, 3, tknr: packed heltall
    * 34, 1, spraak: tekst
    * 38, 1, sperre: tekst
    * 39, 5,SB_DATO_ÅMD : packed decimal, SISTE STØNADSBREV DATO
    * 44, 1, PI_66_65 : tekst, 1 karakter i Rotsegment.  J = inntekt i 66. år skal sette lik inntekt i 65. år frem til P70.
    * 45, 1, EØS_GARANTI: Litt usikker på om dette er i bruk…, evnt kun en kode A,B,eller C
    * 46, 8, BRUKER_ID: BRUKERIDENT FOR DEN SOM SIST VAR INNE OG REGISTRERTE PÅ DENNE PERSONEN
    * 54, 1, PERSN_KODE: KODE FOR SKJERMET PERSONER (KODE 6/7/EGNE ANSATTE)
    * 55, 3, filler
    * */
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
}
