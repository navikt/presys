package no.nav.pensjon.presys.utils.ebcdic;

import no.nav.pensjon.dsf.domene.status.Status;
import no.nav.pensjon.dsf.domene.status.UforeHistorikk;
import no.nav.pensjon.dsf.domene.Uforegrad;

import java.math.BigDecimal;

public class TestStatus {

    Status s = new Status();

    public TestStatus(String type) {
        s.setStatusKode(type);
        s.setAntallBarn(0);
        s.setDodAvYrkesskade("");
        s.setDodsddato(0);
        s.setEktefelleInntektOver2g("N");
        s.setFoersteGangReg("");
        s.setFriinntektDato(0);
        s.setGammelSammenstotsRegel("");
        s.setGarantertTilleggsPensjonKode("");
        s.setGrunnbelopsDato(0);
        s.setGrunnPensjonReduksjonsKode("");
        s.setPensjonFoer9802("");
        s.setPensjonsrettFoer91("");
        s.setPensjonsType1("");
        s.setPensjonsType2("");
        s.setPensjonsType3("");
        s.setPoengtilleggsDato(0);
        s.setPoengtilleggsKode("");
        s.setRed_grunnPensjon_3_2_1("");
        s.setSivilstand("");
        s.setStatusKodeHistorie("");
        s.setSumYtelse(0);
        s.setTrygdetid16_66(0);
        s.setTrygdetid1967Til1970(0);
        s.setTrygdetidAnvendt(0);
        s.setTrygdetidEtter1966(0);
        s.setTrygdetidFoer1967(0);
        s.setTrygdetidFramTil(0);
        s.setTrygdetidGaranti(0);
        s.setVilkar8_4_3a("");
        s.setVirkDato(0);
    }

    public TestStatus withUforeHistorikk(){
        s.getUforehistorikk().add(uforehistorikk(19950200, 60));
        s.getUforehistorikk().add(uforehistorikk(19980500, 100));
        return this;
    }

    private static UforeHistorikk uforehistorikk(int maaned, int grad){
        UforeHistorikk uh = new UforeHistorikk();
        uh.setBup(BigDecimal.ZERO);
        uh.setBupGarantiKode("A");
        uh.setFoedselsaarYngsteBarn(0);
        uh.setOpphørsdatoMaaned(20120200);
        uh.setRedusertAntallBupAar(0);
        uh.setUfg(grad);
        uh.setUfKriterier(1);
        uh.setUftMaaned(maaned);
        uh.setVirkningsdatoUfrHistorie(2133);
        uh.setOpphørsKode("A");
        for(int i = 1; i * 20 < grad; i++)
            uh.getUforegrader().add(uforegrad(maaned + i * 10000 , grad - i*20));
        return uh;
    }

    private static Uforegrad uforegrad(int maaned, int grad){
        Uforegrad ug = new Uforegrad();
        ug.setUforegradDato(maaned);
        ug.setVirkningsdatoUforegrad(maaned);
        ug.setUforegradOvrige(grad);
        ug.setYngsteBarnFoerGrad(0);
        return ug;
    }

    public Status get(){
        return s;
    }

    static TestStatus createStatus(String type){
        return new TestStatus(type);
    }

}
