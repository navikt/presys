package no.nav.pensjon.dsf.ebcdic.segmenter;

import com.ibm.as400.access.AS400PackedDecimal;
import org.jvnet.hk2.config.Dom;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by d132988 on 11.04.2017.
 */
public abstract class Segment<DomeneKlasse> {

    public abstract String getNavn();

    public abstract  List<Felt> getFelter() ;

    public abstract DomeneKlasse initDomene();

    public abstract void setFeltVerdi(DomeneKlasse domene, Felt f, String verdi);

    public DomeneKlasse readSegment(byte[] data){
        int position = 0;
        DomeneKlasse domene = initDomene();
        for(Felt f : getFelter()){
            byte[] feltBytes = Arrays.copyOfRange(data, position,f.getByteLength() + position);
            position += f.getByteLength();
            setFeltVerdi(domene, f, f.isPacked() ? deCompress(feltBytes, f.getUnpackedLength()): getString(feltBytes));
        }

        return domene;
    }

    public String deCompress(byte[] packed, int length){
        BigDecimal komprimertEntry = (BigDecimal) new AS400PackedDecimal(length, 0).toObject(packed);
        return komprimertEntry.toString();
    }

    public String getString(byte[] Cp1047bytes){
        try {
            return new String(Cp1047bytes, "Cp1047");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
