package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Person;

import java.util.function.BiConsumer;

import static no.nav.pensjon.dsf.ebcdic.felter.Characters.plaintext;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.pakketHeltall;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.pakketTekst;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.pakketZeroFilled;
import static no.nav.pensjon.dsf.ebcdic.felter.SegmentNavnFelt.segmentNavn;

public class RF0PersonSegment extends  Segment<Person> {

    public RF0PersonSegment() {
        super("RF0PERSN", Person::new);
        BiConsumer<Person, String> settesIkke = (person, verdi)-> {}; //Brukes for felter som ikke skal settes på domeneobjektet

        getFelter().add(plaintext("start", 6, settesIkke ));
        getFelter().add(segmentNavn());
        getFelter().add(plaintext("ukjent1", 21, settesIkke ));
        getFelter().add(pakketZeroFilled("fnr", 6, 11, Person::setFnr));
        getFelter().add(plaintext("navn", 25, Person::setNavn));
        getFelter().add(pakketTekst("tknr", 3, 5, settesIkke));
        getFelter().add(plaintext("spraak", 1, settesIkke));
        getFelter().add(pakketHeltall("AI67", 3, 5, Person::setAi67)); //ANTATT INNTEKT I 1967, IKKE DET SAMME SOM PGI DETTE ÅRET.
        getFelter().add(plaintext("SPERRE", 1, settesIkke));
        getFelter().add(pakketTekst("SB_DATO_ÅMD", 5, 9, settesIkke)); //SISTE STØNADSBREV DATO
        getFelter().add(plaintext("PI_66_65", 1, settesIkke)); //1 karakter i Rotsegment.  J = inntekt i 66. år skal sette lik inntekt i 65. år frem til P70.
        getFelter().add(plaintext("EØS_GARANTI", 1, settesIkke)); //Litt usikker på om dette er i bruk…, evnt kun en kode A,B,eller C
        getFelter().add(plaintext("BRUKER_ID", 8, settesIkke)); //BRUKERIDENT FOR DEN SOM SIST VAR INNE OG REGISTRERTE PÅ DENNE PERSONEN
        getFelter().add(plaintext("PERSN_KODE", 1, settesIkke)); //KODE FOR SKJERMET PERSONER (KODE 6/7/EGNE ANSATTE)
        getFelter().add(plaintext("filler", 3, settesIkke));
        getFelter().add(plaintext("Jeg veit ikke hvorfor denne må være her", 1, settesIkke ));
    }

    @Override
    public Undersegment<?>[] getUnderSegmentTyper(Person domene) {
        Undersegment<?>[] undersegmenter ={Undersegment.of(new PinntektSegment(), domene.getInntekter()::add)};
        return undersegmenter;

    }


}
