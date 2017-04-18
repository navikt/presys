package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.ebcdic.EbcdicUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by d132988 on 11.04.2017.
 */
public abstract class Segment<DomeneKlasse> {

    public abstract String getNavn();

    public abstract  List<Felt<DomeneKlasse>> getFelter() ;

    public abstract DomeneKlasse initDomene();

    public DomeneKlasse readSegment(byte[] data){
        int position = 0;
        DomeneKlasse domene = initDomene();
        for(Felt f : getFelter()){
            byte[] feltBytes = Arrays.copyOfRange(data, position,f.getByteLength() + position);
            f.setVerdiPaaDomene(domene, feltBytes);
            position += f.getByteLength();
        }

        return domene;
    }


}
