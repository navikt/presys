package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Person;

import java.util.function.BiConsumer;

import static no.nav.pensjon.dsf.ebcdic.felter.Characters.filler;
import static no.nav.pensjon.dsf.ebcdic.felter.Characters.plaintext;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.*;
import static no.nav.pensjon.dsf.ebcdic.felter.SegmentNavnFelt.segmentNavn;

public class RF0PersonSegment extends  Segment<Person> {

    public RF0PersonSegment() {
        super("RF0PERSN", Person::new);
        BiConsumer<Person, String> settesIkke = (person, verdi)-> {}; //Brukes for felter som ikke skal settes på domeneobjektet

        getFelter().add(filler("start", 6));
        getFelter().add(segmentNavn(this));
        getFelter().add(filler("ukjent1", 21 ));
        getFelter().add(pakketZeroFilled("fnr", 6, 11, Person::setFnr, Person::getFnr));
        getFelter().add(plaintext("navn", 25, Person::setNavn, Person::getNavn));
        getFelter().add(pakketFiller("tknr", 3, 5));
        getFelter().add(filler("spraak", 1));
        getFelter().add(pakketHeltall("AI67", 3, 5, Person::setAi67, Person::getAi67)); //ANTATT INNTEKT I 1967, IKKE DET SAMME SOM PGI DETTE ÅRET.
        getFelter().add(filler("SPERRE", 1));
        getFelter().add(pakketFiller("SB_DATO_ÅMD", 5, 9)); //SISTE STØNADSBREV DATO
        getFelter().add(filler("PI_66_65", 1)); //1 karakter i Rotsegment.  J = inntekt i 66. år skal sette lik inntekt i 65. år frem til P70.
        getFelter().add(filler("EØS_GARANTI", 1)); //Litt usikker på om dette er i bruk…, evnt kun en kode A,B,eller C
        getFelter().add(filler("BRUKER_ID", 8)); //BRUKERIDENT FOR DEN SOM SIST VAR INNE OG REGISTRERTE PÅ DENNE PERSONEN
        getFelter().add(filler("PERSN_KODE", 1)); //KODE FOR SKJERMET PERSONER (KODE 6/7/EGNE ANSATTE)
        getFelter().add(filler("filler", 3));
        getFelter().add(filler("Jeg veit ikke hvorfor denne må være her", 1 ));
    }

    @Override
    public Undersegment<?>[] getUnderSegmentTyper(Person domene) {
        Undersegment<?>[] undersegmenter ={Undersegment.ofList(new PinntektSegment(),domene.getInntekter()::add, ()->domene.getInntekter()) };
        return undersegmenter;

    }

}
