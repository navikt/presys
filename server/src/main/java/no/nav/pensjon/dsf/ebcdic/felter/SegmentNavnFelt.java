package no.nav.pensjon.dsf.ebcdic.felter;

import no.nav.pensjon.dsf.ebcdic.EbcdicUtils;
import no.nav.pensjon.dsf.ebcdic.segmenter.Segment;

import java.io.IOException;


/**
 * Created by d132988 on 19.04.2017.
 */
public class SegmentNavnFelt<DomeneKlasse> extends Characters<DomeneKlasse>{

    public static final String NAVN = "segmentNavn";

    public SegmentNavnFelt(String navn) {
        super(NAVN, 8, (domeneklasse, verdi)-> {}, (d, os) -> {
            try {
                os.write(navn.getBytes(EbcdicUtils.EBCDIC_CHARSET));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static <Domeneklasse> SegmentNavnFelt<Domeneklasse> segmentNavn (Segment segment){
        return new SegmentNavnFelt<>(segment.getNavn());
    }}
