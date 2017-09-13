package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRUNNBYP", length = 38)//MV
@UnmappedField(name = "filler", length = 3, start = 35)
public class GRUNNBYP {


    @Felt(name="VILKAAR_1_2_2A", length = 1, start = 0) private String vilkaarPar1Pkt2Ledd2BokstavA;
    @Felt(name="VILKAAR_1_2_2B", length = 1, start = 1) private String vilkaarPar1Pkt2Ledd2BokstavB;
    @Felt(name="YSKADE_TIDSP_AAMD", length = 5, start = 2) @PackedDecimal private int yrkesskadetidspunkt;
    @Felt(name="YSYKDOM", length = 1, start = 7) private String yrkessykdom;
    @Felt(name="YUG", length = 2, start = 8) @PackedDecimal private int yrkesskadeufor;
    @Felt(name="KAP11_7_UTLST", length = 1, start = 10) private String kapittel11Pkt7Utlost;
    @Felt(name="YRKE11", length = 1, start = 11) private String yrke11;
    @Felt(name="AI", length = 4, start = 12) @PackedDecimal private int aarligArbeidsinntekt;
    @Felt(name="FNR_EK", length = 6, start = 16) @PackedDecimal private String fodselsnummerEktefelle;
    @Felt(name="FNR_SAMBOER", length = 6, start = 22) @PackedDecimal private String fodselsnummerSamboer;
    @Felt(name="FNR_BARN", length = 6, start = 28) @PackedDecimal private String fodselsnummerBarn;
    @Felt(name="PLEIEBARN", length = 1, start = 34) private String fodselsnummerPleiebarn;

    public String getVilkaarPar1Pkt2Ledd2BokstavA() {
        return vilkaarPar1Pkt2Ledd2BokstavA;
    }

    public void setVilkaarPar1Pkt2Ledd2BokstavA(String vilkaarPar1Pkt2Ledd2BokstavA) {
        this.vilkaarPar1Pkt2Ledd2BokstavA = vilkaarPar1Pkt2Ledd2BokstavA;
    }

    public String getVilkaarPar1Pkt2Ledd2BokstavB() {
        return vilkaarPar1Pkt2Ledd2BokstavB;
    }

    public void setVilkaarPar1Pkt2Ledd2BokstavB(String vilkaarPar1Pkt2Ledd2BokstavB) {
        this.vilkaarPar1Pkt2Ledd2BokstavB = vilkaarPar1Pkt2Ledd2BokstavB;
    }

    public int getYrkesskadetidspunkt() {
        return yrkesskadetidspunkt;
    }

    public void setYrkesskadetidspunkt(int yrkesskadetidspunkt) {
        this.yrkesskadetidspunkt = yrkesskadetidspunkt;
    }

    public String getYrkessykdom() {
        return yrkessykdom;
    }

    public void setYrkessykdom(String yrkessykdom) {
        this.yrkessykdom = yrkessykdom;
    }

    public int getYrkesskadeufor() {
        return yrkesskadeufor;
    }

    public void setYrkesskadeufor(int yrkesskadeufor) {
        this.yrkesskadeufor = yrkesskadeufor;
    }

    public String getKapittel11Pkt7Utlost() {
        return kapittel11Pkt7Utlost;
    }

    public void setKapittel11Pkt7Utlost(String kapittel11Pkt7Utlost) {
        this.kapittel11Pkt7Utlost = kapittel11Pkt7Utlost;
    }

    public String getYrke11() {
        return yrke11;
    }

    public void setYrke11(String yrke11) {
        this.yrke11 = yrke11;
    }

    public int getAarligArbeidsinntekt() {
        return aarligArbeidsinntekt;
    }

    public void setAarligArbeidsinntekt(int aarligArbeidsinntekt) {
        this.aarligArbeidsinntekt = aarligArbeidsinntekt;
    }

    public String getFodselsnummerEktefelle() {
        return fodselsnummerEktefelle;
    }

    public void setFodselsnummerEktefelle(String fodselsnummerEktefelle) {
        this.fodselsnummerEktefelle = fodselsnummerEktefelle;
    }

    public String getFodselsnummerSamboer() {
        return fodselsnummerSamboer;
    }

    public void setFodselsnummerSamboer(String fodselsnummerSamboer) {
        this.fodselsnummerSamboer = fodselsnummerSamboer;
    }

    public String getFodselsnummerBarn() {
        return fodselsnummerBarn;
    }

    public void setFodselsnummerBarn(String fodselsnummerBarn) {
        this.fodselsnummerBarn = fodselsnummerBarn;
    }

    public String getFodselsnummerPleiebarn() {
        return fodselsnummerPleiebarn;
    }

    public void setFodselsnummerPleiebarn(String fodselsnummerPleiebarn) {
        this.fodselsnummerPleiebarn = fodselsnummerPleiebarn;
    }
}
