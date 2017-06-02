package no.nav.pensjon.dsf.domene;

import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.SubSegment;

import java.util.ArrayList;
import java.util.List;

@Segment(name = "STATUS  ", length = 0)
public class Status {

    @SubSegment
    private List<Tilknytning> tilknytninger = new ArrayList<>();

    @SubSegment
    private List<Alderspensjon> alderspensjoner = new ArrayList<>();

    @SubSegment
    private List<UforeHistorikk> uforehistorikk = new ArrayList<>();

    @SubSegment
    private List<AfpHistorikk> afpHistorikker = new ArrayList<>();

    @SubSegment
    private List<Uforepensjon> uforepensjoner = new ArrayList<>();

    @SubSegment
    private List<ForsorgingsTillegg> forsorgingsTillegg = new ArrayList<>();

    @SubSegment
    private List<EtterlattEktefelle> etterlattEktefeller = new ArrayList<>();

    public List<Tilknytning> getTilknytninger() {
        return tilknytninger;
    }

    public List<Alderspensjon> getAlderspensjoner() {
        return alderspensjoner;
    }

    public List<UforeHistorikk> getUforehistorikk() {
        return uforehistorikk;
    }

    public List<AfpHistorikk> getAfpHistorikker() {
        return afpHistorikker;
    }

    public List<Uforepensjon> getUforepensjoner() {
        return uforepensjoner;
    }

    public List<ForsorgingsTillegg> getForsorgingsTillegg() {
        return forsorgingsTillegg;
    }

    public List<EtterlattEktefelle> getEtterlattEktefeller() {
        return etterlattEktefeller;
    }
}
