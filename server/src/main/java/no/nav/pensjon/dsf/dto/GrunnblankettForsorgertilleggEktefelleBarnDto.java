package no.nav.pensjon.dsf.dto;

public class GrunnblankettForsorgertilleggEktefelleBarnDto extends GrunnblankettDto {

    private String ektefelleTillegg;
    private String bosattUtland;
    private int trygdetidFor1967Ektefelle;
    private int  trygdetidEtter1966EktefelleAar;
    private int  trygdetidEtter1966EktefelleMaaneder;
    private int  antallBarnetillegg;
    private int  fodselsnummerEktefelle;
    private String navnEktefelle;
    private String ektefellesInntektOver4G;

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
