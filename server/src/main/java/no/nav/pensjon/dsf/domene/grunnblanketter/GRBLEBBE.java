package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRBLEBBE", length = 114)
@UnmappedField(name = "filler", length = 3, start = 111)
public class GRBLEBBE {

    @Felt(name="FNR_MOR", length = 6, start = 0) @PackedDecimal private String fodselsnummerMor;
    @Felt(name="NAVNMOR", length = 25, start = 6) private String navnMor;
    @Felt(name="DODDTOMO_AAMD", length = 5, start = 31) @PackedDecimal private int dodsdatoMor;
    @Felt(name="VIL843AM", length = 1, start = 36) private String vilkaar843AMor;
    @Felt(name="OVERKOMP_UTL_MOR", length = 1, start = 37) private String overkompensasjonUtlandMor;
    @Felt(name="TTF67MO", length = 2, start = 38) @PackedDecimal private int trygdetidFor1967Mor;
    @Felt(name="TT_ETTER_1966_MOR_AAR", length = 2, start = 40) @PackedDecimal private int trygdetidEtter1966MorAAr;
    @Felt(name="TT_ETTER_1966_MOR_MM", length = 2, start = 42) @PackedDecimal private int trygdetidEtter1966MorMaaneder;
    @Felt(name="PIMOR", length = 4, start = 44) @PackedDecimal private int pensjonsgivendeInntektMor;
    @Felt(name="DOD_AV_YRKESSKADE_MOR", length = 1, start = 48) private String dodYrkesskadeMor;
    @Felt(name="FNR_FAR", length = 6, start = 49) @PackedDecimal private String fodselsnummerFar;
    @Felt(name="NAVNFAR", length = 25, start = 55) private String navnFar;
    @Felt(name="DODDTOFA_AAMD", length = 5, start = 80) @PackedDecimal private int dodsdatoFar;
    @Felt(name="VIL843AF", length = 1, start = 85) private String vilkaar843AFar;
    @Felt(name="OVERKOMP_UTL_FAR", length = 1, start = 86) private String overkompensasjonUtlandFar;
    @Felt(name="TTF67FA", length = 2, start = 87) @PackedDecimal private int trygdetidFor1967far;
    @Felt(name="TT_ETTER_1966_FAR_AAR", length = 2, start = 89) @PackedDecimal private int trygdetidEtter1966FarAAr;
    @Felt(name="TT_ETTER_1966_FAR_MM", length = 2, start = 91) @PackedDecimal private int trygdetidEtter1966FarMaaneder;
    @Felt(name="VERNEPLIKTAAR1", length = 3, start = 93) @PackedDecimal private int vernepliktaarFar1;
    @Felt(name="VERNEPLIKTAAR2", length = 3, start = 96) @PackedDecimal private int vernepliktaarFar2;
    @Felt(name="VERNEPLIKTAAR3", length = 3, start = 99) @PackedDecimal private int vernepliktaarFar3;
    @Felt(name="VERNEPLIKTAAR4", length = 3, start = 102) @PackedDecimal private int vernepliktaarFar4;
    @Felt(name="PIFAR", length = 4, start = 105) @PackedDecimal private int pensjonsgivendeInntektFar;
    @Felt(name="DOD_AV_YRKESSKADE_FAR", length = 1, start = 109) private String dodYrkesskadeFar;
    @Felt(name="BARNE_TAB_POS", length = 1, start = 110) private String barneTabPos;

    public String getFodselsnummerMor() {
        return fodselsnummerMor;
    }

    public void setFodselsnummerMor(String fodselsnummerMor) {
        this.fodselsnummerMor = fodselsnummerMor;
    }

    public String getNavnMor() {
        return navnMor;
    }

    public void setNavnMor(String navnMor) {
        this.navnMor = navnMor;
    }

    public int getDodsdatoMor() {
        return dodsdatoMor;
    }

    public void setDodsdatoMor(int dodsdatoMor) {
        this.dodsdatoMor = dodsdatoMor;
    }

    public String getVilkaar843AMor() {
        return vilkaar843AMor;
    }

    public void setVilkaar843AMor(String vilkaar843AMor) {
        this.vilkaar843AMor = vilkaar843AMor;
    }

    public String getOverkompensasjonUtlandMor() {
        return overkompensasjonUtlandMor;
    }

    public void setOverkompensasjonUtlandMor(String overkompensasjonUtlandMor) {
        this.overkompensasjonUtlandMor = overkompensasjonUtlandMor;
    }

    public int getTrygdetidFor1967Mor() {
        return trygdetidFor1967Mor;
    }

    public void setTrygdetidFor1967Mor(int trygdetidFor1967Mor) {
        this.trygdetidFor1967Mor = trygdetidFor1967Mor;
    }

    public int getTrygdetidEtter1966MorAAr() {
        return trygdetidEtter1966MorAAr;
    }

    public void setTrygdetidEtter1966MorAAr(int trygdetidEtter1966MorAAr) {
        this.trygdetidEtter1966MorAAr = trygdetidEtter1966MorAAr;
    }

    public int getTrygdetidEtter1966MorMaaneder() {
        return trygdetidEtter1966MorMaaneder;
    }

    public void setTrygdetidEtter1966MorMaaneder(int trygdetidEtter1966MorMaaneder) {
        this.trygdetidEtter1966MorMaaneder = trygdetidEtter1966MorMaaneder;
    }

    public int getPensjonsgivendeInntektMor() {
        return pensjonsgivendeInntektMor;
    }

    public void setPensjonsgivendeInntektMor(int pensjonsgivendeInntektMor) {
        this.pensjonsgivendeInntektMor = pensjonsgivendeInntektMor;
    }

    public String getDodYrkesskadeMor() {
        return dodYrkesskadeMor;
    }

    public void setDodYrkesskadeMor(String dodYrkesskadeMor) {
        this.dodYrkesskadeMor = dodYrkesskadeMor;
    }

    public String getFodselsnummerFar() {
        return fodselsnummerFar;
    }

    public void setFodselsnummerFar(String fodselsnummerFar) {
        this.fodselsnummerFar = fodselsnummerFar;
    }

    public String getNavnFar() {
        return navnFar;
    }

    public void setNavnFar(String navnFar) {
        this.navnFar = navnFar;
    }

    public int getDodsdatoFar() {
        return dodsdatoFar;
    }

    public void setDodsdatoFar(int dodsdatoFar) {
        this.dodsdatoFar = dodsdatoFar;
    }

    public String getVilkaar843AFar() {
        return vilkaar843AFar;
    }

    public void setVilkaar843AFar(String vilkaar843AFar) {
        this.vilkaar843AFar = vilkaar843AFar;
    }

    public String getOverkompensasjonUtlandFar() {
        return overkompensasjonUtlandFar;
    }

    public void setOverkompensasjonUtlandFar(String overkompensasjonUtlandFar) {
        this.overkompensasjonUtlandFar = overkompensasjonUtlandFar;
    }

    public int getTrygdetidFor1967far() {
        return trygdetidFor1967far;
    }

    public void setTrygdetidFor1967far(int trygdetidFor1967far) {
        this.trygdetidFor1967far = trygdetidFor1967far;
    }

    public int getTrygdetidEtter1966FarAAr() {
        return trygdetidEtter1966FarAAr;
    }

    public void setTrygdetidEtter1966FarAAr(int trygdetidEtter1966FarAAr) {
        this.trygdetidEtter1966FarAAr = trygdetidEtter1966FarAAr;
    }

    public int getTrygdetidEtter1966FarMaaneder() {
        return trygdetidEtter1966FarMaaneder;
    }

    public void setTrygdetidEtter1966FarMaaneder(int trygdetidEtter1966FarMaaneder) {
        this.trygdetidEtter1966FarMaaneder = trygdetidEtter1966FarMaaneder;
    }

    public int getVernepliktaarFar1() {
        return vernepliktaarFar1;
    }

    public void setVernepliktaarFar1(int vernepliktaarFar1) {
        this.vernepliktaarFar1 = vernepliktaarFar1;
    }

    public int getVernepliktaarFar2() {
        return vernepliktaarFar2;
    }

    public void setVernepliktaarFar2(int vernepliktaarFar2) {
        this.vernepliktaarFar2 = vernepliktaarFar2;
    }

    public int getVernepliktaarFar3() {
        return vernepliktaarFar3;
    }

    public void setVernepliktaarFar3(int vernepliktaarFar3) {
        this.vernepliktaarFar3 = vernepliktaarFar3;
    }

    public int getVernepliktaarFar4() {
        return vernepliktaarFar4;
    }

    public void setVernepliktaarFar4(int vernepliktaarFar4) {
        this.vernepliktaarFar4 = vernepliktaarFar4;
    }

    public int getPensjonsgivendeInntektFar() {
        return pensjonsgivendeInntektFar;
    }

    public void setPensjonsgivendeInntektFar(int pensjonsgivendeInntektFar) {
        this.pensjonsgivendeInntektFar = pensjonsgivendeInntektFar;
    }

    public String getDodYrkesskadeFar() {
        return dodYrkesskadeFar;
    }

    public void setDodYrkesskadeFar(String dodYrkesskadeFar) {
        this.dodYrkesskadeFar = dodYrkesskadeFar;
    }

    public String getBarneTabPos() {
        return barneTabPos;
    }

    public void setBarneTabPos(String barneTabPos) {
        this.barneTabPos = barneTabPos;
    }
}
