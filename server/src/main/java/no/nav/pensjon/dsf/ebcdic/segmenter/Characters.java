package no.nav.pensjon.dsf.ebcdic.segmenter;

import no.nav.pensjon.dsf.ebcdic.EbcdicUtils;

import java.util.function.BiConsumer;

public class Characters<Domeneklasse> extends Felt<Domeneklasse>{

    public Characters(String feltNavn, int byteLength,BiConsumer<Domeneklasse, String> feltSetter) {
        super(feltNavn, byteLength, feltSetter);
    }

    @Override
    public String parse(byte[] value) {
        return EbcdicUtils.getString(value);
    }

    public static <Domeneklasse> Characters<Domeneklasse> plaintext (String feltNavn, int byteLength, BiConsumer<Domeneklasse, String> feltSetter){
        return new Characters<>(feltNavn, byteLength, feltSetter);
    }

}
