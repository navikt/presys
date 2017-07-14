package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;

/**
 * Tilknytninger til personer
 * FAMILIEPERSONER : EKTEFELLE, BARN, FORELDRE, SØSKEN
 * (AVDØDE/GJENLEVENDE)
 */
@Segment(name = "TILKN   ", length = 8)
public class Tilknytning {

    /**
     * Fødselsnummer til tilknyttede personer, eks  ekefelle, samboer , barn
     */
    @Felt(name = "fnr", start = 0, length = 6)
    @PackedDecimal
    private String fnr;

    /**
     * 1 KARAKTER SOM ANGIR RELASJONEN MELLOM 2 PERSONER.
     * KODEN FINNES I TILKNYTNINGSSEGMENT SAMMEN MED ET FNR OG
     * ANGIR PENSJONSSTATUS FOR VEDKOMMENDE :
     * A : ALDERSPENSJON
     * B : YNGSTE BARN I ET BARNEKULL (foreldreløse barn)
     * D : DØD PERSON
     * E : ETTERLATT EKTEFELLE  (ogsÅ nÅr pt1 er A/U)
     * F : FORSØRGET EKTEFELLE
     * G : EKTEFELLE/samboer mv uten ytelse
     * K : AFP
     * L : FORSØRGET BARN
     * N : YNGSTE BARN I ET BARNEKULL (en av foreldrene er død)
     * U : UFØREPENSJON
     * V : FORSØRGET BARN  - SÆRKULLSBARN FOM. 1.5.91 (avløser L)
     * W : FORSØRGET BARN  -   FELLESBARN FOM. 1.5.91    "     "
     * Y : YRKESSKADEPENSJON
     */
    @Felt(name = "tilknytningskode", start = 6, length = 1)
    private String tilknytningskode;

    /**
     * 1 karakter. Gjelder forsørgede før lovendring 1.5.91
     * F = ektefelletillegg
     * L = barnetillegg
     * R = redusert barnetillegg
     * Blank betyr at personen ikke var forsørget før 1.5.91
     */
    @Felt(name = "ft_fr_91", start = 7, length = 1)
    private String ft_fr_91;

    public String getFnr() { return fnr; }

    public void setFnr(String fnr) { this.fnr = fnr; }

    public String getFt_fr_91() { return ft_fr_91; }

    public void setFt_fr_91(String ft_fr_91) { this.ft_fr_91 = ft_fr_91; }

    public String getTilknytningskode() { return tilknytningskode; }

    public void setTilknytningskode(String tilknytningskode) { this.tilknytningskode = tilknytningskode; }
}
