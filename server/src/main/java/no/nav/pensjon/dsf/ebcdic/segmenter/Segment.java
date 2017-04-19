package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.ebcdic.ScrollableArray;

import java.util.List;


public abstract class Segment<DomeneKlasse> {

    public abstract String getNavn();

    public abstract  List<Felt<DomeneKlasse>> getFelter();


    public abstract DomeneKlasse initDomene();

    public boolean accept(ScrollableArray data){
        int position = 0;
        for(Felt f : getFelter()){
            if(SegmentNavnFelt.NAVN.equals(f.getFeltNavn())){
                return f.parse(data.peekAhead(position, f.getByteLength())).equals(getNavn());
            }
            position += f.getByteLength();
        }
        return false;
    }

    public DomeneKlasse readSegment(ScrollableArray data){
        DomeneKlasse domene = initDomene();
        for(Felt f : getFelter()){
            f.setVerdiPaaDomene(domene, data.read(f.getByteLength()));
        }

        return domene;
    }




}
