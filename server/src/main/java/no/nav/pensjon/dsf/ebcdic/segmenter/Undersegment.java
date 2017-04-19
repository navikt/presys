package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.ebcdic.ScrollableArray;

import java.util.function.Consumer;

/**
 * Created by d132988 on 19.04.2017.
 */
public class Undersegment<Child> {

    Segment<Child> reader;
    Consumer<Child> setter;

    public Undersegment(Segment<Child> reader, Consumer<Child> setter) {
        this.reader = reader;
        this.setter = setter;
    }

    public boolean accept(ScrollableArray data){
        return reader.accept(data);
    }

    public void read(ScrollableArray data){
        setter.accept(reader.readSegment(data));
    }

    public static <Child> Undersegment<Child> of(Segment<Child> reader, Consumer<Child> setter){
        return new Undersegment<>(reader, setter);
    }
}
