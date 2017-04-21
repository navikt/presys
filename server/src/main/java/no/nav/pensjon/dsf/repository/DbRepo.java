package no.nav.pensjon.dsf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepo extends CrudRepository<DbPerson, String> {

}
