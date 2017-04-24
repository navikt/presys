package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.ebcdic.ScrollableArray;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by d132988 on 19.04.2017.
 */
public class Undersegment<Child> {

    private Segment<Child> reader;
    private Consumer<Child> setter;
    private Supplier<List<Child>> getter;

    public Undersegment(Segment<Child> reader, Consumer<Child> setter, Supplier<List<Child>> getter) {
        this.reader = reader;
        this.setter = setter;
        this.getter = getter;
    }

    public boolean accept(ScrollableArray data){
        return reader.accept(data);
    }

    public void read(ScrollableArray data){
        setter.accept(reader.readSegment(data));
    }

    public void write(OutputStream os){
        getter.get().stream().forEach(child -> reader.writeSegment(child, os));
    }


    public static <Child> Undersegment<Child> ofList(Segment<Child> reader, Consumer<Child> setter, Supplier<List<Child>> getter){
        return new Undersegment<>(reader, setter, getter);
    }

    public static <Child> Undersegment<Child> ofSingle(Segment<Child> reader, Consumer<Child> setter, Supplier<Child> getter){
        return new Undersegment<>(reader, setter, ()->{
            List<Child> liste = new ArrayList<>();
            liste.add(getter.get());
            return liste;
        });
    }
}
