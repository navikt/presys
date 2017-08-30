package no.nav.pensjon.dsf.dto;

public class GrunnstonadHjelpestonadDto extends GrunnblankettDto {

    private String grunnstonadSats;
    private String grunnstonadKode1;
    private String grunnstonadKode2;
    private String grunnstonadKode3;
    private String hsuSats;
    private String hsuKode;
    private int statsborgerskap;
    private int bosattLand;

    public String getGrunnstonadSats() {
        return grunnstonadSats;
    }

    public String getGrunnstonadKode1() {
        return grunnstonadKode1;
    }

    public String getGrunnstonadKode2() {
        return grunnstonadKode2;
    }

    public String getGrunnstonadKode3() {
        return grunnstonadKode3;
    }

    public String getHsuSats() {
        return hsuSats;
    }

    public String getHsuKode() {
        return hsuKode;
    }

    public int getStatsborgerskap() {
        return statsborgerskap;
    }

    public int getBosattLand() {
        return bosattLand;
    }
}
