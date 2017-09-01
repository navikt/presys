package no.nav.pensjon.dsf.domene.grunnblanketter;

import no.nav.pensjon.presys.utils.ebcdic.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Segment(name = "TRANHIST", length = 38)
@UnmappedField(name = "filler", length = 3, start = 35)
public class TranHist {

    @Felt(name="vtpKey", length = 5, start = 0)
    @PackedDecimal
    private int vtpKey;

    @Felt(name="grblkode", length = 2, start = 5)
    private String grunnblankettkode;

    @Felt(name="prioritets_kode", length = 1, start = 7)
    private String prioritetskode;

    @Felt(name="virk_dato_åmd", length = 5, start = 8)
    @PackedDecimal
    private int virkningsdato;

    @Felt(name="regdato_åmd", length = 5, start = 13)
    @PackedDecimal
    private int registreringsdato;

    @Felt(name="tknr", length = 3, start = 18)
    @PackedDecimal
    private int trygdekontornummer;

    @Felt(name="sivilstand", length = 1, start = 21)
    private String sivilstand;

    @Felt(name="språk", length = 1, start = 22)
    private String spraak;

    @Felt(name="trans_returkode", length = 4, start = 23)
    private String transaksjonsreturkode;

    @Felt(name="termid", length = 4, start = 27)
    private String terminalId;

    @Felt(name="auto", length = 4, start = 31)
    private String autoTerminalId;

    @SubSegment
    private List<Grunnbup> grunnbuper = new ArrayList<>();

    @SubSegment
    private List<GRUNNBKF> grunnbkfer = new ArrayList<>();

    @SubSegment
    private List<GRUNNBU3> grunnbu3er = new ArrayList<>();

    @SubSegment
    private List<OPPHBL1> opphbl1er = new ArrayList<>();

    @SubSegment
    private List<OPPHBL2> opphbl2er = new ArrayList<>();

    @SubSegment
    private List<GRUNNBE3> grunnbe3er = new ArrayList<>();

    @SubSegment
    private List<ENBLAN1> enblan1er = new ArrayList<>();

    @SubSegment
    private List<GRUNNBIF> grunnbif = new ArrayList<>();

    @SubSegment
    private List<ENDRBLAN> endringsblankett = new ArrayList<>();

    @SubSegment
    private List<Barn> barn = new ArrayList<>();

    @SubSegment
    private List<GRUNNBAP> grunnbaper = new ArrayList<>();

    @SubSegment
    private List<GRUNNBA1> grunnba1er = new ArrayList<>();

    @SubSegment
    private List<GRUNNBAF> grunnbafer = new ArrayList<>();

    public int getVtpKey() {
        return vtpKey;
    }

    public void setVtpKey(int vtpKey) {
        this.vtpKey = vtpKey;
    }

    public String getGrunnblankettkode() {
        return grunnblankettkode;
    }

    public void setGrunnblankettkode(String grunnblankettkode) {
        this.grunnblankettkode = grunnblankettkode;
    }

    public String getPrioritetskode() {
        return prioritetskode;
    }

    public void setPrioritetskode(String prioritetskode) {
        this.prioritetskode = prioritetskode;
    }

    public int getVirkningsdato() {
        return virkningsdato;
    }

    public void setVirkningsdato(int virkningsdato) {
        this.virkningsdato = virkningsdato;
    }

    public int getRegistreringsdato() {
        return registreringsdato;
    }

    public void setRegistreringsdato(int registreringsdato) {
        this.registreringsdato = registreringsdato;
    }

    public int getTrygdekontornummer() {
        return trygdekontornummer;
    }

    public void setTrygdekontornummer(int trygdekontornummer) {
        this.trygdekontornummer = trygdekontornummer;
    }

    public String getSivilstand() {
        return sivilstand;
    }

    public void setSivilstand(String sivilstand) {
        this.sivilstand = sivilstand;
    }

    public String getSpraak() {
        return spraak;
    }

    public void setSpraak(String spraak) {
        this.spraak = spraak;
    }

    public String getTransaksjonsreturkode() {
        return transaksjonsreturkode;
    }

    public void setTransaksjonsreturkode(String transaksjonsreturkode) {
        this.transaksjonsreturkode = transaksjonsreturkode;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAutoTerminalId() {
        return autoTerminalId;
    }

    public void setAutoTerminalId(String autoTerminalId) {
        this.autoTerminalId = autoTerminalId;
    }

    public List<Grunnbup> getGrunnbuper() {
        return grunnbuper;
    }

    public List<GRUNNBKF> getGrunnbkfer() {
        return grunnbkfer;
    }

    public List<GRUNNBU3> getGrunnbu3er() {
        return grunnbu3er;
    }

    public List<OPPHBL1> getOpphbl1er() {
        return opphbl1er;
    }

    public List<OPPHBL2> getOpphbl2er() {
        return opphbl2er;
    }

    public List<GRUNNBE3> getGrunnbe3er() {
        return grunnbe3er;
    }

    public List<ENBLAN1> getEnblan1er() {
        return enblan1er;
    }

    public List<GRUNNBAP> getGrunnbaper() {
        return grunnbaper;
    }

    public List<GRUNNBA1> getGrunnba1er() {
        return grunnba1er;
    }

    public List<GRUNNBAF> getGrunnbafer() {
        return grunnbafer;
    }

    public List<GRUNNBIF> getGrunnbif() {
        return grunnbif;
    }

    public List<Barn> getBarn() {
        return barn;
    }

    public List<ENDRBLAN> getEndringsblankett() {
        return endringsblankett;
    }
}
