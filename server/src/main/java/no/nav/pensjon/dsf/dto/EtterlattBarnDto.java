package no.nav.pensjon.dsf.dto;

public class EtterlattBarnDto extends GrunnblankettDto {

    private String pensjonEtter;
    private int gp;
    private int tp;
    private int st;
    private int kt;
    private String sptMor;
    private String optMor;
    private int paaMor;
    private String sptFar;
    private String optFar;
    private int paaFar;

    public String getPensjonEtter() {
        return pensjonEtter;
    }

    public void setPensjonEtter(String pensjonEtter) {
        this.pensjonEtter = pensjonEtter;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getKt() {
        return kt;
    }

    public void setKt(int kt) {
        this.kt = kt;
    }

    public String getSptMor() {
        return sptMor;
    }

    public void setSptMor(String sptMor) {
        this.sptMor = sptMor;
    }

    public String getOptMor() {
        return optMor;
    }

    public void setOptMor(String optMor) {
        this.optMor = optMor;
    }

    public int getPaaMor() {
        return paaMor;
    }

    public void setPaaMor(int paaMor) {
        this.paaMor = paaMor;
    }

    public String getSptFar() {
        return sptFar;
    }

    public void setSptFar(String sptFar) {
        this.sptFar = sptFar;
    }

    public String getOptFar() {
        return optFar;
    }

    public void setOptFar(String optFar) {
        this.optFar = optFar;
    }

    public int getPaaFar() {
        return paaFar;
    }

    public void setPaaFar(int paaFar) {
        this.paaFar = paaFar;
    }
}
