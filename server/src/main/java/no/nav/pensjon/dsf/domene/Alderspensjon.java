package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Samme segment for AFP og Alderspensjon
 */
@Segment(name = "ALDERSP ", length = 142)
@UnmappedField(name = "bt", length = 3, start = 6)
@UnmappedField(name = "kt", length = 3, start = 9)
@UnmappedField(name = "et", length = 3, start = 12)
@UnmappedField(name = "apd", length = 2, start = 24) // Er den del av alderspenjon som tas ut, trinn 1007,5,50,25. Gammel regel som ikke er i bruk lenger, alle som hadde denne regel har fylt 70 år og da får de 100%.
@UnmappedField(name = "fai", length = 3, start = 26) // Framtidig arbeidinntekt, gamler regler, tidligere skulle aldespensjon redueres på grunn av framtidig arbeids inntekt. Det er ingen alderspensjonister nå som blir truffet av denne regelen.
@UnmappedField(name = "faiDatoAMD", length = 5, start = 29) // Dato for framtidig arbeidsinntekt
@UnmappedField(name = "p67Kode", length = 1, start = 34) // Ikke aktuelt for noen alderspensjonister i dag. Slik var regelen:PRØVEKODE SOM ANGIR OM PENSJONSGRADEN ER FASTSATT SOM MAXIMUM. |  BLANK: GJELDER BL.A. PERSONER SOM ER 70 ÅR VED OVERGANGEN |          TIL DET NYE SYSTEM. |          1 : GRADEN ER FASTSATT VED PRØVING ETTER 7.10 (MAX) |          2 : GRADEN ER FASTSATT VED KONVERTERING (U/E) |          3 : GRADEN ER FASTSATT ETTER PENSJONISTENS ØNSKE |          4 : GRADEN ER FASTSATT FOR INNTEKT UNDER 2G |          5 : NULLPENSJON , TILDLIGERE FORSØRGET EK, ELLER |          UFG < 100 OG DATO > 199200
@UnmappedField(name = "konvPKode", length = 1, start = 35) // KONVERTERINGS PENSJONSKODE |  FORTELLER HVILKEN PENSJONSART PERSONEN HADDE FØR han ble 67 år, |          ER LIK PENSJONSTYPE1 FØR KONVERTERING. |          Unntak: Offentlig AFP får kode 'O' - dersom uttaket skjedde |          før det året vedkommende fylte 65 år, ved uttak |          i det år vedkommende fylte 65 år legges blank
@UnmappedField(name = "konvGrad", length = 2, start = 36) // Ikke aktuell for alderspensjonister i dag. Men slik var regelen: KONVERTERINGSGRAD. Alderspensjonsdel (25,50,75 eller 100) SOM PERSONEN HAR RETT TIL VED OVERGANG FRA UFØRE-/ETTERLATTEPENSJON.
@UnmappedField(name = "uttaksdatoAMD", length = 5, start = 38) // Uttaksdato for alderspensjon
@UnmappedField(name = "uttaksAPD", length = 2, start = 43) // Uttaks grad
@UnmappedField(name = "ttVent", length = 2, start = 45) // DEN TRYGDETID SOM ER GRUNNLAGET FOR BEREGNING AV VENTETILLEGG (PENSJONISTENS TRYGDETID FREM TIL OG MED DEN MÅNED HAN FYLLER 67 ÅR, ELLER EKTEFELLENS TOTALE TRYGDETID)
@UnmappedField(name = "ventefaktor", length = 3, start = 47) // ANGIR ET PROSENTTALL FOR TILLEGG I PENSJON PÅ GRUNN AV AT PERSONEN HAR VENTET MED Å TA UT PENSJON.   3 SIFFER.
@UnmappedField(name = "vtSpt", length = 2, start = 50) // SLUTTPOENGTALL PR 67 ÅRS-DATO
@UnmappedField(name = "vtOpt", length = 2, start = 52) // OVERKOMPENSASJONS-POENGTALL PR 67 ÅRS-DATO
@UnmappedField(name = "vtPaa", length = 2, start = 54) // ANTALL POENGÅR PR 67 ÅRS-DATO
@UnmappedField(name = "gpP67", length = 3, start = 56) // Grunnpensjon ved 67 år
@UnmappedField(name = "tpP67", length = 3, start = 59) // Tilleggspensjon ved 67 år
@UnmappedField(name = "vtGp", length = 3, start = 62) // VENTETILLEGGET TIL GRUNNPENSJONEN I KRONER PR MND
@UnmappedField(name = "vtTp", length = 3, start = 65) // VENTETILLEGGET TIL TILLEGGSPENSJON I KRONER PR MND. 5 SIFFER. TILLEGGET REGNES AV SUMMEN AV TP_P67 OG TP_AVD.
@UnmappedField(name = "spt1291", length = 2, start = 68) // Sluttpoengtall før lovendring i 1992.
@UnmappedField(name = "opt1291", length = 2, start = 70) // Overkompensasjonstall før lovendring 1992
@UnmappedField(name = "paa1291", length = 2, start = 72) // Poengår før  lovendring 1992
@UnmappedField(name = "paaEtter91", length = 2, start = 74) // Poengår etter 1991
@UnmappedField(name = "apTpNetto", length = 3, start = 76) // Tilleggspensjon for alderspensjonist - etter evt. fradrag for forventet inntekt.
@UnmappedField(name = "apGpNetto", length = 3, start = 79) // Grunnpensjon for alderspensjonist - etter evt. fradrag for forventet inntekt.
@UnmappedField(name = "afpTillegg", length = 3, start = 82) // Dette er et tillegg som blir gitt til AFP pensjonister.
@UnmappedField(name = "afpBup", length = 2, start = 85) // Fremtidig poengtall for AFP pensjonister
@UnmappedField(name = "afpTilleggNetto", length = 3, start = 87) // AFP tillegg redusert for fremtidig inntekt
@UnmappedField(name = "apStNetto", length = 3, start = 90) // Særtillegg for alderspensjonist - etter evt. fradrag for forventet inntekt.
@UnmappedField(name = "apEtNetto", length = 3, start = 93) // Ektefelletillegg netto for alderspensjonist - etter evt. fradrag for forventet inntekt.
@UnmappedField(name = "apTeiFaktor", length = 3, start = 96) // Forholdstall som angir inntekt før uttak av alderspensjon
@UnmappedField(name = "beregnAltAey", length = 1, start = 99) // Kode som sette i beregning for å kunne gi riktig informasjon på pensjonsbrevet. Kodene er A,B,E,F,N,Y,P,R,W.
@UnmappedField(name = "filler", length = 7, start = 100)
@UnmappedField(name = "unmapped field", length = 35, start = 107) // Vet ikke hva det er. (Stemmer kanskje overens med ventøvr * 5)
public class Alderspensjon {

    /**
     * Grunnpensjon
     */
    @Felt(name = "grunnpensjon", start = 0, length = 3)
    @PackedDecimal
    private String grunnpensjon;

    /**
     * Særtillegg
     */
    @Felt(name = "saertillegg", start = 3, length = 3)
    @PackedDecimal
    private String saertillegg;

    /**
     * Tilleggspensjon
     */
    @Felt(name = "tilleggspensjon", start = 15, length = 3)
    @PackedDecimal
    private String tilleggspensjon;

    /**
     * Sluttpoengtall
     */
    @Felt(name = "sluttpoengtall", start = 18, length = 2)
    @PackedDecimal(decimals = 2)
    private String sluttpoengtall;

    /**
     * Overkompensasjon poengtall
     */
    @Felt(name = "overkompensasjonPoengtall", start = 20, length = 2)
    @PackedDecimal(decimals = 2)
    private String overkompensasjonPoengtall;

    /**
     * Antall Poengår
     */
    @Felt(name = "poengaar", start = 22, length = 2)
    @PackedDecimal
    private String poengaar;

    @SubSegment
    private List<Venteperioder> venteperioder = new ArrayList<>();

    public String getGrunnpensjon() { return grunnpensjon; }

    public void setGrunnpensjon(String grunnpensjon) { this.grunnpensjon = grunnpensjon; }

    public String getSaertillegg() { return saertillegg; }

    public void setSaertillegg(String saertillegg) { this.saertillegg = saertillegg; }

    public String getTilleggspensjon() { return tilleggspensjon; }

    public void setTilleggspensjon(String tilleggspensjon) { this.tilleggspensjon = tilleggspensjon; }

    public String getSluttpoengtall() { return sluttpoengtall; }

    public void setSluttpoengtall(String sluttpoengtall) { this.sluttpoengtall = sluttpoengtall; }

    public String getOverkompensasjonPoengtall() { return overkompensasjonPoengtall; }

    public void setOverkompensasjonPoengtall(String overkompensasjonPoengtall) { this.overkompensasjonPoengtall = overkompensasjonPoengtall; }

    public String getPoengaar() { return poengaar; }

    public void setPoengaar(String poengaar) { this.poengaar = poengaar; }

    public List<Venteperioder> getVenteperioder() { return venteperioder; }
}
