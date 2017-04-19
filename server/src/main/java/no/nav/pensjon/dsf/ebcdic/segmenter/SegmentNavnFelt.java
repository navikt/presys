package no.nav.pensjon.dsf.ebcdic.segmenter;

/**
 * Created by d132988 on 19.04.2017.
 */
public class SegmentNavnFelt<DomeneKlasse> extends Characters<DomeneKlasse>{

    public static final String NAVN = "segmentNavn";

    public SegmentNavnFelt() {
        super(NAVN, 8, (domeneklasse, verdi)-> {});
    }

    public static <Domeneklasse> SegmentNavnFelt<Domeneklasse> segmentNavn (){
        return new SegmentNavnFelt<>();
    }}
