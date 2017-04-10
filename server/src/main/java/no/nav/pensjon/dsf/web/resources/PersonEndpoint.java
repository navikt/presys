package no.nav.pensjon.dsf.web.resources;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import no.nav.pensjon.dsf.web.Exceptions.ResourceNotFound;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@RestController
@RequestMapping("api/person")
public class PersonEndpoint {

    private final List<Person> repo = new ArrayList<>();

    private static final Function<String, Predicate<Person>> fnrMatcher = fnr -> person -> fnr.equals(person.getFnr());

    PersonEndpoint(){
        repo.add(new Person("123", "Lars", 31, Person.Kjonn.MANN, Person.SivilStatus.PARTNER));
        repo.add(new Person("321", "Bernt", 78, Person.Kjonn.KVINNE, Person.SivilStatus.SAMBOER));

    }

    private static Predicate<Person> fnrMatcher(String fnr){
        return person -> fnr.equals(person.getFnr());
    }



    @RequestMapping("/{fnr}")
    public Person findOne(@PathVariable String fnr, @RequestHeader(value="X-Jwt") String jwtToken) throws UnsupportedEncodingException {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("dsf")
                    .withClaim("saksbehandler", true)
                    .build(); //Reusable verifier instance
            verifier.verify(jwtToken);

        return repo.stream().filter(fnrMatcher(fnr)).findAny().orElseThrow(ResourceNotFound::new);
    }


}
