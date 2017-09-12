package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@UnmappedField(name="PAA_ETTER91", length = 2, start = 28)
@UnmappedField(name="YRKE_POENG_1291", length = 2, start = 30)
@UnmappedField(name="FILLER", length = 6, start = 32)
@Segment(name = "YRKEPENS", length = 38)
public class Yrkesskadepensjon {

    @Felt(name="YUG", length = 2, start = 0) @PackedDecimal private int gjeldendeYrkesgrad;
    @Felt(name="GP", length = 3, start = 2) @PackedDecimal private int grunnpensjon;
    @Felt(name="ST", length = 3, start = 5) @PackedDecimal private int saertillegg;
    @Felt(name="ET", length = 3, start = 8) @PackedDecimal private int ektefelletillegg;
    @Felt(name="BT", length = 3, start = 11) @PackedDecimal private int barnetillegg;
    @Felt(name="GARANTI_YRKEGRAD", length = 3, start = 14) @PackedDecimal private int garantiYrkegrad;
    @Felt(name="TP", length = 3, start = 17) @PackedDecimal private int tilleggspensjon;
    @Felt(name="YPT", length = 2, start = 20) @PackedDecimal(decimals = 2) private String yrkeskadepoengtall;
    @Felt(name="SPT", length = 2, start = 22) @PackedDecimal(decimals = 2) private String sluttpoengtall;
    @Felt(name="PAA", length = 2, start = 24) @PackedDecimal private int antallPoengaar;
    @Felt(name="YPT_KODE", length = 1, start = 26) private String poengberegningsalternativ;
    @Felt(name="YSYKDOM", length = 1, start = 27) private String yrkessykdom;

    public int getGjeldendeYrkesgrad() {
        return gjeldendeYrkesgrad;
    }

    public void setGjeldendeYrkesgrad(int gjeldendeYrkesgrad) {
        this.gjeldendeYrkesgrad = gjeldendeYrkesgrad;
    }

    public int getGrunnpensjon() {
        return grunnpensjon;
    }

    public void setGrunnpensjon(int grunnpensjon) {
        this.grunnpensjon = grunnpensjon;
    }

    public int getSaertillegg() {
        return saertillegg;
    }

    public void setSaertillegg(int saertillegg) {
        this.saertillegg = saertillegg;
    }

    public int getEktefelletillegg() {
        return ektefelletillegg;
    }

    public void setEktefelletillegg(int ektefelletillegg) {
        this.ektefelletillegg = ektefelletillegg;
    }

    public int getBarnetillegg() {
        return barnetillegg;
    }

    public void setBarnetillegg(int barnetillegg) {
        this.barnetillegg = barnetillegg;
    }

    public int getGarantiYrkegrad() {
        return garantiYrkegrad;
    }

    public void setGarantiYrkegrad(int garantiYrkegrad) {
        this.garantiYrkegrad = garantiYrkegrad;
    }

    public int getTilleggspensjon() {
        return tilleggspensjon;
    }

    public void setTilleggspensjon(int tilleggspensjon) {
        this.tilleggspensjon = tilleggspensjon;
    }

    public String getYrkeskadepoengtall() {
        return yrkeskadepoengtall;
    }

    public void setYrkeskadepoengtall(String yrkeskadepoengtall) {
        this.yrkeskadepoengtall = yrkeskadepoengtall;
    }

    public String getSluttpoengtall() {
        return sluttpoengtall;
    }

    public void setSluttpoengtall(String sluttpoengtall) {
        this.sluttpoengtall = sluttpoengtall;
    }

    public int getAntallPoengaar() {
        return antallPoengaar;
    }

    public void setAntallPoengaar(int antallPoengaar) {
        this.antallPoengaar = antallPoengaar;
    }

    public String getPoengberegningsalternativ() {
        return poengberegningsalternativ;
    }

    public void setPoengberegningsalternativ(String poengberegningsalternativ) {
        this.poengberegningsalternativ = poengberegningsalternativ;
    }

    public String getYrkessykdom() {
        return yrkessykdom;
    }

    public void setYrkessykdom(String yrkessykdom) {
        this.yrkessykdom = yrkessykdom;
    }
}
