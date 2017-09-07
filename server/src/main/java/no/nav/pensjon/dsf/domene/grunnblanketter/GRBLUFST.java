package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRBLUFST", length = 28)
@UnmappedField(name = "filler", length = 5, start = 23)
public class GRBLUFST {

    @Felt(name="GS_SATS", length = 1, start = 0) private String grunnstonadSats;
    @Felt(name="GS_KODE1", length = 1, start = 1) private String grunnstonadKode1;
    @Felt(name="GS_KODE3", length = 1, start = 2) private String grunnstonadKode2;
    @Felt(name="GS_KODE3", length = 1, start = 3) private String grunnstonadKode3;
    @Felt(name="HSU_SATS", length = 1, start = 4) private String hsuSats;
    @Felt(name="HSU_KODE", length = 2, start = 5) private String hsuKode;
    @Felt(name="GS_PRIMDIAG", length = 6, start = 7) private String grunnstonadPrimaerdiagnose;
    @Felt(name="HSU_PRIMDIAG", length = 6, start = 13) private String grunnstonadSekundaerdiagnose;
    @Felt(name="STATSBORGER", length = 2, start = 19) @PackedDecimal private int statsborgerskap;
    @Felt(name="BOSATT", length = 2, start = 21) @PackedDecimal private int bosattLand;

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
