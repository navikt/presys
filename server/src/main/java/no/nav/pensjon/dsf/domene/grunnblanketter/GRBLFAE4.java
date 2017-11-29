package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "GRBLFAE4" , length = 30)
@UnmappedField(name = "filler", length = 2, start = 28)
public class GRBLFAE4 {

    @Felt(name ="NORSK_BOSATT", length = 1, start = 0) private String norskBosatt;
    @Felt(name ="FORVENTET_INNT", length = 3, start = 1) @PackedDecimal private int forventetInntekt;
    @Felt(name ="GP_OS_KODE", length = 1, start = 4) private String overgangsstonadPensjonKode;
    @Felt(name ="FRAMLEGGSDATO_AAMD", length = 5, start = 5) @PackedDecimal private int framleggsdato;
    @Felt(name ="FRAMLEGGSKODE", length = 1, start = 10) private String framleggskode;
    @Felt(name ="STATSBORGER", length = 2, start = 11) @PackedDecimal private int statsborgerskap;
    @Felt(name ="BOSATT", length = 2, start = 13) @PackedDecimal private int bosattLand;
    @Felt(name ="PENSJONSTRYGDET", length = 1, start = 15) private String pensjonstrygdet;
    @Felt(name ="MINST_20AAR", length = 1, start = 16) private String minst20Aar;
    @Felt(name ="FRAVIK_KONVENSJON", length = 1, start = 17) private String fravikKonvensjon;
    @Felt(name ="FRAVIK_FLYKTN", length = 1, start = 18) private String erFlyktning;
    @Felt(name ="TT_FRA_1937_AAR", length = 2, start = 19) @PackedDecimal private int trygdetidFra1937Aar;
    @Felt(name ="TT_FRA_1937_MND", length = 2, start = 21) @PackedDecimal private int trygdetidFra1937Maaned;
    @Felt(name ="TT_NORDEN_ANNET", length = 1, start = 23) private String trygdettidNordenAnnet;
    @Felt(name ="BEREGNING_KONVENSJON", length = 1, start = 24) private String beregningKonvensjon;
    @Felt(name ="TT_KONVENSJON_AAR", length = 2, start = 25) @PackedDecimal private int trygdetidKonvensjonAar;
    @Felt(name ="RED_GP_3_2_5", length = 1, start = 27) private String reduksjonGrunnpensjonPar3Pkt2Ledd5;

    public String getNorskBosatt() {
        return norskBosatt;
    }

    public void setNorskBosatt(String norskBosatt) {
        this.norskBosatt = norskBosatt;
    }

    public int getForventetInntekt() {
        return forventetInntekt;
    }

    public void setForventetInntekt(int forventetInntekt) {
        this.forventetInntekt = forventetInntekt;
    }

    public String getOvergangsstonadPensjonKode() {
        return overgangsstonadPensjonKode;
    }

    public void setOvergangsstonadPensjonKode(String overgangsstonadPensjonKode) {
        this.overgangsstonadPensjonKode = overgangsstonadPensjonKode;
    }

    public int getFramleggsdato() {
        return framleggsdato;
    }

    public void setFramleggsdato(int framleggsdato) {
        this.framleggsdato = framleggsdato;
    }

    public String getFramleggskode() {
        return framleggskode;
    }

    public void setFramleggskode(String framleggskode) {
        this.framleggskode = framleggskode;
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

    public String getPensjonstrygdet() {
        return pensjonstrygdet;
    }

    public void setPensjonstrygdet(String pensjonstrygdet) {
        this.pensjonstrygdet = pensjonstrygdet;
    }

    public String getMinst20Aar() {
        return minst20Aar;
    }

    public void setMinst20Aar(String minst20Aar) {
        this.minst20Aar = minst20Aar;
    }

    public String getFravikKonvensjon() {
        return fravikKonvensjon;
    }

    public void setFravikKonvensjon(String fravikKonvensjon) {
        this.fravikKonvensjon = fravikKonvensjon;
    }

    public String getErFlyktning() {
        return erFlyktning;
    }

    public void setErFlyktning(String erFlyktning) {
        this.erFlyktning = erFlyktning;
    }

    public int getTrygdetidFra1937Aar() {
        return trygdetidFra1937Aar;
    }

    public void setTrygdetidFra1937Aar(int trygdetidFra1937Aar) {
        this.trygdetidFra1937Aar = trygdetidFra1937Aar;
    }

    public int getTrygdetidFra1937Maaned() {
        return trygdetidFra1937Maaned;
    }

    public void setTrygdetidFra1937Maaned(int trygdetidFra1937Maaned) {
        this.trygdetidFra1937Maaned = trygdetidFra1937Maaned;
    }

    public String getTrygdettidNordenAnnet() {
        return trygdettidNordenAnnet;
    }

    public void setTrygdettidNordenAnnet(String trygdettidNordenAnnet) {
        this.trygdettidNordenAnnet = trygdettidNordenAnnet;
    }

    public String getBeregningKonvensjon() {
        return beregningKonvensjon;
    }

    public void setBeregningKonvensjon(String beregningKonvensjon) {
        this.beregningKonvensjon = beregningKonvensjon;
    }

    public int getTrygdetidKonvensjonAar() {
        return trygdetidKonvensjonAar;
    }

    public void setTrygdetidKonvensjonAar(int trygdetidKonvensjonAar) {
        this.trygdetidKonvensjonAar = trygdetidKonvensjonAar;
    }

    public String getReduksjonGrunnpensjonPar3Pkt2Ledd5() {
        return reduksjonGrunnpensjonPar3Pkt2Ledd5;
    }

    public void setReduksjonGrunnpensjonPar3Pkt2Ledd5(String reduksjonGrunnpensjonPar3Pkt2Ledd5) {
        this.reduksjonGrunnpensjonPar3Pkt2Ledd5 = reduksjonGrunnpensjonPar3Pkt2Ledd5;
    }
}
