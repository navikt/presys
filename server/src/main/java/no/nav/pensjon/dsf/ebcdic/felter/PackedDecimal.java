package no.nav.pensjon.dsf.ebcdic.felter;

import no.nav.pensjon.dsf.ebcdic.EbcdicUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Created by d132988 on 18.04.2017.
 */
public class PackedDecimal<Domeneklasse> extends Felt<Domeneklasse> {

    private int unpackedLength;

    public PackedDecimal(String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, String> feltSetter, BiConsumer<Domeneklasse, OutputStream> feltWriter) {
        super(feltNavn, byteLength, feltSetter, feltWriter);
        this.unpackedLength = unpackedLength;
    }

    @Override
    public String parse(byte[] value) {
        return EbcdicUtils.deCompress(value, unpackedLength, 0);
    }

    public static <Domeneklasse> PackedDecimal<Domeneklasse> pakketTekst (String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, String> feltSetter, Function<Domeneklasse, String> feltGetter){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, feltSetter, (d, os) -> {
            try {
                os.write(EbcdicUtils.compress(Integer.parseInt(feltGetter.apply(d)), unpackedLength));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static <Domeneklasse> PackedDecimal<Domeneklasse> pakketHeltall (String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, Integer> feltSetter, Function<Domeneklasse, Integer> feltGetter){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, (d, f)->feltSetter.accept(d, Integer.parseInt(f)), (d, os) -> {
            try {
                os.write(EbcdicUtils.compress(feltGetter.apply(d), unpackedLength));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static <Domeneklasse> PackedDecimal<Domeneklasse> pakketZeroFilled (String feltNavn, int byteLength, int unpackedLength, BiConsumer<Domeneklasse, String> feltSetter, Function<Domeneklasse, String> feltGetter){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, (d, f) -> feltSetter.accept(d, zeroFill(f, unpackedLength)), (d, os) -> {
            try {
                os.write(EbcdicUtils.compress(Integer.parseInt(feltGetter.apply(d)), unpackedLength));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public static <Domeneklasse> PackedDecimal<Domeneklasse> pakketFiller (String feltNavn, int byteLength, int unpackedLength){
        return new PackedDecimal<>(feltNavn, byteLength, unpackedLength, (d, f) -> {}, (d, os) -> {
            try {
                os.write(EbcdicUtils.compress(0, unpackedLength));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    static String zeroFill(String tekst, int length){
        StringBuilder sb = new StringBuilder();
        for (int i = tekst.length(); i<length;i++)
            sb.append(0);
        sb.append(tekst);
        return sb.toString();
    }

}
