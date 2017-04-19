package no.nav.pensjon.dsf.ebcdic.felter;

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

    public static <Domeneklasse> PackedDecimal<Domeneklasse> pakketTekst (String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, String> feltSetter){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, feltSetter);
    }

    public static <Domeneklasse> PackedDecimal<Domeneklasse> pakketHeltall (String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, Integer> feltSetter){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, (d, f)->feltSetter.accept(d, Integer.parseInt(f)));
    }

    public static <Domeneklasse> PackedDecimal<Domeneklasse> pakketZeroFilled (String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, String> feltSetter){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, (d, f) -> feltSetter.accept(d, zeroFill(f, unpackedLength)));
    }

    static String zeroFill(String tekst, int length){
        StringBuilder sb = new StringBuilder();
        for (int i = tekst.length(); i<length;i++)
            sb.append(0);
        sb.append(tekst);
        return sb.toString();
    }

}
