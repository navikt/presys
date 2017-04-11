package no.nav.pensjon.dsf.ebcdic.segmenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d132988 on 11.04.2017.
 */
public abstract class Segment<DomeneKlasse> {


    private List<Felt> felter = new ArrayList<>();

    public abstract String getNavn();

    public List<Felt> getFelter() {
        return felter;
    }

    public abstract DomeneKlasse readSegment(byte[] data);
}
