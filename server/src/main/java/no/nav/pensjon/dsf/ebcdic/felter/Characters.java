package no.nav.pensjon.dsf.ebcdic.felter;

import no.nav.pensjon.dsf.ebcdic.EbcdicUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Characters<Domeneklasse> extends Felt<Domeneklasse>{

    public Characters(String feltNavn, int byteLength, BiConsumer<Domeneklasse, String> feltSetter, BiConsumer<Domeneklasse, OutputStream> feltWriter) {
        super(feltNavn, byteLength, feltSetter, feltWriter);
    }

    @Override
    public String parse(byte[] value) {
        return EbcdicUtils.getString(value);
    }



    public static <Domeneklasse> Characters<Domeneklasse> plaintext (String feltNavn, int byteLength, BiConsumer<Domeneklasse, String> feltSetter, Function<Domeneklasse, String> feltGetter){
        return new Characters<>(feltNavn, byteLength, feltSetter, (d, os) -> {
            try {
                os.write(padRight(feltGetter.apply(d), byteLength).getBytes(EbcdicUtils.EBCDIC_CHARSET));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static <Domeneklasse> Characters<Domeneklasse> filler (String feltNavn, int byteLength){
        return new Characters<>(feltNavn, byteLength, (d, s)->{}, (d, os) -> {
            try {
                os.write(padRight("", byteLength).getBytes(EbcdicUtils.EBCDIC_CHARSET));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    static String padRight(String s, int length){
        if(s.length() > length){
            return s.substring(0, length);
        }
        while(s.length()<length){
            s += " ";
        }
        return  s;
    }

}
