package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.ebcdic.ScrollableArray;
import no.nav.pensjon.dsf.ebcdic.felter.Felt;
import no.nav.pensjon.dsf.ebcdic.felter.SegmentNavnFelt;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;


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

        try {
            Optional<Undersegment<?>> o;
            do {
                o = Arrays.stream(undersegmenter).filter(s -> s.accept(data)).findAny();
                o.ifPresent(us -> us.read(data));
            }while (o.isPresent());
        }catch(ArrayIndexOutOfBoundsException ex){}
    }

    public Undersegment<?>[] getUnderSegmentTyper(DomeneKlasse domene) {
        return new Undersegment<?>[0]; //ingen undersegment
    }

    public Stream<Consumer<ScrollableArray>> getfelterLaastTilDomene(DomeneKlasse d){
        return getFelter().stream().map(f -> array -> f.setVerdiPaaDomene(d, array.read(f.getByteLength())));
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

    public DomeneKlasse readShallow(ScrollableArray data){
        DomeneKlasse domene = domeneCreator.get();
        getfelterLaastTilDomene(domene).forEachOrdered(c->c.accept(data));
        return domene;
    }

    public DomeneKlasse readSegment(ScrollableArray data){
        DomeneKlasse domene = readShallow(data);
        lesBarn(data, domene);
        return domene;
    }

    public void writeSegment(DomeneKlasse p, OutputStream os){
        writeShallow(p, os);
        Arrays.stream(getUnderSegmentTyper(p)).forEachOrdered(seg -> seg.write(os));
    }

    public void writeShallow(DomeneKlasse p, OutputStream os){
        getFelter().stream().forEachOrdered(f -> f.write(os, p));
    }




}
