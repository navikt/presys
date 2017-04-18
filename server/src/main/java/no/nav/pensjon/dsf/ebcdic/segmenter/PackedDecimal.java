package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.ebcdic.EbcdicUtils;

import java.util.function.BiConsumer;

/**
 * Created by d132988 on 18.04.2017.
 */
public class PackedDecimal<Domeneklasse> extends Felt<Domeneklasse> {

    private int unpackedLength;

    public PackedDecimal(String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, String> feltSetter) {
        super(feltNavn, byteLength, feltSetter);
        this.unpackedLength = unpackedLength;
    }

    @Override
    public String parse(byte[] value) {
        return EbcdicUtils.deCompress(value, unpackedLength, 0);
    }

    public static <Domeneklasse> PackedDecimal<Domeneklasse> tekst (String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, String> feltSetter){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, feltSetter);
    }

    public static <Domeneklasse> PackedDecimal<Domeneklasse> tall (String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, Integer> feltSetter){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, (d, f)->feltSetter.accept(d, Integer.parseInt(f)));
    }
}
