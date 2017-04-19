package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.ebcdic.ScrollableArray;
import no.nav.pensjon.dsf.ebcdic.felter.Felt;
import no.nav.pensjon.dsf.ebcdic.felter.SegmentNavnFelt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


public abstract class Segment<DomeneKlasse> {
    private List<Felt<DomeneKlasse>> felter = new ArrayList<>();
    private String navn;
    private Supplier<DomeneKlasse> domeneCreator;

    public Segment(String navn, Supplier<DomeneKlasse> domeneCreator) {
        this.domeneCreator = domeneCreator;
        this.navn = navn;
    }

    public List<Felt<DomeneKlasse>> getFelter(){
        return  felter;
    }

    public String getNavn() {
        return navn;
    }

    public void lesBarn(ScrollableArray data, DomeneKlasse domene){
        Undersegment<?>[]undersegmenter = getUnderSegmentTyper(domene);
        Optional<Undersegment<?>> o;
        try {
            while ((o =  Arrays.stream(undersegmenter).filter(s->s.accept(data)).findAny()).isPresent()) {
                o.ifPresent(us->us.read(data));
            }
        }catch(ArrayIndexOutOfBoundsException ex){}
    }

    public Undersegment<?>[] getUnderSegmentTyper(DomeneKlasse domene) {
        return new Undersegment<?>[0]; //ingen undersegment
    }

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
        DomeneKlasse domene = domeneCreator.get();
        for(Felt f : getFelter()){
            f.setVerdiPaaDomene(domene, data.read(f.getByteLength()));
        }
        lesBarn(data, domene);
        return domene;
    }




}
