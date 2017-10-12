package no.nav.pensjon.dsf.dto;

import java.util.ArrayList;
import java.util.List;

class ConvertersUtil {
    private ConvertersUtil(){}

    static List<Integer> bittabellTilAarstallFra1967(boolean[] tabell){
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < tabell.length;i++)
            if(tabell[i])
                l.add(i+1967);
        return l;
    }
}
