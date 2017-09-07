package no.nav.pensjon.dsf.dto;

public class GrunnstonadHjelpestonadDto extends GrunnblankettDto {

    private String grunnstonadSats;
    private String grunnstonadKode1;
    private String grunnstonadKode2;
    private String grunnstonadKode3;
    private String hsuSats;
    private String hsuKode;
    private String grunnstonadPrimaerdiagnose;
    private String grunnstonadSekundaerdiagnose;
    private int statsborgerskap;
    private int bosattLand;

    public String getGrunnstonadSats() {
        return grunnstonadSats;
    }

    public void setGrunnstonadSats(String grunnstonadSats) {
        this.grunnstonadSats = grunnstonadSats;
    }

    public String getGrunnstonadKode1() {
        return grunnstonadKode1;
    }

    public void setGrunnstonadKode1(String grunnstonadKode1) {
        this.grunnstonadKode1 = grunnstonadKode1;
    }

    public String getGrunnstonadKode2() {
        return grunnstonadKode2;
    }

    public void setGrunnstonadKode2(String grunnstonadKode2) {
        this.grunnstonadKode2 = grunnstonadKode2;
    }

    public String getGrunnstonadKode3() {
        return grunnstonadKode3;
    }

    public void setGrunnstonadKode3(String grunnstonadKode3) {
        this.grunnstonadKode3 = grunnstonadKode3;
    }

    public String getHsuSats() {
        return hsuSats;
    }

    public void setHsuSats(String hsuSats) {
        this.hsuSats = hsuSats;
    }

    public String getHsuKode() {
        return hsuKode;
    }

    public void setHsuKode(String hsuKode) {
        this.hsuKode = hsuKode;
    }

    public String getGrunnstonadPrimaerdiagnose() {
        return grunnstonadPrimaerdiagnose;
    }

    public void setGrunnstonadPrimaerdiagnose(String grunnstonadPrimaerdiagnose) {
        this.grunnstonadPrimaerdiagnose = grunnstonadPrimaerdiagnose;
    }

    public String getGrunnstonadSekundaerdiagnose() {
        return grunnstonadSekundaerdiagnose;
    }

    public void setGrunnstonadSekundaerdiagnose(String grunnstonadSekundaerdiagnose) {
        this.grunnstonadSekundaerdiagnose = grunnstonadSekundaerdiagnose;
    }

    public int getStatsborgerskap() {
        return statsborgerskap;
    }

    public void setStatsborgerskap(int statsborgerskap) {
        this.statsborgerskap = statsborgerskap;
    }

    public int getBosattLand() {
        return bosattLand;
    }

    public void setBosattLand(int bosattLand) {
        this.bosattLand = bosattLand;
    }
}
