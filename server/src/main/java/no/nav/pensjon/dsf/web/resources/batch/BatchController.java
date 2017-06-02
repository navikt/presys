package no.nav.pensjon.dsf.web.resources.batch;

import no.nav.pensjon.presys.utils.ebcdic.EbcdicUtils;
import no.nav.pensjon.dsf.ebcdic.SplitPerson;
import no.nav.pensjon.dsf.repository.DbPerson;
import no.nav.pensjon.dsf.repository.DbRepo;
import no.nav.pensjon.dsf.repository.PersonRepository;
import no.nav.pensjon.presys.utils.ebcdic.Meta;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


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
        Consumer<ScrollableArray> writer = data-> {
            DbPerson person = new DbPerson();
            person.setData(Base64.getEncoder().encodeToString(data.getData()));
            person.setFnr(zeroFill(EbcdicUtils.unpack(Arrays.copyOfRange(data.getData(), Meta.META_SIZE, Meta.META_SIZE + 6), 11, 0).toString(), 11));
            repo.save(person);
            counter.getAndIncrement();
        };

        File fil = new File("C:\\data\\dsf-web\\TEST3");
        DataInputStream reader = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fil)));
        int maksAntall = 20;
        SplitPerson.split(reader, writer, maksAntall, SplitPerson.START_SKIP );
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
