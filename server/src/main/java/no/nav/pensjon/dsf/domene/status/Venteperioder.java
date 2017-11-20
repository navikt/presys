package no.nav.pensjon.dsf.domene.status;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.UnmappedField;

/**
 * Venteperioder for alderspensjon, gamle regler
 */
@Segment(name = "VENTØVR", length = 7)
@UnmappedField(name = "UTTAKSDATO_ÅMD_ØVRIGE", start = 0, length = 5)   // Uttaksdato for alderspensjon ved gradsendring. Tidligere kunne man ta ut 25,50,75 eller 100 prosent aldersepensjon. Dersom du tok ut mindre enn hundre prosent, fikk du utbetalt et ventetillegg til alderspensjonen.Derfor måtte vi ha en tabell slik at vi kunne regne ut riktig "vente faktor". Tabell innholder uttaksdaot og grad.
@UnmappedField(name = "APD_ØVRIGE", start = 5, length = 2)  // Alderspensjons del som tas ut. Se forklaring over.
public class Venteperioder {
}
