package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Segment(name = "STATUS  ", length = 94)
@UnmappedField(name = "garanti_tp", length = 3, start = 52)
@UnmappedField(name = "garanti_dato_md", length = 5, start = 55)
@UnmappedField(name = "gt_lov92", length = 3, start = 60)
@UnmappedField(name = "gt_tillegg_lov92", length = 3, start = 63)
@UnmappedField(name = "gammel_ft_kode", length = 1, start = 66)
@UnmappedField(name = "yrkeskode", length = 2, start = 67)
@UnmappedField(name = "frysdato", length = 5, start = 70)
@UnmappedField(name = "frysdato", length = 1, start = 75)
@UnmappedField(name = "filler", length = 10, start = 84)

public class Status {

    @Felt(name="virkDato", length = 5, start = 0)
    @PackedDecimal
    private int virkDato;
    @Felt(name="statusKode", length = 1, start = 5)
    private String statusKode;
    @Felt(name="statusKodeHistorie", length = 1, start = 6)
    private String statusKodeHistorie;
    @Felt(name="pensjonsType1", length = 1, start = 7)
    private String pensjonsType1;
    @Felt(name="pensjonsType2", length = 1, start = 8)
    private String pensjonsType2;
    @Felt(name="pensjonsType3", length = 1, start = 9)
    private String pensjonsType3;
    @Felt(name="sivilstand", length = 1, start = 10)
    private String sivilstand;
    @Felt(name="trygdetidFoer1967", length = 2, start = 11)
    @PackedDecimal
    private int trygdetidFoer1967;
    @Felt(name="trygdetidEtter1966", length = 2, start = 13)
    @PackedDecimal
    private int trygdetidEtter1966;
    @Felt(name="trygdetidFramTil", length = 2, start = 15)
    @PackedDecimal
    private int trygdetidFramTil;
    @Felt(name="trygdetid1967Til1970", length = 2, start = 17)
    @PackedDecimal
    private int trygdetid1967Til1970;
    @Felt(name="trygdetidAnvendt", length = 2, start = 19)
    @PackedDecimal
    private int trygdetidAnvendt;
    @Felt(name="foersteGangReg", length = 1, start = 21)
    private String foersteGangReg;
    @Felt(name="sumYtelse", length = 3, start = 22)
    @PackedDecimal
    private int sumYtelse;
    @Felt(name="antallBarn", length = 2, start = 25)
    @PackedDecimal
    private int antallBarn;
    @Felt(name="dodsddato", length = 5, start = 27)
    @PackedDecimal
    private int dodsddato;
    @Felt(name="dodAvYrkesskade", length = 1, start = 32)
    private String dodAvYrkesskade;
    @Felt(name="vilkar8_4_3a", length = 1, start = 33)
    private String vilkar843A;
    @Felt(name="trygdetidGaranti", length = 2, start = 34)
    @PackedDecimal
    private int trygdetidGaranti;
    @Felt(name="grunnbelopsDato", length = 5, start = 36)
    @PackedDecimal
    private int grunnbelopsDato;
    @Felt(name="poengtilleggsDato", length = 5, start = 41)
    @PackedDecimal
    private int poengtilleggsDato;
    @Felt(name="poengtilleggsKode", length = 1, start = 46)
    private String poengtilleggsKode;
    @Felt(name="pensjonsrettFoer91", length = 1, start = 47)
    private String pensjonsrettFoer91;
    @Felt(name="trygdetid16_66", length = 2, start = 48)
    @PackedDecimal
    private int trygdetid1666;
    @Felt(name="garantertTilleggsPensjonKode", length = 1, start = 50)
    private String garantertTilleggsPensjonKode;
    @Felt(name="gammelSammenstotsRegel", length = 1, start = 51)
    private String gammelSammenstotsRegel;

    @Felt(name="ektefelleInntektOver2g", length = 1, start = 69)
    private String ektefelleInntektOver2g;
    @Felt(name="pensjonFor9802", length = 1, start = 76)
    private String pensjonFoer9802;
    @Felt(name="red_grunnPensjon_3_2_1", length = 1, start = 77)
    private String redGrunnPensjon321;
    @Felt(name="grunnPensjonReduksjonsKode", length = 1, start = 78)
    private String grunnPensjonReduksjonsKode;
    @Felt(name="friinntektDato", length = 5, start = 79)
    @PackedDecimal
    private int friinntektDato;

    @SubSegment
    private List<Tilknytning> tilknytninger = new ArrayList<>();

    @SubSegment
    private List<Alderspensjon> alderspensjoner = new ArrayList<>();

    @SubSegment
    private List<UforeHistorikk> uforehistorikk = new ArrayList<>();

    @SubSegment
    private List<YrkesskadeHistorikk> yrkesskadeHistorikker = new ArrayList<>();

    @SubSegment
    private List<AfpHistorikk> afpHistorikker = new ArrayList<>();

    @SubSegment
    private List<Uforepensjon> uforepensjoner = new ArrayList<>();

    @SubSegment
    private List<ForsorgingsTillegg> forsorgingsTillegg = new ArrayList<>();

    @SubSegment
    private List<EtterlattEktefelle> etterlattEktefeller = new ArrayList<>();

    @SubSegment
    private List<EtterlattBarn> etterlattBarn = new ArrayList<>();

    @SubSegment
    private List<EosInfo> eosInfoer = new ArrayList<>();

    @SubSegment
    private List<SpesielleOpplysninger> spesielleOpplysningerer = new ArrayList<>();

    @SubSegment
    private List<Yrkesskadepensjon> yrkesskadepensjonerr = new ArrayList<>();

    public boolean erSiste() {
        return "S".equals(getStatusKode());
    }

    public List<Tilknytning> getTilknytninger() {
        return tilknytninger;
    }

    public List<Alderspensjon> getAlderspensjoner() {
        return alderspensjoner;
    }

    public List<UforeHistorikk> getUforehistorikk() {
        return uforehistorikk;
    }

    public List<AfpHistorikk> getAfpHistorikker() {
        return afpHistorikker;
    }

    public List<Uforepensjon> getUforepensjoner() {
        return uforepensjoner;
    }

    public List<ForsorgingsTillegg> getForsorgingsTillegg() {
        return forsorgingsTillegg;
    }

    public List<EtterlattEktefelle> getEtterlattEktefeller() {
        return etterlattEktefeller;
    }

    public List<EtterlattBarn> getEtterlattBarn() { return etterlattBarn; }

    public List<EosInfo> getEosInfoer() {
        return eosInfoer;
    }

    public List<SpesielleOpplysninger> getSpesielleOpplysningerer() {
        return spesielleOpplysningerer;
    }

    public int getVirkDato() {
        return virkDato;
    }

    public void setVirkDato(int virkDato) {
        this.virkDato = virkDato;
    }

    public String getStatusKode() {
        return statusKode;
    }

    public void setStatusKode(String statusKode) {
        this.statusKode = statusKode;
    }

    public String getStatusKodeHistorie() {
        return statusKodeHistorie;
    }

    public void setStatusKodeHistorie(String statusKodeHistorie) {
        this.statusKodeHistorie = statusKodeHistorie;
    }

    public String getPensjonsType1() {
        return pensjonsType1;
    }

    public void setPensjonsType1(String pensjonsType1) {
        this.pensjonsType1 = pensjonsType1;
    }

    public String getPensjonsType2() { return pensjonsType2; }

    public void setPensjonsType2(String pensjonsType2) {
        this.pensjonsType2 = pensjonsType2;
    }

    public String getPensjonsType3() {
        return pensjonsType3;
    }

    public void setPensjonsType3(String pensjonsType3) {
        this.pensjonsType3 = pensjonsType3;
    }

    public String getSivilstand() {
        return sivilstand;
    }

    public void setSivilstand(String sivilstand) {
        this.sivilstand = sivilstand;
    }

    public int getTrygdetidFoer1967() {
        return trygdetidFoer1967;
    }

    public void setTrygdetidFoer1967(int trygdetidFoer1967) {
        this.trygdetidFoer1967 = trygdetidFoer1967;
    }

    public int getTrygdetidEtter1966() {
        return trygdetidEtter1966;
    }

    public void setTrygdetidEtter1966(int trygdetidEtter1966) {
        this.trygdetidEtter1966 = trygdetidEtter1966;
    }

    public int getTrygdetidFramTil() {
        return trygdetidFramTil;
    }

    public void setTrygdetidFramTil(int trygdetidFramTil) {
        this.trygdetidFramTil = trygdetidFramTil;
    }

    public int getTrygdetid1967Til1970() {
        return trygdetid1967Til1970;
    }

    public void setTrygdetid1967Til1970(int trygdetid1967Til1970) {
        this.trygdetid1967Til1970 = trygdetid1967Til1970;
    }

    public int getTrygdetidAnvendt() {
        return trygdetidAnvendt;
    }

    public void setTrygdetidAnvendt(int trygdetidAnvendt) {
        this.trygdetidAnvendt = trygdetidAnvendt;
    }

    public String getFoersteGangReg() {
        return foersteGangReg;
    }

    public void setFoersteGangReg(String foersteGangReg) {
        this.foersteGangReg = foersteGangReg;
    }

    public int getSumYtelse() {
        return sumYtelse;
    }

    public void setSumYtelse(int sumYtelse) {
        this.sumYtelse = sumYtelse;
    }

    public int getAntallBarn() {
        return antallBarn;
    }

    public void setAntallBarn(int antallBarn) {
        this.antallBarn = antallBarn;
    }

    public int getDodsddato() {
        return dodsddato;
    }

    public void setDodsddato(int dodsddato) {
        this.dodsddato = dodsddato;
    }

    public String getDodAvYrkesskade() {
        return dodAvYrkesskade;
    }

    public void setDodAvYrkesskade(String dodAvYrkesskade) {
        this.dodAvYrkesskade = dodAvYrkesskade;
    }

    public String getVilkar843A() {
        return vilkar843A;
    }

    public void setVilkar843A(String vilkar843A) {
        this.vilkar843A = vilkar843A;
    }

    public int getTrygdetidGaranti() {
        return trygdetidGaranti;
    }

    public void setTrygdetidGaranti(int trygdetidGaranti) {
        this.trygdetidGaranti = trygdetidGaranti;
    }

    public int getGrunnbelopsDato() {
        return grunnbelopsDato;
    }

    public void setGrunnbelopsDato(int grunnbelopsDato) {
        this.grunnbelopsDato = grunnbelopsDato;
    }

    public int getPoengtilleggsDato() {
        return poengtilleggsDato;
    }

    public void setPoengtilleggsDato(int poengtilleggsDato) {
        this.poengtilleggsDato = poengtilleggsDato;
    }

    public String getPoengtilleggsKode() {
        return poengtilleggsKode;
    }

    public void setPoengtilleggsKode(String poengtilleggsKode) {
        this.poengtilleggsKode = poengtilleggsKode;
    }

    public String getPensjonsrettFoer91() {
        return pensjonsrettFoer91;
    }

    public void setPensjonsrettFoer91(String pensjonsrettFoer91) {
        this.pensjonsrettFoer91 = pensjonsrettFoer91;
    }

    public int getTrygdetid1666() {
        return trygdetid1666;
    }

    public void setTrygdetid1666(int trygdetid1666) {
        this.trygdetid1666 = trygdetid1666;
    }

    public String getGarantertTilleggsPensjonKode() {
        return garantertTilleggsPensjonKode;
    }

    public void setGarantertTilleggsPensjonKode(String garantertTilleggsPensjonKode) {
        this.garantertTilleggsPensjonKode = garantertTilleggsPensjonKode;
    }

    public String getGammelSammenstotsRegel() {
        return gammelSammenstotsRegel;
    }

    public void setGammelSammenstotsRegel(String gammelSammenstotsRegel) {
        this.gammelSammenstotsRegel = gammelSammenstotsRegel;
    }


    public String getEktefelleInntektOver2g() {
        return ektefelleInntektOver2g;
    }

    public void setEktefelleInntektOver2g(String ektefelleInntektOver2g) {
        this.ektefelleInntektOver2g = ektefelleInntektOver2g;
    }

    public String getPensjonFoer9802() {
        return pensjonFoer9802;
    }

    public void setPensjonFoer9802(String pensjonFoer9802) {
        this.pensjonFoer9802 = pensjonFoer9802;
    }

    public String getRedGrunnPensjon321() {
        return redGrunnPensjon321;
    }

    public void setRedGrunnPensjon321(String redGrunnPensjon321) {
        this.redGrunnPensjon321 = redGrunnPensjon321;
    }

    public String getGrunnPensjonReduksjonsKode() {
        return grunnPensjonReduksjonsKode;
    }

    public void setGrunnPensjonReduksjonsKode(String grunnPensjonReduksjonsKode) {
        this.grunnPensjonReduksjonsKode = grunnPensjonReduksjonsKode;
    }

    public int getFriinntektDato() {
        return friinntektDato;
    }

    public void setFriinntektDato(int friinntektDato) {
        this.friinntektDato = friinntektDato;
    }

    public List<YrkesskadeHistorikk> getYrkesskadeHistorikker() {
        return yrkesskadeHistorikker;
    }

    public List<Yrkesskadepensjon> getYrkesskadepensjonerr() {
        return yrkesskadepensjonerr;
    }
}
