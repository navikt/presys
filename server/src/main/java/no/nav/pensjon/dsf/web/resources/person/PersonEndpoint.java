package no.nav.pensjon.dsf.web.resources.person;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import no.nav.pensjon.dsf.repository.PersonRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("api/person")
public class PersonEndpoint {

    @Inject
    private PersonRepository repo;

    @RequestMapping("/{fnr}")
    public no.nav.pensjon.dsf.domene.Person findOne(@PathVariable String fnr, @RequestHeader(value="X-Jwt") String jwtToken) throws IOException {
        sikkerhet(jwtToken);
        return repo.findPerson(fnr);
    }

    public void sikkerhet(String jwtToken) throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("dsf")
                .withClaim("saksbehandler", true)
                .build(); //Reusable verifier instance
        verifier.verify(jwtToken);
    }


}
