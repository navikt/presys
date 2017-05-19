package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.SubSegment;

import java.util.ArrayList;
import java.util.List;

@Segment(name = "UFØRHIST", length = 0)
public class UforeHistorikk {

    @SubSegment
    private List<Uforegrad> uforegrader = new ArrayList<>();

    public List<Uforegrad> getUforegrader() {
        return uforegrader;
    }
}
