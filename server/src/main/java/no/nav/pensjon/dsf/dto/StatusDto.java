package no.nav.pensjon.dsf.dto;

import java.util.ArrayList;
import java.util.List;

public class StatusDto {
    private int virkDato;
    private String statusKode;
    private String statusKodeHistorie;
    private String pensjonsType1;
    private String pensjonsType2;
    private String pensjonsType3;

    private String sivilstand;

    private int trygdetidFoer1967;

    private int trygdetidEtter1966;

    private int trygdetidFramTil;

    private int trygdetid1967Til1970;

    private int trygdetidAnvendt;
    private String foersteGangReg;

    private int sumYtelse;

    private int antallBarn;

    private int dodsddato;
    private String dodAvYrkesskade;
    private String vilkar843A;

    private int trygdetidGaranti;

    private int grunnbelopsDato;

    private int poengtilleggsDato;
    private String poengtilleggsKode;
    private String pensjonsrettFoer91;

    private int trygdetid1666;
    private String garantertTilleggsPensjonKode;
    private String gammelSammenstotsRegel;

    private String ektefelleInntektOver2g;
    private String pensjonFoer9802;
    private String redGrunnPensjon321;

    private String grunnPensjonReduksjonsKode;

    private int friinntektDato;

    private List<UforeHistorikkDto> uforehistorikk = new ArrayList<>();

    private List<AfpHistorikkDto> afpHistorikk = new ArrayList<>();

    private List<EosInfoDto> eosInfo = new ArrayList<>();

    private List<SpesielleOpplysningerDto> spesielleOpplysninger = new ArrayList<>();

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

    public String getPensjonsType2() {
        return pensjonsType2;
    }

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

    public List<UforeHistorikkDto> getUforehistorikk() {
        return uforehistorikk;
    }

    public void setUforehistorikk(List<UforeHistorikkDto> uforehistorikk) {
        this.uforehistorikk = uforehistorikk;
    }

    public List<AfpHistorikkDto> getAfpHistorikk() {
        return afpHistorikk;
    }

    public void setAfpHistorikk(List<AfpHistorikkDto> afpHistorikk) {
        this.afpHistorikk = afpHistorikk;
    }

    public List<EosInfoDto> getEosInfo() {
        return eosInfo;
    }

    public void setEosInfo(List<EosInfoDto> eosInfo) {
        this.eosInfo = eosInfo;
    }

    public List<SpesielleOpplysningerDto> getSpesielleOpplysninger() {
        return spesielleOpplysninger;
    }

    public void setSpesielleOpplysninger(List<SpesielleOpplysningerDto> spesielleOpplysninger) {
        this.spesielleOpplysninger = spesielleOpplysninger;
    }
}
