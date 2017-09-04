package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRBLEBB6", length = 40)
@UnmappedField(name = "filler", length = 4, start = 38)
public class GRBLEBB6 {

    @Felt(name="BEREGN_RED_TT", length = 1, start = 36) private String beregnesEtterRedusertTrygdetid;
    @Felt(name="TT_REDUSERT", length = 2, start = 0) @PackedDecimal private int redusertTrygdetid;
    @Felt(name="KONVENSJON", length = 1, start = 36) private String konvensjon;
    @Felt(name="PENSJONSTRYGDET", length = 1, start = 36) private String pensjonstrygdet;
    @Felt(name="MINST_20AAR", length = 1, start = 36) private String minst20Aar;
    @Felt(name="FNR_DOD", length = 6, start = 0) @PackedDecimal private int fodselsnummerAvdod;
    @Felt(name="NAVN_DOD", length = 25, start = 0) private String navnAvdod;
    @Felt(name="DODSDATO_AAMD", length = 5, start = 0) @PackedDecimal private int dodsdato;
    @Felt(name="VILKAAR_8_4_3A", length = 1, start = 36) private String vilkaarPar8Pkt4Ledd3BokstavA;
    @Felt(name="VP_AAR_DOD1", length = 3, start = 0) @PackedDecimal private int vernepliktaarAvdod1;
    @Felt(name="VP_AAR_DOD2", length = 3, start = 0) @PackedDecimal private int vernepliktaarAvdod2;
    @Felt(name="VP_AAR_DOD3", length = 3, start = 0) @PackedDecimal private int vernepliktaarAvdod3;
    @Felt(name="PI_DOD", length = 3, start = 0) @PackedDecimal private int pensjonsgivendeInntektAvdod;

    public String getBeregnesEtterRedusertTrygdetid() {
        return beregnesEtterRedusertTrygdetid;
    }

    public void setBeregnesEtterRedusertTrygdetid(String beregnesEtterRedusertTrygdetid) {
        this.beregnesEtterRedusertTrygdetid = beregnesEtterRedusertTrygdetid;
    }

    public int getRedusertTrygdetid() {
        return redusertTrygdetid;
    }

    public void setRedusertTrygdetid(int redusertTrygdetid) {
        this.redusertTrygdetid = redusertTrygdetid;
    }

    public String getKonvensjon() {
        return konvensjon;
    }

    public void setKonvensjon(String konvensjon) {
        this.konvensjon = konvensjon;
    }

    public String getPensjonstrygdet() {
        return pensjonstrygdet;
    }

    public void setPensjonstrygdet(String pensjonstrygdet) {
        this.pensjonstrygdet = pensjonstrygdet;
    }

    public String getMinst20Aar() {
        return minst20Aar;
    }

    public void setMinst20Aar(String minst20Aar) {
        this.minst20Aar = minst20Aar;
    }

    public int getFodselsnummerAvdod() {
        return fodselsnummerAvdod;
    }

    public void setFodselsnummerAvdod(int fodselsnummerAvdod) {
        this.fodselsnummerAvdod = fodselsnummerAvdod;
    }

    public String getNavnAvdod() {
        return navnAvdod;
    }

    public void setNavnAvdod(String navnAvdod) {
        this.navnAvdod = navnAvdod;
    }

    public int getDodsdato() {
        return dodsdato;
    }

    public void setDodsdato(int dodsdato) {
        this.dodsdato = dodsdato;
    }

    public String getVilkaarPar8Pkt4Ledd3BokstavA() {
        return vilkaarPar8Pkt4Ledd3BokstavA;
    }

    public void setVilkaarPar8Pkt4Ledd3BokstavA(String vilkaarPar8Pkt4Ledd3BokstavA) {
        this.vilkaarPar8Pkt4Ledd3BokstavA = vilkaarPar8Pkt4Ledd3BokstavA;
    }

    public int getVernepliktaarAvdod1() {
        return vernepliktaarAvdod1;
    }

    public void setVernepliktaarAvdod1(int vernepliktaarAvdod1) {
        this.vernepliktaarAvdod1 = vernepliktaarAvdod1;
    }

    public int getVernepliktaarAvdod2() {
        return vernepliktaarAvdod2;
    }

    public void setVernepliktaarAvdod2(int vernepliktaarAvdod2) {
        this.vernepliktaarAvdod2 = vernepliktaarAvdod2;
    }

    public int getVernepliktaarAvdod3() {
        return vernepliktaarAvdod3;
    }

    public void setVernepliktaarAvdod3(int vernepliktaarAvdod3) {
        this.vernepliktaarAvdod3 = vernepliktaarAvdod3;
    }

    public int getPensjonsgivendeInntektAvdod() {
        return pensjonsgivendeInntektAvdod;
    }

    public void setPensjonsgivendeInntektAvdod(int pensjonsgivendeInntektAvdod) {
        this.pensjonsgivendeInntektAvdod = pensjonsgivendeInntektAvdod;
    }
}
