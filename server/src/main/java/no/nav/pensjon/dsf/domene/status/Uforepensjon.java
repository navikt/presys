package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

import java.math.BigDecimal;

@Segment(name = "UFØRPENS", length = 70)
@UnmappedField(name="UTDANNING", length = 1, start = 31)
@UnmappedField(name="YRKESM_ATTF", length = 1, start = 32)
@UnmappedField(name="STI_AAMD", length = 5, start = 33)
@UnmappedField(name="SPT_1291", length = 2, start = 38)
@UnmappedField(name="OPT_1291", length = 2, start = 40)
@UnmappedField(name="PAA_1291", length = 2, start = 42)
@UnmappedField(name="YNGSTE_BARN_FOR", length = 3, start = 46)
@UnmappedField(name="INNTEKT_FOR_UP", length = 3, start = 49)
@UnmappedField(name="INNT_DATO_AAMD", length = 5, start = 52)
@UnmappedField(name="REAKTIVISERING", length = 1, start = 57)
@UnmappedField(name="UNNTAK_VENTETID", length = 1, start = 58)
@UnmappedField(name="GARANTIGRAD", length = 2, start = 59)
@UnmappedField(name="GARANTERT_TP", length = 1, start = 61)
@UnmappedField(name="LOVLIG_INNTEKT", length = 4, start = 62)
@UnmappedField(name="INNTEKTSKODE1", length = 1, start = 66)
@UnmappedField(name="INNTEKTSKODE2", length = 1, start = 67)
@UnmappedField(name="LONNSTILSKUDD", length = 1, start = 68)
@UnmappedField(name ="FILLER", length = 1, start = 69)
public class Uforepensjon {

    @Felt(name="UFG", length = 2, start = 0) @PackedDecimal private int uforegrad;
    @Felt(name="VILKAAR_8_4_3A", length = 1, start = 2) private String vilkaarPar8Pkt4Ledd3BokstavA;
    @Felt(name="VILKAAR_8_1B", length = 1, start = 3) private String vilkaarPar8Pkt1BokstavB;
    @Felt(name="GP", length = 3, start = 4) @PackedDecimal private int grunnpensjon;
    @Felt(name="ST", length = 3, start = 7) @PackedDecimal private int saertillegg;
    @Felt(name="AAFT", length = 3, start = 10) @PackedDecimal private int aatteFemEnTillegg;
    @Felt(name="ET", length = 3, start = 13) @PackedDecimal private int ektefelletillegg;
    @Felt(name="BT", length = 3, start = 16) @PackedDecimal private int barnetillegg;
    @Felt(name="KT", length = 3, start = 19) @PackedDecimal private int kompensasjonstillegg;
    @Felt(name="TP", length = 3, start = 22) @PackedDecimal private int tilleggspensjon;
    @Felt(name="SPT", length = 2, start = 25) @PackedDecimal(decimals = 2) private BigDecimal sluttpoengtall;
    @Felt(name="OPT", length = 2, start = 27) @PackedDecimal(decimals = 2) private BigDecimal overkompensasjonstillegg;
    @Felt(name="PAA", length = 2, start = 29) @PackedDecimal private int poengAar;
    @Felt(name="PAA_ETTER91", length = 2, start = 44) @PackedDecimal private int poengAarEtter91;

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

    public int getPoengAarEtter91() {
        return poengAarEtter91;
    }

    public void setPoengAarEtter91(int poengAarEtter91) {
        this.poengAarEtter91 = poengAarEtter91;
    }

    public int getPoengAar() {
        return poengAar;
    }

    public void setPoengAar(int poengAar) {
        this.poengAar = poengAar;
    }
}
