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

    public String getBosattUtland() {
        return bosattUtland;
    }

    public int getTrygdetidFor1967Ektefelle() {
        return trygdetidFor1967Ektefelle;
    }

    public int getTrygdetidEtter1966EktefelleAar() {
        return trygdetidEtter1966EktefelleAar;
    }

    public int getTrygdetidEtter1966EktefelleMaaneder() {
        return trygdetidEtter1966EktefelleMaaneder;
    }

    public int getAntallBarnetillegg() {
        return antallBarnetillegg;
    }

    public int getFodselsnummerEktefelle() {
        return fodselsnummerEktefelle;
    }

    public String getNavnEktefelle() {
        return navnEktefelle;
    }

    public String getEktefellesInntektOver4G() {
        return ektefellesInntektOver4G;
    }
}
