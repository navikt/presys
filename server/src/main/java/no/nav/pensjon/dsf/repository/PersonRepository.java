package no.nav.pensjon.dsf.repository;

import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.web.Exceptions.ResourceNotFound;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
public class PersonRepository {

    @Inject
    private DbRepo repo;

    @Inject
    private JdbcTemplate db;

    private static final Logger LOG = LoggerFactory.getLogger(PersonRepository.class);

    public Person findPerson(String fnr) throws IOException {
        MDC.put("target", fnr);
        try {
            return AnnotationMapper.les(new ScrollableArray(
                            Base64.getDecoder().decode(
                                    Optional.ofNullable(repo.findOne(fnr)).orElseThrow(ResourceNotFound::new).getData()
                            )), Person.class);
        } catch (RuntimeException rte) {
            LOG.info("Feil ved henting av person", rte);
            throw rte;
        } catch (Exception e) {
            LOG.info("Feil ved henting av person", e);
            throw new RuntimeException(e);
        } finally {
            MDC.remove("target");
        }
    }

    public List<String> personer(){
        return db.queryForList("select fnr from Db_Person", String.class);
    }

    public boolean exists(String fnr){
        return repo.exists(fnr);
    }
}
