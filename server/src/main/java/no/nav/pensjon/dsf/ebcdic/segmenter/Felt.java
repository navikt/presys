package no.nav.pensjon.dsf.ebcdic.segmenter;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by d132988 on 11.04.2017.
 */
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

    public void setFeltNavn(String feltNavn) {
        this.feltNavn = feltNavn;
    }

    public int getByteLength() {
        return byteLength;
    }

    public void setByteLength(int byteLength) {
        this.byteLength = byteLength;
    }

    public abstract String parse(byte[]value);

    public void setVerdiPaaDomene(Domeneklasse domene, byte[] value){
        feltSetter.accept(domene, parse(value));
    }
}
