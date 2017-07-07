package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@Segment(name = "ETTEBARN", length = 50)
@UnmappedField(name = "spt1291Mor", start = 25, length = 2)
@UnmappedField(name = "opt1291Mor", start = 27, length = 2)
@UnmappedField(name = "paa1291Mor", start = 29, length = 2)
@UnmappedField(name = "paaEtter91Mor", start = 31, length = 2)
@UnmappedField(name = "spt1291Far", start = 33, length = 2)
@UnmappedField(name = "opt1291Far", start = 35, length = 2)
@UnmappedField(name = "paa1291Far", start = 37, length = 2)
@UnmappedField(name = "paaEtter91Far", start = 39, length = 2)
@UnmappedField(name = "filler", start = 41, length = 9)
public class EtterlattBarn {

    @Felt(name = "pensjonEtter", start = 0, length = 1)
    private String pensjonEtter;

    @Felt(name = "gp", start = 1, length = 3)
    @PackedDecimal
    private int gp;

    @Felt(name = "tp", start = 4, length = 3)
    @PackedDecimal
    private int tp;

    @Felt(name = "st", start = 7, length = 3)
    @PackedDecimal
    private int st;

    @Felt(name = "kt", start = 10, length = 3)
    @PackedDecimal
    private int kt;

    @Felt(name = "sptMor", start = 13, length = 2)
    @PackedDecimal(decimals = 2)
    private String sptMor;

    @Felt(name = "optMor", start = 15, length = 2)
    @PackedDecimal(decimals = 2)
    private String optMor;

    @Felt(name = "paaMor", start = 17, length = 2)
    @PackedDecimal
    private int paaMor;

    @Felt(name = "sptFar", start = 19, length = 2)
    @PackedDecimal(decimals = 2)
    private String sptFar;

    @Felt(name = "optFar", start = 21, length = 2)
    @PackedDecimal(decimals = 2)
    private String optFar;

    @Felt(name = "paaFar", start = 23, length = 2)
    @PackedDecimal
    private int paaFar;

    public String getPensjonEtter() { return pensjonEtter; }

    public void setPensjonEtter(String pensjonEtter) { this.pensjonEtter = pensjonEtter; }

    public int getGp() { return gp; }

    public void setGp( int gp) { this.gp = gp; }

    public int getTp() { return tp; }

    public void setTp(int tp) { this.tp = tp; }

    public int getSt() { return st; }

    public void setSt(int st) { this.st = st; }

    public int getKt() { return kt; }

    public void setKt(int kt) { this.kt = kt; }

    public String getSptMor() { return sptMor; }

    public void setSptMor(String sptMor) { this.sptMor = sptMor; }

    public String getOptMor() { return optMor; }

    public void setOptMor(String optMor) { this.optMor = optMor; }

    public int getPaaMor() { return paaMor; }

    public void setPaaMor(int paaMor) { this.paaMor = paaMor; }

    public String getSptFar() { return sptFar; }

    public void setSptFar(String sptFar) { this.sptFar = sptFar; }

    public String getOptFar() { return optFar; }

    public void setOptFar(String optFar) { this.optFar = optFar; }

    public int getPaaFar() { return paaFar; }

    public void setPaaFar(int paaFar) { this.paaFar = paaFar; }
}
