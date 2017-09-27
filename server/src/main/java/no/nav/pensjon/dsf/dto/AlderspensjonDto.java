package no.nav.pensjon.dsf.dto;

public class AlderspensjonDto {

    private int grunnpensjon;
    private int saertillegg;
    private int tilleggspensjon;
    private String sluttpoengtall;
    private String overkompensasjonPoengtall;
    private int poengaar;

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

    public int getTilleggspensjon() {
        return tilleggspensjon;
    }

    public void setTilleggspensjon(int tilleggspensjon) {
        this.tilleggspensjon = tilleggspensjon;
    }

    public String getSluttpoengtall() {
        return sluttpoengtall;
    }

    public void setSluttpoengtall(String sluttpoengtall) {
        this.sluttpoengtall = sluttpoengtall;
    }

    public String getOverkompensasjonPoengtall() {
        return overkompensasjonPoengtall;
    }

    public void setOverkompensasjonPoengtall(String overkompensasjonPoengtall) {
        this.overkompensasjonPoengtall = overkompensasjonPoengtall;
    }

    public int getPoengaar() {
        return poengaar;
    }

    public void setPoengaar(int poengaar) {
        this.poengaar = poengaar;
    }
}
