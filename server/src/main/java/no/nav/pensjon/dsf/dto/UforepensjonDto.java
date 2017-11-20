package no.nav.pensjon.dsf.dto;

import java.math.BigDecimal;

public class UforepensjonDto {

    private int uforegrad;
    private String vilkaarPar8Pkt4Ledd3BokstavA;
    private String vilkaarPar8Pkt1BokstavB;
    private int grunnpensjon;
    private int saertillegg;
    private int aatteFemEnTillegg;
    private int ektefelletillegg;
    private int barnetillegg;
    private int kompensasjonstillegg;
    private int tilleggspensjon;
    private BigDecimal sluttpoengtall;
    private BigDecimal overkompensasjonstillegg;
    private int poengAar;
    private int poengAarEtter91;

    public int getUforegrad() {
        return uforegrad;
    }

    public void setUforegrad(int uforegrad) {
        this.uforegrad = uforegrad;
    }

    public String getVilkaarPar8Pkt4Ledd3BokstavA() {
        return vilkaarPar8Pkt4Ledd3BokstavA;
    }

    public void setVilkaarPar8Pkt4Ledd3BokstavA(String vilkaarPar8Pkt4Ledd3BokstavA) {
        this.vilkaarPar8Pkt4Ledd3BokstavA = vilkaarPar8Pkt4Ledd3BokstavA;
    }

    public String getVilkaarPar8Pkt1BokstavB() {
        return vilkaarPar8Pkt1BokstavB;
    }

    public void setVilkaarPar8Pkt1BokstavB(String vilkaarPar8Pkt1BokstavB) {
        this.vilkaarPar8Pkt1BokstavB = vilkaarPar8Pkt1BokstavB;
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

    public int getAatteFemEnTillegg() {
        return aatteFemEnTillegg;
    }

    public void setAatteFemEnTillegg(int aatteFemEnTillegg) {
        this.aatteFemEnTillegg = aatteFemEnTillegg;
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

    public int getKompensasjonstillegg() {
        return kompensasjonstillegg;
    }

    public void setKompensasjonstillegg(int kompensasjonstillegg) {
        this.kompensasjonstillegg = kompensasjonstillegg;
    }

    public int getTilleggspensjon() {
        return tilleggspensjon;
    }

    public void setTilleggspensjon(int tilleggspensjon) {
        this.tilleggspensjon = tilleggspensjon;
    }

    public BigDecimal getSluttpoengtall() {
        return sluttpoengtall;
    }

    public void setSluttpoengtall(BigDecimal sluttpoengtall) {
        this.sluttpoengtall = sluttpoengtall;
    }

    public BigDecimal getOverkompensasjonstillegg() {
        return overkompensasjonstillegg;
    }

    public void setOverkompensasjonstillegg(BigDecimal overkompensasjonstillegg) {
        this.overkompensasjonstillegg = overkompensasjonstillegg;
    }

    public int getPoengAar() {
        return poengAar;
    }

    public void setPoengAar(int poengAar) {
        this.poengAar = poengAar;
    }

    public int getPoengAarEtter91() {
        return poengAarEtter91;
    }

    public void setPoengAarEtter91(int poengAarEtter91) {
        this.poengAarEtter91 = poengAarEtter91;
    }
}
