package no.nav.pensjon.dsf.dto;

public class YrkesskadeHistorikkDto {

    private int yrkeUforetidspunkt;
    private int yrkeUforegrad;
    private int skadetidspunkt;
    private int antattAarligArbeidsinntekt;
    private String yrke11;
    private String vilkaarPar1Pkt2Ledd2;
    private String kap11Pkt7Utlost;
    private int opphorsdato;
    private String opphorskode;
    private String sluttpoengtall;

    public int getYrkeUforetidspunkt() {
        return yrkeUforetidspunkt;
    }

    public void setYrkeUforetidspunkt(int yrkeUforetidspunkt) {
        this.yrkeUforetidspunkt = yrkeUforetidspunkt;
    }

    public int getYrkeUforegrad() {
        return yrkeUforegrad;
    }

    public void setYrkeUforegrad(int yrkeUforegrad) {
        this.yrkeUforegrad = yrkeUforegrad;
    }

    public int getSkadetidspunkt() {
        return skadetidspunkt;
    }

    public void setSkadetidspunkt(int skadetidspunkt) {
        this.skadetidspunkt = skadetidspunkt;
    }

    public int getAntattAarligArbeidsinntekt() {
        return antattAarligArbeidsinntekt;
    }

    public void setAntattAarligArbeidsinntekt(int antattAarligArbeidsinntekt) {
        this.antattAarligArbeidsinntekt = antattAarligArbeidsinntekt;
    }

    public String getYrke11() {
        return yrke11;
    }

    public void setYrke11(String yrke11) {
        this.yrke11 = yrke11;
    }

    public String getVilkaarPar1Pkt2Ledd2() {
        return vilkaarPar1Pkt2Ledd2;
    }

    public void setVilkaarPar1Pkt2Ledd2(String vilkaarPar1Pkt2Ledd2) {
        this.vilkaarPar1Pkt2Ledd2 = vilkaarPar1Pkt2Ledd2;
    }

    public String getKap11Pkt7Utlost() {
        return kap11Pkt7Utlost;
    }

    public void setKap11Pkt7Utlost(String kap11Pkt7Utlost) {
        this.kap11Pkt7Utlost = kap11Pkt7Utlost;
    }

    public int getOpphorsdato() {
        return opphorsdato;
    }

    public void setOpphorsdato(int opphorsdato) {
        this.opphorsdato = opphorsdato;
    }

    public String getOpphorskode() {
        return opphorskode;
    }

    public void setOpphorskode(String opphorskode) {
        this.opphorskode = opphorskode;
    }

    public String getSluttpoengtall() {
        return sluttpoengtall;
    }

    public void setSluttpoengtall(String sluttpoengtall) {
        this.sluttpoengtall = sluttpoengtall;
    }
}
