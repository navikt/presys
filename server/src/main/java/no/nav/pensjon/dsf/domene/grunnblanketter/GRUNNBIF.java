package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;

@Segment(name = "GRUNNBIF", length = 50)
public class GRUNNBIF {

    @Felt(name = "EKTEFELLE_TILL", length = 1, start = 0)
    private String ektefelletillegg;

    @Felt(name = "ARBEIDSINNTEKT", length = 4, start = 1)
    @PackedDecimal
    private int arbeidsinntekt;

    @Felt(name = "PENSJONSINNTEKT", length = 4, start = 5)
    @PackedDecimal
    private int pensjonsinntekt;

    @Felt(name = "ARBEIDSINNTEKT_EK", length = 4, start = 9)
    @PackedDecimal
    private int arbeidsinntektEktefelle;

    @Felt(name = "PENSJONSINNTEKT_EK", length = 4, start = 13)
    @PackedDecimal
    private int pensjonsinntektEktefelle;

    @Felt(name = "BT_ANT", length = 2, start = 17)
    @PackedDecimal
    private int antallBarnetillegg;

    @Felt(name = "FNR_EK", length = 6, start = 19)
    @PackedDecimal
    private String fnrEktefelle;

    @Felt(name = "NAVN_EK", length = 25, start = 25)
    private String navnEktefelle;

    public String getEktefelletillegg() {
        return ektefelletillegg;
    }

    public void setEktefelletillegg(String ektefelletillegg) {
        this.ektefelletillegg = ektefelletillegg;
    }

    public int getArbeidsinntekt() {
        return arbeidsinntekt;
    }

    public void setArbeidsinntekt(int arbeidsinntekt) {
        this.arbeidsinntekt = arbeidsinntekt;
    }

    public int getPensjonsinntekt() {
        return pensjonsinntekt;
    }

    public void setPensjonsinntekt(int pensjonsinntekt) {
        this.pensjonsinntekt = pensjonsinntekt;
    }

    public int getArbeidsinntektEktefelle() {
        return arbeidsinntektEktefelle;
    }

    public void setArbeidsinntektEktefelle(int arbeidsinntektEktefelle) {
        this.arbeidsinntektEktefelle = arbeidsinntektEktefelle;
    }

    public int getPensjonsinntektEktefelle() {
        return pensjonsinntektEktefelle;
    }

    public void setPensjonsinntektEktefelle(int pensjonsinntektEktefelle) {
        this.pensjonsinntektEktefelle = pensjonsinntektEktefelle;
    }

    public int getAntallBarnetillegg() {
        return antallBarnetillegg;
    }

    public void setAntallBarnetillegg(int antallBarnetillegg) {
        this.antallBarnetillegg = antallBarnetillegg;
    }

    public String getFnrEktefelle() {
        return fnrEktefelle;
    }

    public void setFnrEktefelle(String fnrEktefelle) {
        this.fnrEktefelle = fnrEktefelle;
    }

    public String getNavnEktefelle() {
        return navnEktefelle;
    }

    public void setNavnEktefelle(String navnEktefelle) {
        this.navnEktefelle = navnEktefelle;
    }
}