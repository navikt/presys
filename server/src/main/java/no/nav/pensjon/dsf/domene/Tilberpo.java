package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

/**
 * ÅR HVOR HAN HAR AVTJENT VERNEPLIKTIG FRSTEGANGSTJENESTE
 * SAMT INNTEKTER I ÅR FØR LOVENS IKRAFTTREDEN
 */
@Segment(name = "TILBERPO", length = 28)
@UnmappedField(name = "filler", start = 27, length = 1)
public class Tilberpo {
    /**
     * FØRSTE ÅR HVOR VERNEPLIKT ER UTFØRT
     */
    @Felt(name = "vernepliktaar1", start = 0, length = 3)
    @PackedDecimal
    private int vernepliktaar1;

    /**
     * ANDRE ÅR HVOR VERNEPLIKT ER UTFØRT
     */
    @Felt(name = "vernepliktaar2", start = 3, length = 3)
    @PackedDecimal
    private int vernepliktaar2;

    /**
     * TREDJE ÅR HVOR VERNEPLIKT ER UTFØRT
     */
    @Felt(name = "vernepliktaar3", start = 6, length = 3)
    @PackedDecimal
    private int vernepliktaar3;

    /**
     * FJERDE ÅR HVOR VERNEPLIKT ER UTFØRT
     */
    @Felt(name = "vernepliktaar4", start = 9, length = 3)
    @PackedDecimal
    private int vernepliktaar4;

    /**
     * AI xx  INNTEKTER,  ER INNTEKTER SOM BRUKES FOR Å BEREGNE UFØREPENSJON TIL DE SOM BLE UFØRE FØR 1970. 5 siffer, hele hundre kroner
     */
    @Felt(name = "ai63", start = 12, length = 3)
    @PackedDecimal
    private int ai63;

    /**
     * AI xx  INNTEKTER,  ER INNTEKTER SOM BRUKES FOR Å BEREGNE UFØREPENSJON TIL DE SOM BLE UFØRE FØR 1970. 5 siffer, hele hundre kroner
     */
    @Felt(name = "ai64", start = 15, length = 3)
    @PackedDecimal
    private int ai64;

    /**
     * AI xx  INNTEKTER,  ER INNTEKTER SOM BRUKES FOR Å BEREGNE UFØREPENSJON TIL DE SOM BLE UFØRE FØR 1970. 5 siffer, hele hundre kroner
     */
    @Felt(name = "ai65", start = 18, length = 3)
    @PackedDecimal
    private int ai65;

    /**
     * AI xx  INNTEKTER,  ER INNTEKTER SOM BRUKES FOR Å BEREGNE UFØREPENSJON TIL DE SOM BLE UFØRE FØR 1970. 5 siffer, hele hundre kroner
     */
    @Felt(name = "ai66", start = 21, length = 3)
    @PackedDecimal
    private int ai66;

    /**
     * Pensjonsgivende inntekt i 1966
     */
    @Felt(name = "pi66", start = 24, length = 3)
    @PackedDecimal
    private int pi66;

    public int getVernepliktaar1() { return vernepliktaar1; }

    public void setVernepliktaar1(int vernepliktaar1) { this.vernepliktaar1 = vernepliktaar1; }

    public int getVernepliktaar2() { return vernepliktaar2; }

    public void setVernepliktaar2(int vernepliktaar2) { this.vernepliktaar2 = vernepliktaar2; }

    public int getVernepliktaar3() { return vernepliktaar3; }

    public void setVernepliktaar3(int vernepliktaar3) { this.vernepliktaar3 = vernepliktaar3; }

    public int getVernepliktaar4() { return vernepliktaar4; }

    public void setVernepliktaar4(int vernepliktaar4) { this.vernepliktaar4 = vernepliktaar4; }

    public int getAi63() { return ai63; }

    public void setAi63(int ai63) { this.ai63 = ai63; }

    public int getAi64() { return ai64; }

    public void setAi64(int ai64) { this.ai64 = ai64; }

    public int getAi65() { return ai65; }

    public void setAi65(int ai65) { this.ai65 = ai65; }

    public int getAi66() { return ai66; }

    public void setAi66(int ai66) { this.ai66 = ai66; }

    public int getPi66() { return pi66; }

    public void setPi66(int pi66) { this.pi66 = pi66; }
}
