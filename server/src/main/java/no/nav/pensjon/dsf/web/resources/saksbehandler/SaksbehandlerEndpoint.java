package no.nav.pensjon.dsf.web.resources.saksbehandler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import java.io.UnsupportedEncodingException;

/**
 * Created by d132988 on 10.04.2017.
 */

@RestController
@RequestMapping("api/saksbehandler")
public class SaksbehandlerEndpoint {


    @PUT
    @RequestMapping("/login")
    public LoggedInCredentials login(@RequestBody Credentials credentials) throws UnsupportedEncodingException {
        LoggedInCredentials loggedIn = new LoggedInCredentials();
        //loggedIn.setFeltNavn(credentials.getBrukernavn());

        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("dsf")
                .withSubject(credentials.getBrukernavn())
                .withClaim("saksbehandler", true)
                .sign(algorithm);

        loggedIn.setJwt(token);
        return loggedIn;
    }

    @PUT
    @RequestMapping("/refreshlogin")
    public LoggedInCredentials refresh( @RequestHeader(value="X-Jwt") String jwtToken) throws UnsupportedEncodingException {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("dsf")
                    .withClaim("saksbehandler", true)
                    .build(); //Reusable verifier instance
            DecodedJWT decode = verifier.verify(jwtToken);
        LoggedInCredentials loggedIn = new LoggedInCredentials();


        String token = JWT.create()
                .withIssuer("dsf")
                .withSubject(decode.getSubject())
                .withClaim("saksbehandler", true)
                .sign(algorithm);

        loggedIn.setJwt(token);
        return loggedIn;
    }
}
