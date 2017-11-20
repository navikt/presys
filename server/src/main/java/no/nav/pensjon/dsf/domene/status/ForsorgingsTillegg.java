package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

@UnmappedField(name ="GARANTITILLEGG_EK", length = 3, start = 0)
@UnmappedField(name ="GARANTITILLEGG_BARN", length = 3, start = 3)
@UnmappedField(name ="FT_SKAL_BEREGNES", length = 1, start = 6)
@UnmappedField(name ="ARBEIDSINNTEKT", length = 3, start = 7)
@UnmappedField(name ="PENSJONSINNTEKT", length = 3, start = 10)
@UnmappedField(name ="ARBEIDSINNTEKT_EK", length = 3, start = 13)
@UnmappedField(name ="PENSJONSINNTEKT_EK", length = 3, start = 16)
@UnmappedField(name ="BT_SÆRBARN", length = 3, start = 19)
@UnmappedField(name ="GARANTITILLEGG_SÆRBARN", length = 3, start = 22)
@UnmappedField(name ="FILLER", length = 9, start = 25)
@Segment(name = "FORSI", length = 34)
public class ForsorgingsTillegg {

    //ingenting skal vises av dette segmentet.
}
