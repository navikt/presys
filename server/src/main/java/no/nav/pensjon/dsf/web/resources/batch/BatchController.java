package no.nav.pensjon.dsf.web.resources.batch;

import no.nav.pensjon.presys.utils.ebcdic.EbcdicUtils;
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
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("api/batch")
public class BatchController {

    @Inject
    DbRepo repo;

    @Inject
    PersonRepository pRepo;


    @RequestMapping("/last")
    public int last() throws Exception {
        AtomicInteger counter = new AtomicInteger();
        SplitPerson.RequestObject req = new SplitPerson.RequestObject();
        req.setWriter(data->{
            DbPerson person = new DbPerson();
            person.setData(Base64.getEncoder().encodeToString(data.getData()));
            person.setFnr(zeroFill(EbcdicUtils.deCompress(Arrays.copyOfRange(data.getData(), 6+29, 6+29+6),11,0).toString(),11));
            repo.save(person);
            counter.getAndIncrement();
        });

        SplitPerson.split(req);

        return counter.get();
    }

    @RequestMapping("/vis")
    public List<String> vis() throws IOException {
        return pRepo.personer();
    }

    static String zeroFill(String tekst, int length){
        StringBuilder sb = new StringBuilder();
        for (int i = tekst.length(); i<length;i++)
            sb.append(0);
        sb.append(tekst);
        return sb.toString();
    }
}
