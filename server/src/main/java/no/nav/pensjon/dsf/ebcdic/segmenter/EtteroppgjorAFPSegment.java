package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.EtteroppgjorAFP;
import java.util.function.BiConsumer;

import static no.nav.pensjon.dsf.ebcdic.felter.Characters.filler;
import static no.nav.pensjon.dsf.ebcdic.felter.Characters.plaintext;
import static no.nav.pensjon.dsf.ebcdic.felter.PackedDecimal.pakketHeltall;
import static no.nav.pensjon.dsf.ebcdic.felter.SegmentNavnFelt.segmentNavn;

/**
 * Created by h141598 on 19.04.2017.
 */
public class EtteroppgjorAFPSegment extends Segment<EtteroppgjorAFP> {


     EtteroppgjorAFPSegment() {
         super("EOAFP   ", EtteroppgjorAFP::new);

         BiConsumer<EtteroppgjorAFP, String> settesIkke = (etteroppgjorAFP, verdi) -> {
         }; //Brukes for felter som ikke skal settes på domeneobjektet

        getFelter().add(filler("start", 6));
        getFelter().add(segmentNavn(this));
        getFelter().add(filler("ukjent1", 21 ));
        getFelter().add(pakketHeltall("INNTEKTSÅR",3,5, EtteroppgjorAFP::setInntektsAar, EtteroppgjorAFP::getInntektsAar));
        getFelter().add(pakketHeltall("PGI",5,9, EtteroppgjorAFP::setPensjonsgivendeInntekt, EtteroppgjorAFP::getPensjonsgivendeInntekt));
        getFelter().add(pakketHeltall("IFU", 5,9,EtteroppgjorAFP::setInntektForUttakAvAFP, EtteroppgjorAFP::getInntektForUttakAvAFP));
        getFelter().add(plaintext("IFU_merke",1, EtteroppgjorAFP::setRegistertViaDSFEllerInfotrygdIFU, EtteroppgjorAFP::getRegistertViaDSFEllerInfotrygdIFU));
        getFelter().add(pakketHeltall("IEO", 5,9, EtteroppgjorAFP::setInntektEtterOpphor, EtteroppgjorAFP::getInntektEtterOpphor));
        getFelter().add(plaintext("IEO_merke", 1, EtteroppgjorAFP::setRegistertViaDSFEllerInfotrygdIEO, EtteroppgjorAFP::getRegistertViaDSFEllerInfotrygdIEO));
        getFelter().add(pakketHeltall("IIAP", 5, 9, EtteroppgjorAFP::setInntektIAFPPerioden, EtteroppgjorAFP::getInntektIAFPPerioden));
        getFelter().add(plaintext("IIAP_merke", 1, EtteroppgjorAFP::setBeregnetEllerRegistrertViaInfotrygd, EtteroppgjorAFP::getBeregnetEllerRegistrertViaInfotrygd));
        getFelter().add(pakketHeltall("FAIP", 4,7, EtteroppgjorAFP::setOppgittFramtidigInntekt, EtteroppgjorAFP::getOppgittFramtidigInntekt));
        getFelter().add(pakketHeltall("TEI_IAP", 4, 7, EtteroppgjorAFP::setTidligereInntekt, EtteroppgjorAFP::getTidligereInntekt));
        getFelter().add(pakketHeltall("PFP", 4,7, EtteroppgjorAFP::setFullAFPiAvregningsperioden, EtteroppgjorAFP::getFullAFPiAvregningsperioden));
        getFelter().add(pakketHeltall("FPFP", 4, 7, EtteroppgjorAFP::setFaktiskUtbetalt, EtteroppgjorAFP::getFaktiskUtbetalt));
        getFelter().add(pakketHeltall("DFMU", 4, 7, EtteroppgjorAFP::setDifferanseForMyeUtbetalt, EtteroppgjorAFP::getDifferanseForMyeUtbetalt));
        getFelter().add(pakketHeltall("DFLU", 4, 7, EtteroppgjorAFP::setDifferanseForLiteUtbetalt, EtteroppgjorAFP::getDifferanseForLiteUtbetalt));
        getFelter().add(plaintext("FILLER", 10, EtteroppgjorAFP::setFiller, EtteroppgjorAFP::getFiller));
        getFelter().add(filler("Jeg veit ikke hvorfor denne må være her", 1 ));

     }

}
