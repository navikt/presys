package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

import java.math.BigDecimal;

@Segment(name = "EØSINFO", length = 130)
@UnmappedField(name="FILLER", length = 13, start = 117)
public class EosInfo {

    @Felt(name="BEREGN_FOLKETRYGD", length = 1, start = 0) private String beregnFolketrygd;
    @Felt(name="PRO_RATA_BEREGNING", length = 1, start = 1) private String proRataBeregning;
    @Felt(name="TT_PRO_RATA_MND", length = 2, start = 2) @PackedDecimal private int trygdetidProRataMaaneder;
    @Felt(name="TT_TEORETISK_EOS_MND", length = 2, start = 4) @PackedDecimal private int trygdetidTeoretiskEosMaaneder;
    @Felt(name="INNTEKTSAAR_EOS (1967:2014)", length = 6, start = 6) @BitTabell private boolean[] inntektsaarEos;
    @Felt(name="ALTERNATIV_GP", length = 4, start = 12) @PackedDecimal private int alternativGrunnpensjon;
    @Felt(name="ALTERNATIV_ST", length = 3, start = 16) @PackedDecimal private int alternativSaertillegg;
    @Felt(name="ALTERNATIV_TP", length = 4, start = 19) @PackedDecimal private int alternativTjenestepensjon;
    @Felt(name="ALTERNATIV_BT", length = 3, start = 23) @PackedDecimal private int alternativBarnetrygd;
    @Felt(name="ALTERNATIV_ET", length = 3, start = 26) @PackedDecimal private int alternativEktefelletillegg;
    @Felt(name="ANTALL_NORSKE_PAA", length = 2, start = 29) @PackedDecimal private int antallNorskePoengaar;
    @Felt(name="ANTALL_NORSKE_PAA_ETTER91", length = 2, start = 31) @PackedDecimal private int antallNorskePoengaarEtter1991;
    @Felt(name="SPT_EOS", length = 2, start = 33) @PackedDecimal(decimals = 2) private BigDecimal sluttpoengtallEos;
    @Felt(name="OPT_EOS", length = 2, start = 35) @PackedDecimal(decimals = 2) private BigDecimal overkompensasjonEos;
    @Felt(name="PENSJON_EOS", length = 4, start = 37) @PackedDecimal private int pensjonEos;
    @Felt(name="EOS_8_4_3A", length = 1, start = 41) private String eosPar8Pkt4Ledd3BokstavA;
    @Felt(name="ALTERNATIV_SUM_PENSJON", length = 4, start = 42) @PackedDecimal private int alternativSumPensjon;
    @Felt(name="NORDISK_KONVENSJON", length = 1, start = 46) private String nordiskKonvensjon;
    @Felt(name="GUNSTIGSTE_ALTERNATIV", length = 1, start = 47) private String gunstigsteAlternativ;
    @Felt(name="TT_EOS_FRAMT_MND", length = 2, start = 48) @PackedDecimal private int trygdetidEosFramtidigMaaneder;
    @Felt(name="TT_EOS_ANV_AAR", length = 2, start = 50) @PackedDecimal private int trygdetidEosAnvendtAAr;
    @Felt(name="TT_EOS_ANV_MND", length = 2, start = 52) @PackedDecimal private int trygdetidEosAnvendtMaaneder;
    @Felt(name="TT_NORDISK_FAKT_MND", length = 2, start = 54) @PackedDecimal private int trygdetidNordiskFaktiskMaaneder;
    @Felt(name="TT_NORDISK_FRAMT_BRUTTO", length = 2, start = 56) @PackedDecimal private int trygdetidNordiskFramtidigBrutto;
    @Felt(name="TT_NORDISK_FRAMT_NETTO", length = 2, start = 58) @PackedDecimal private int trygdetidNordiskFramtidigNetto;
    @Felt(name="PAA_EOS", length = 2, start = 60) @PackedDecimal private int pensjonsAarEos;
    @Felt(name="PAA_EOS_ETTER91", length = 2, start = 62) @PackedDecimal private int pensjonsAarEosEtter1991;
    @Felt(name="PAA_EOS_FRAMT", length = 2, start = 64) @PackedDecimal private int framtidigPensjonsAarEos;
    @Felt(name="PAA_NORDISK_FAKT", length = 2, start = 66) @PackedDecimal private int pensjonsAarNordiskFaktisk;
    @Felt(name="PAA_NORDISK_FRAMT_BRUTTO", length = 2, start = 68) @PackedDecimal private int pensjonsAarNordiskFramtidigBrutto;
    @Felt(name="PAA_NORDISK_FRAMT_NETTO", length = 2, start = 70) @PackedDecimal private int pensjonsAarNordiskFramtidigNetto;
    @Felt(name="SPT_NORDISK_ART15", length = 2, start = 72) @PackedDecimal(decimals = 2) private BigDecimal sluttpoengtallNordiskArtikkel15;
    @Felt(name="OPT_NORDISK_ART15", length = 2, start = 74) @PackedDecimal(decimals = 2) private BigDecimal overkompensasjonNordiskArtikkel15;
    @Felt(name="GP_ART13_VIRKDATO_AAMD", length = 5, start = 76) @PackedDecimal private int grunnpensjonArtikkel13Virkedato;
    @Felt(name="TP_ART15_VIRKDATO_AAMD", length = 5, start = 81) @PackedDecimal private int tjenestepensjonArtikkel13Virkedato;
    @Felt(name="ALTERNATIV_GP_BRUTTO", length = 4, start = 86) @PackedDecimal private int alternetivGrunnpensjonBrutto;
    @Felt(name="ALTERNATIV_TP_BRUTTO", length = 4, start = 90) @PackedDecimal private int alternetivTjenestepensjonBrutto;
    @Felt(name="EOS_AAR_IKKE_PRO_RATA(1967:2014)", length = 6, start = 94) @BitTabell private boolean[] eosAarIkkeProRata1967Til2014;
    @Felt(name="INNT_PROVET_EOS_PENS", length = 1, start = 100) private String inntektprovetEosPensjon;
    @Felt(name="BUP_GRAD_EOS", length = 2, start = 101) @PackedDecimal(decimals = 2) private BigDecimal beregnetUforePensjonsgradEos;
    @Felt(name="TT_FAKTISK_NORSK_MND", length = 2, start = 103) @PackedDecimal private int trygdetidFaktiskNorskMaaneder;
    @Felt(name="PAA_EOS_FAKTISK", length = 2, start = 105) @PackedDecimal private int pensjonsaarEosFaktisk;
    @Felt(name="ALTERNATIV_ST_BRUTTO", length = 4, start = 107) @PackedDecimal private int alternativtSaertilleggBrutto;
    @Felt(name="PRO_RATA2(1967:2014)", length = 6, start = 111) @BitTabell private boolean[] proRata21967Til2014;

    public String getBeregnFolketrygd() {
        return beregnFolketrygd;
    }

    public void setBeregnFolketrygd(String beregnFolketrygd) {
        this.beregnFolketrygd = beregnFolketrygd;
    }

    public String getProRataBeregning() {
        return proRataBeregning;
    }

    public void setProRataBeregning(String proRataBeregning) {
        this.proRataBeregning = proRataBeregning;
    }

    public int getTrygdetidProRataMaaneder() {
        return trygdetidProRataMaaneder;
    }

    public void setTrygdetidProRataMaaneder(int trygdetidProRataMaaneder) {
        this.trygdetidProRataMaaneder = trygdetidProRataMaaneder;
    }

    public int getTrygdetidTeoretiskEosMaaneder() {
        return trygdetidTeoretiskEosMaaneder;
    }

    public void setTrygdetidTeoretiskEosMaaneder(int trygdetidTeoretiskEosMaaneder) {
        this.trygdetidTeoretiskEosMaaneder = trygdetidTeoretiskEosMaaneder;
    }

    public boolean[] getInntektsaarEos() {
        return inntektsaarEos;
    }

    public void setInntektsaarEos(boolean[] inntektsaarEos) {
        this.inntektsaarEos = inntektsaarEos;
    }

    public int getAlternativGrunnpensjon() {
        return alternativGrunnpensjon;
    }

    public void setAlternativGrunnpensjon(int alternativGrunnpensjon) {
        this.alternativGrunnpensjon = alternativGrunnpensjon;
    }

    public int getAlternativSaertillegg() {
        return alternativSaertillegg;
    }

    public void setAlternativSaertillegg(int alternativSaertillegg) {
        this.alternativSaertillegg = alternativSaertillegg;
    }

    public int getAlternativTjenestepensjon() {
        return alternativTjenestepensjon;
    }

    public void setAlternativTjenestepensjon(int alternativTjenestepensjon) {
        this.alternativTjenestepensjon = alternativTjenestepensjon;
    }

    public int getAlternativBarnetrygd() {
        return alternativBarnetrygd;
    }

    public void setAlternativBarnetrygd(int alternativBarnetrygd) {
        this.alternativBarnetrygd = alternativBarnetrygd;
    }

    public int getAlternativEktefelletillegg() {
        return alternativEktefelletillegg;
    }

    public void setAlternativEktefelletillegg(int alternativEktefelletillegg) {
        this.alternativEktefelletillegg = alternativEktefelletillegg;
    }

    public int getAntallNorskePoengaar() {
        return antallNorskePoengaar;
    }

    public void setAntallNorskePoengaar(int antallNorskePoengaar) {
        this.antallNorskePoengaar = antallNorskePoengaar;
    }

    public int getAntallNorskePoengaarEtter1991() {
        return antallNorskePoengaarEtter1991;
    }

    public void setAntallNorskePoengaarEtter1991(int antallNorskePoengaarEtter1991) {
        this.antallNorskePoengaarEtter1991 = antallNorskePoengaarEtter1991;
    }

    public BigDecimal getSluttpoengtallEos() {
        return sluttpoengtallEos;
    }

    public void setSluttpoengtallEos(BigDecimal sluttpoengtallEos) {
        this.sluttpoengtallEos = sluttpoengtallEos;
    }

    public BigDecimal getOverkompensasjonEos() {
        return overkompensasjonEos;
    }

    public void setOverkompensasjonEos(BigDecimal overkompensasjonEos) {
        this.overkompensasjonEos = overkompensasjonEos;
    }

    public int getPensjonEos() {
        return pensjonEos;
    }

    public void setPensjonEos(int pensjonEos) {
        this.pensjonEos = pensjonEos;
    }

    public String getEosPar8Pkt4Ledd3BokstavA() {
        return eosPar8Pkt4Ledd3BokstavA;
    }

    public void setEosPar8Pkt4Ledd3BokstavA(String eosPar8Pkt4Ledd3BokstavA) {
        this.eosPar8Pkt4Ledd3BokstavA = eosPar8Pkt4Ledd3BokstavA;
    }

    public int getAlternativSumPensjon() {
        return alternativSumPensjon;
    }

    public void setAlternativSumPensjon(int alternativSumPensjon) {
        this.alternativSumPensjon = alternativSumPensjon;
    }

    public String getNordiskKonvensjon() {
        return nordiskKonvensjon;
    }

    public void setNordiskKonvensjon(String nordiskKonvensjon) {
        this.nordiskKonvensjon = nordiskKonvensjon;
    }

    public String getGunstigsteAlternativ() {
        return gunstigsteAlternativ;
    }

    public void setGunstigsteAlternativ(String gunstigsteAlternativ) {
        this.gunstigsteAlternativ = gunstigsteAlternativ;
    }

    public int getTrygdetidEosFramtidigMaaneder() {
        return trygdetidEosFramtidigMaaneder;
    }

    public void setTrygdetidEosFramtidigMaaneder(int trygdetidEosFramtidigMaaneder) {
        this.trygdetidEosFramtidigMaaneder = trygdetidEosFramtidigMaaneder;
    }

    public int getTrygdetidEosAnvendtMaaneder() {
        return trygdetidEosAnvendtMaaneder;
    }

    public void setTrygdetidEosAnvendtMaaneder(int trygdetidEosAnvendtMaaneder) {
        this.trygdetidEosAnvendtMaaneder = trygdetidEosAnvendtMaaneder;
    }

    public int getTrygdetidEosAnvendtAAr() {
        return trygdetidEosAnvendtAAr;
    }

    public void setTrygdetidEosAnvendtAAr(int trygdetidEosAnvendtAAr) {
        this.trygdetidEosAnvendtAAr = trygdetidEosAnvendtAAr;
    }

    public int getTrygdetidNordiskFaktiskMaaneder() {
        return trygdetidNordiskFaktiskMaaneder;
    }

    public void setTrygdetidNordiskFaktiskMaaneder(int trygdetidNordiskFaktiskMaaneder) {
        this.trygdetidNordiskFaktiskMaaneder = trygdetidNordiskFaktiskMaaneder;
    }

    public int getTrygdetidNordiskFramtidigBrutto() {
        return trygdetidNordiskFramtidigBrutto;
    }

    public void setTrygdetidNordiskFramtidigBrutto(int trygdetidNordiskFramtidigBrutto) {
        this.trygdetidNordiskFramtidigBrutto = trygdetidNordiskFramtidigBrutto;
    }

    public int getTrygdetidNordiskFramtidigNetto() {
        return trygdetidNordiskFramtidigNetto;
    }

    public void setTrygdetidNordiskFramtidigNetto(int trygdetidNordiskFramtidigNetto) {
        this.trygdetidNordiskFramtidigNetto = trygdetidNordiskFramtidigNetto;
    }

    public int getPensjonsAarEos() {
        return pensjonsAarEos;
    }

    public void setPensjonsAarEos(int pensjonsAarEos) {
        this.pensjonsAarEos = pensjonsAarEos;
    }

    public int getPensjonsAarEosEtter1991() {
        return pensjonsAarEosEtter1991;
    }

    public void setPensjonsAarEosEtter1991(int pensjonsAarEosEtter1991) {
        this.pensjonsAarEosEtter1991 = pensjonsAarEosEtter1991;
    }

    public int getFramtidigPensjonsAarEos() {
        return framtidigPensjonsAarEos;
    }

    public void setFramtidigPensjonsAarEos(int framtidigPensjonsAarEos) {
        this.framtidigPensjonsAarEos = framtidigPensjonsAarEos;
    }

    public int getPensjonsAarNordiskFaktisk() {
        return pensjonsAarNordiskFaktisk;
    }

    public void setPensjonsAarNordiskFaktisk(int pensjonsAarNordiskFaktisk) {
        this.pensjonsAarNordiskFaktisk = pensjonsAarNordiskFaktisk;
    }

    public int getPensjonsAarNordiskFramtidigBrutto() {
        return pensjonsAarNordiskFramtidigBrutto;
    }

    public void setPensjonsAarNordiskFramtidigBrutto(int pensjonsAarNordiskFramtidigBrutto) {
        this.pensjonsAarNordiskFramtidigBrutto = pensjonsAarNordiskFramtidigBrutto;
    }

    public int getPensjonsAarNordiskFramtidigNetto() {
        return pensjonsAarNordiskFramtidigNetto;
    }

    public void setPensjonsAarNordiskFramtidigNetto(int pensjonsAarNordiskFramtidigNetto) {
        this.pensjonsAarNordiskFramtidigNetto = pensjonsAarNordiskFramtidigNetto;
    }

    public BigDecimal getSluttpoengtallNordiskArtikkel15() {
        return sluttpoengtallNordiskArtikkel15;
    }

    public void setSluttpoengtallNordiskArtikkel15(BigDecimal sluttpoengtallNordiskArtikkel15) {
        this.sluttpoengtallNordiskArtikkel15 = sluttpoengtallNordiskArtikkel15;
    }

    public BigDecimal getOverkompensasjonNordiskArtikkel15() {
        return overkompensasjonNordiskArtikkel15;
    }

    public void setOverkompensasjonNordiskArtikkel15(BigDecimal overkompensasjonNordiskArtikkel15) {
        this.overkompensasjonNordiskArtikkel15 = overkompensasjonNordiskArtikkel15;
    }

    public int getGrunnpensjonArtikkel13Virkedato() {
        return grunnpensjonArtikkel13Virkedato;
    }

    public void setGrunnpensjonArtikkel13Virkedato(int grunnpensjonArtikkel13Virkedato) {
        this.grunnpensjonArtikkel13Virkedato = grunnpensjonArtikkel13Virkedato;
    }

    public int getTjenestepensjonArtikkel13Virkedato() {
        return tjenestepensjonArtikkel13Virkedato;
    }

    public void setTjenestepensjonArtikkel13Virkedato(int tjenestepensjonArtikkel13Virkedato) {
        this.tjenestepensjonArtikkel13Virkedato = tjenestepensjonArtikkel13Virkedato;
    }

    public int getAlternetivGrunnpensjonBrutto() {
        return alternetivGrunnpensjonBrutto;
    }

    public void setAlternetivGrunnpensjonBrutto(int alternetivGrunnpensjonBrutto) {
        this.alternetivGrunnpensjonBrutto = alternetivGrunnpensjonBrutto;
    }

    public int getAlternetivTjenestepensjonBrutto() {
        return alternetivTjenestepensjonBrutto;
    }

    public void setAlternetivTjenestepensjonBrutto(int alternetivTjenestepensjonBrutto) {
        this.alternetivTjenestepensjonBrutto = alternetivTjenestepensjonBrutto;
    }

    public boolean[] getEosAarIkkeProRata1967Til2014() {
        return eosAarIkkeProRata1967Til2014;
    }

    public void setEosAarIkkeProRata1967Til2014(boolean[] eosAarIkkeProRata1967Til2014) {
        this.eosAarIkkeProRata1967Til2014 = eosAarIkkeProRata1967Til2014;
    }

    public String getInntektprovetEosPensjon() {
        return inntektprovetEosPensjon;
    }

    public void setInntektprovetEosPensjon(String inntektprovetEosPensjon) {
        this.inntektprovetEosPensjon = inntektprovetEosPensjon;
    }

    public BigDecimal getBeregnetUforePensjonsgradEos() {
        return beregnetUforePensjonsgradEos;
    }

    public void setBeregnetUforePensjonsgradEos(BigDecimal beregnetUforePensjonsgradEos) {
        this.beregnetUforePensjonsgradEos = beregnetUforePensjonsgradEos;
    }

    public int getTrygdetidFaktiskNorskMaaneder() {
        return trygdetidFaktiskNorskMaaneder;
    }

    public void setTrygdetidFaktiskNorskMaaneder(int trygdetidFaktiskNorskMaaneder) {
        this.trygdetidFaktiskNorskMaaneder = trygdetidFaktiskNorskMaaneder;
    }

    public int getPensjonsaarEosFaktisk() {
        return pensjonsaarEosFaktisk;
    }

    public void setPensjonsaarEosFaktisk(int pensjonsaarEosFaktisk) {
        this.pensjonsaarEosFaktisk = pensjonsaarEosFaktisk;
    }

    public int getAlternativtSaertilleggBrutto() {
        return alternativtSaertilleggBrutto;
    }

    public void setAlternativtSaertilleggBrutto(int alternativtSaertilleggBrutto) {
        this.alternativtSaertilleggBrutto = alternativtSaertilleggBrutto;
    }

    public boolean[] getProRata21967Til2014() {
        return proRata21967Til2014;
    }

    public void setProRata21967Til2014(boolean[] proRata21967Til2014) {
        this.proRata21967Til2014 = proRata21967Til2014;
    }
}
