package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRBLFORS", length = 46)
@UnmappedField(name = "filler", length = 4, start = 42)
public class GRBLFORS {

    @Felt(name="EKTEFELLE_TILL", length = 1, start = 0) private String ektefelleTillegg;
    @Felt(name="BOSATT_UTL", length = 1, start = 1) private String bosattUtland;
    @Felt(name="TT_FOR_1967_EK", length = 2, start = 2) @PackedDecimal private int trygdetidFor1967Ektefelle;
    @Felt(name="TT_ETTER_1966_EK_AAR", length = 2, start = 4) @PackedDecimal private int  trygdetidEtter1966EktefelleAar;
    @Felt(name="TT_ETTER_1966_EK_MM", length = 2, start = 6) @PackedDecimal private int  trygdetidEtter1966EktefelleMaaneder;
    @Felt(name="BT_ANT", length = 2, start = 8) @PackedDecimal private int  antallBarnetillegg;
    @Felt(name="FNR_EK", length = 6, start = 10) @PackedDecimal private int  fodselsnummerEktefelle;
    @Felt(name="NAVN_EK", length = 25, start = 16) private String navnEktefelle;
    @Felt(name="INNT_MINST_4G", length = 1, start = 41) private String ektefellesInntektOver4G;

    public String getEktefelleTillegg() {
        return ektefelleTillegg;
    }

    public void setEktefelleTillegg(String ektefelleTillegg) {
        this.ektefelleTillegg = ektefelleTillegg;
    }

    public String getBosattUtland() {
        return bosattUtland;
    }

    public void setBosattUtland(String bosattUtland) {
        this.bosattUtland = bosattUtland;
    }

    public int getTrygdetidFor1967Ektefelle() {
        return trygdetidFor1967Ektefelle;
    }

    public void setTrygdetidFor1967Ektefelle(int trygdetidFor1967Ektefelle) {
        this.trygdetidFor1967Ektefelle = trygdetidFor1967Ektefelle;
    }

    public int getTrygdetidEtter1966EktefelleAar() {
        return trygdetidEtter1966EktefelleAar;
    }

    public void setTrygdetidEtter1966EktefelleAar(int trygdetidEtter1966EktefelleAar) {
        this.trygdetidEtter1966EktefelleAar = trygdetidEtter1966EktefelleAar;
    }

    public int getTrygdetidEtter1966EktefelleMaaneder() {
        return trygdetidEtter1966EktefelleMaaneder;
    }

    public void setTrygdetidEtter1966EktefelleMaaneder(int trygdetidEtter1966EktefelleMaaneder) {
        this.trygdetidEtter1966EktefelleMaaneder = trygdetidEtter1966EktefelleMaaneder;
    }

    public int getAntallBarnetillegg() {
        return antallBarnetillegg;
    }

    public void setAntallBarnetillegg(int antallBarnetillegg) {
        this.antallBarnetillegg = antallBarnetillegg;
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

    public String getEktefellesInntektOver4G() {
        return ektefellesInntektOver4G;
    }

    public void setEktefellesInntektOver4G(String ektefellesInntektOver4G) {
        this.ektefellesInntektOver4G = ektefellesInntektOver4G;
    }
}
