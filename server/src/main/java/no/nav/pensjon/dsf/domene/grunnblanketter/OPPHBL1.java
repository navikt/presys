package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "OPPHBL1 ", length = 42)
@UnmappedField(name = "filler", length = 2, start = 40)
public class OPPHBL1 {

    @Felt(name="dodsdato", length = 5, start = 0)
    @PackedDecimal
    private int dodsDato;

    @Felt(name="fnr_ek", length = 6, start = 5)
    @PackedDecimal
    private String ektefelleFodselsnummer;

    @Felt(name="navn_ek", length = 25, start = 11)
    private String ektefelleNavn;

    @Felt(name="pi", length = 4, start = 36)
    @PackedDecimal
    private int avdodesPensjonsgivendeInntekt;


    public int getDodsDato() {
        return dodsDato;
    }

    public void setDodsDato(int dodsDato) {
        this.dodsDato = dodsDato;
    }

    public String getEktefelleFodselsnummer() {
        return ektefelleFodselsnummer;
    }

    public void setEktefelleFodselsnummer(String ektefelleFodselsnummer) {
        this.ektefelleFodselsnummer = ektefelleFodselsnummer;
    }

    public String getEktefelleNavn() {
        return ektefelleNavn;
    }

    public void setEktefelleNavn(String ektefelleNavn) {
        this.ektefelleNavn = ektefelleNavn;
    }

    public int getAvdodesPensjonsgivendeInntekt() {
        return avdodesPensjonsgivendeInntekt;
    }

    public void setAvdodesPensjonsgivendeInntekt(int avdodesPensjonsgivendeInntekt) {
        this.avdodesPensjonsgivendeInntekt = avdodesPensjonsgivendeInntekt;
    }
}
