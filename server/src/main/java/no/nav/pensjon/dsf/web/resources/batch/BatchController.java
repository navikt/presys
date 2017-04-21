package no.nav.pensjon.dsf.web.resources.batch;

import no.nav.pensjon.dsf.ebcdic.EbcdicUtils;
import no.nav.pensjon.dsf.ebcdic.SplitPerson;
import no.nav.pensjon.dsf.repository.DbPerson;
import no.nav.pensjon.dsf.repository.DbRepo;
import no.nav.pensjon.dsf.repository.PersonRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
@RequestMapping("api/batch")
public class BatchController {

    @Inject
    DbRepo repo;

    @Inject
    PersonRepository pRepo;


    @RequestMapping("/last")
    public int last() throws IOException {
        AtomicInteger counter = new AtomicInteger();

        SplitPerson.split(data->{
            DbPerson person = new DbPerson();
            person.setData(Base64.getEncoder().encodeToString(data.getData()));
            person.setFnr(EbcdicUtils.deCompress(Arrays.copyOfRange(data.getData(), 6+29, 6+29+6),11,0).toString());
            repo.save(person);
            counter.getAndIncrement();
        });

        return counter.get();
    }

    @RequestMapping("/vis")
    public List<String> vis() throws IOException {
        return pRepo.personer();
    }
}
