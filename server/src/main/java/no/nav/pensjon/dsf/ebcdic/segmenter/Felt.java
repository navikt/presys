package no.nav.pensjon.dsf.ebcdic.segmenter;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public abstract class Felt<Domeneklasse> {
    private String feltNavn;
    private int byteLength;
    private BiConsumer<Domeneklasse, String> feltSetter;

    public Felt(String feltNavn, int byteLength, BiConsumer<Domeneklasse, String> feltSetter ) {
        this.feltNavn = feltNavn;
        this.byteLength = byteLength;
        this.feltSetter = feltSetter;
    }

    public String getFeltNavn() {
        return feltNavn;
    }

    public int getByteLength() {
        return byteLength;
    }

    public abstract String parse(byte[]value);

    public void setVerdiPaaDomene(Domeneklasse domene, byte[] value){
        feltSetter.accept(domene, parse(value));
    }

    public Consumer<String> setterFor(Domeneklasse domene){
        return verdi -> feltSetter.accept(domene, verdi);
    }
}
