package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@UnmappedField(name="FILLER", length = 11, start = 71)
@Segment(name = "GRUNNBEE", length = 82)
public class GRUNNBEE {

    @Felt(name="NORSK_BOSATT", length = 1, start = 0) private String bosattNorge;
    @Felt(name="FORVENTET_INNT", length = 3, start = 1) @PackedDecimal private int forventetArbeidsInntekt;
    @Felt(name="FAI", length = 3, start = 4) @PackedDecimal private int forventetArbeidsInntektMellom67Og70;
    @Felt(name="GP_OS_KODE", length = 1, start = 7) private String overgangsstonadPensjonKode;
    @Felt(name="YSKADE_TILLEGG", length = 1, start = 8) private String yrkesskadetillegg;
    @Felt(name="FRAMLEGGSDATO_AAMD", length = 5, start = 9) @PackedDecimal private int framleggsdato;
    @Felt(name="FNR_EK", length = 6, start = 14) @PackedDecimal private int fodselsnummerEktefelle;
    @Felt(name="NAVN_EK", length = 25, start = 20) private String navnEktefelle;
    @Felt(name="SIVILSTAND_EK", length = 1, start = 45) private String sivilstandEktefelle;
    @Felt(name="DODSDATO_AAMD_EK", length = 5, start = 46) @PackedDecimal private int dodsdatoEktefelle;
    @Felt(name="NORSK_BOSATT_EK", length = 1, start = 51) private String bosattNorgeEktefelle;
    @Felt(name="VILKAAR_3_17A_EK", length = 1, start = 52) private String vilkaarPar3Pkt17AEktefelle;
    @Felt(name="VERNEPLIKTAAR1EK", length = 3, start = 53) @PackedDecimal private int vernepliktaar1Ektefelle;
    @Felt(name="VERNEPLIKTAAR2EK", length = 3, start = 56) @PackedDecimal private int vernepliktaar2Ektefelle;
    @Felt(name="VERNEPLIKTAAR3EK", length = 3, start = 59) @PackedDecimal private int vernepliktaar3Ektefelle;
    @Felt(name="VERNEPLIKTAAR4EK", length = 3, start = 62) @PackedDecimal private int vernepliktaar4Ektefelle;
    @Felt(name="PI_EK", length = 4, start = 65) @PackedDecimal private int pensjonsgivendeInntektEktefelle;
    @Felt(name="RED_GP_3_2_5", length = 1, start = 69) private String redusertGrunnpensjonPar3Pkt2Ledd5;
    @Felt(name="FRADRAG_2G", length = 1, start = 70) private String ektefelleInntektOver2G;

    public String getBosattNorge() {
        return bosattNorge;
    }

    public void setBosattNorge(String bosattNorge) {
        this.bosattNorge = bosattNorge;
    }

    public int getForventetArbeidsInntekt() {
        return forventetArbeidsInntekt;
    }

    public void setForventetArbeidsInntekt(int forventetArbeidsInntekt) {
        this.forventetArbeidsInntekt = forventetArbeidsInntekt;
    }

    public int getForventetArbeidsInntektMellom67Og70() {
        return forventetArbeidsInntektMellom67Og70;
    }

    public void setForventetArbeidsInntektMellom67Og70(int forventetArbeidsInntektMellom67Og70) {
        this.forventetArbeidsInntektMellom67Og70 = forventetArbeidsInntektMellom67Og70;
    }

    public String getOvergangsstonadPensjonKode() {
        return overgangsstonadPensjonKode;
    }

    public void setOvergangsstonadPensjonKode(String overgangsstonadPensjonKode) {
        this.overgangsstonadPensjonKode = overgangsstonadPensjonKode;
    }

    public String getYrkesskadetillegg() {
        return yrkesskadetillegg;
    }

    public void setYrkesskadetillegg(String yrkesskadetillegg) {
        this.yrkesskadetillegg = yrkesskadetillegg;
    }

    public int getFramleggsdato() {
        return framleggsdato;
    }

    public void setFramleggsdato(int framleggsdato) {
        this.framleggsdato = framleggsdato;
    }

    public int getFodselsnummerEktefelle() {
        return fodselsnummerEktefelle;
    }

    public void setFodselsnummerEktefelle(int fodselsnummerEktefelle) {
        this.fodselsnummerEktefelle = fodselsnummerEktefelle;
    }

    public String getNavnEktefelle() {
        return navnEktefelle;
    }

    public void setNavnEktefelle(String navnEktefelle) {
        this.navnEktefelle = navnEktefelle;
    }

    public String getSivilstandEktefelle() {
        return sivilstandEktefelle;
    }

    public void setSivilstandEktefelle(String sivilstandEktefelle) {
        this.sivilstandEktefelle = sivilstandEktefelle;
    }

    public int getDodsdatoEktefelle() {
        return dodsdatoEktefelle;
    }

    public void setDodsdatoEktefelle(int dodsdatoEktefelle) {
        this.dodsdatoEktefelle = dodsdatoEktefelle;
    }

    public String getBosattNorgeEktefelle() {
        return bosattNorgeEktefelle;
    }

    public void setBosattNorgeEktefelle(String bosattNorgeEktefelle) {
        this.bosattNorgeEktefelle = bosattNorgeEktefelle;
    }

    public String getVilkaarPar3Pkt17AEktefelle() {
        return vilkaarPar3Pkt17AEktefelle;
    }

    public void setVilkaarPar3Pkt17AEktefelle(String vilkaarPar3Pkt17AEktefelle) {
        this.vilkaarPar3Pkt17AEktefelle = vilkaarPar3Pkt17AEktefelle;
    }

    public int getVernepliktaar1Ektefelle() {
        return vernepliktaar1Ektefelle;
    }

    public void setVernepliktaar1Ektefelle(int vernepliktaar1Ektefelle) {
        this.vernepliktaar1Ektefelle = vernepliktaar1Ektefelle;
    }

    public int getVernepliktaar2Ektefelle() {
        return vernepliktaar2Ektefelle;
    }

    public void setVernepliktaar2Ektefelle(int vernepliktaar2Ektefelle) {
        this.vernepliktaar2Ektefelle = vernepliktaar2Ektefelle;
    }

    public int getVernepliktaar3Ektefelle() {
        return vernepliktaar3Ektefelle;
    }

    public void setVernepliktaar3Ektefelle(int vernepliktaar3Ektefelle) {
        this.vernepliktaar3Ektefelle = vernepliktaar3Ektefelle;
    }

    public int getVernepliktaar4Ektefelle() {
        return vernepliktaar4Ektefelle;
    }

    public void setVernepliktaar4Ektefelle(int vernepliktaar4Ektefelle) {
        this.vernepliktaar4Ektefelle = vernepliktaar4Ektefelle;
    }

    public int getPensjonsgivendeInntektEktefelle() {
        return pensjonsgivendeInntektEktefelle;
    }

    public void setPensjonsgivendeInntektEktefelle(int pensjonsgivendeInntektEktefelle) {
        this.pensjonsgivendeInntektEktefelle = pensjonsgivendeInntektEktefelle;
    }

    public String getRedusertGrunnpensjonPar3Pkt2Ledd5() {
        return redusertGrunnpensjonPar3Pkt2Ledd5;
    }

    public void setRedusertGrunnpensjonPar3Pkt2Ledd5(String redusertGrunnpensjonPar3Pkt2Ledd5) {
        this.redusertGrunnpensjonPar3Pkt2Ledd5 = redusertGrunnpensjonPar3Pkt2Ledd5;
    }

    public String getEktefelleInntektOver2G() {
        return ektefelleInntektOver2G;
    }

    public void setEktefelleInntektOver2G(String ektefelleInntektOver2G) {
        this.ektefelleInntektOver2G = ektefelleInntektOver2G;
    }
}
