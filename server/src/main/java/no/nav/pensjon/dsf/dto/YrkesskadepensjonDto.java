package no.nav.pensjon.dsf.dto;

public class YrkesskadepensjonDto {

    private int gjeldendeYrkesgrad;
    private int grunnpensjon;
    private int saertillegg;
    private int ektefelletillegg;
    private int barnetillegg;
    private int garantiYrkegrad;
    private int tilleggspensjon;
    private String yrkeskadepoengtall;
    private String sluttpoengtall;
    private int antallPoengaar;
    private String poengberegningsalternativ;
    private String yrkessykdom;

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
