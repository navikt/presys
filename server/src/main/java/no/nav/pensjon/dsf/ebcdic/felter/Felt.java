package no.nav.pensjon.dsf.ebcdic.felter;

import java.io.OutputStream;
import java.util.function.BiConsumer;
import java.util.function.Function;

public abstract class Felt<Domeneklasse> {
    private String feltNavn;
    private int byteLength;
    private BiConsumer<Domeneklasse, String> feltSetter;
    private BiConsumer<Domeneklasse, OutputStream> feltWriter;

    public Felt(String feltNavn, int byteLength, BiConsumer<Domeneklasse, String> feltSetter, BiConsumer<Domeneklasse, OutputStream> feltWriter) {
        this.feltNavn = feltNavn;
        this.byteLength = byteLength;
        this.feltSetter = feltSetter;
        this.feltWriter = feltWriter;
    }

    public void write(OutputStream os, Domeneklasse d){
        feltWriter.accept(d, os);
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
}
