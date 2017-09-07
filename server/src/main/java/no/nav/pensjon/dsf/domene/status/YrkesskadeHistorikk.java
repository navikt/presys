package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

import java.util.List;

@UnmappedField(name = "filler", length = 2, start = 28)
@Segment(name = "YRKEHIST", length = 30)
public class YrkesskadeHistorikk {

    @Felt(name="YUFT_AAMD", length = 5, start = 0) @PackedDecimal private int yrkeUforetidspunkt;
    @Felt(name="YUG", length = 2, start = 5) @PackedDecimal private int yrkeUforegrad;
    @Felt(name="YST_AAMD", length = 5, start = 7) @PackedDecimal private int skadetidspunkt;
    @Felt(name="AAAI", length = 4, start = 12) @PackedDecimal private int antattAarligArbeidsinntekt;
    @Felt(name="YRKE11", length = 1, start = 16) private String yrke11;
    @Felt(name="VILKAAR_1_2_2", length = 2, start = 17) private String vilkaarPar1Pkt2Ledd2;
    @Felt(name="KAP_11_7_UTLOST", length = 1, start = 19) private String kap11Pkt7Utlost;
    @Felt(name="OPPH_DATO_AAMD", length = 5, start = 20) @PackedDecimal private int opphorsdato;
    @Felt(name="OPPH_KODE", length = 1, start = 25) private String opphorskode;
    @Felt(name="PAAA", length = 2, start = 26) @PackedDecimal(decimals = 2) private String sluttpoengtall;

    @SubSegment
    List<GradsendringInnenforYrkesskadeperioden> gradsendringInnenforYrkesskadeperiodens;

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

    public List<GradsendringInnenforYrkesskadeperioden> getGradsendringInnenforYrkesskadeperiodens() {
        return gradsendringInnenforYrkesskadeperiodens;
    }
}
