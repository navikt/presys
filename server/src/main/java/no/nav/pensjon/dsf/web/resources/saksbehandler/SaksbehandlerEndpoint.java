package no.nav.pensjon.dsf.web.resources.saksbehandler;

import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by d132988 on 10.04.2017.
 */

@RestController
@RequestMapping("api/saksbehandler")
public class SaksbehandlerEndpoint {


    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public LoggedInCredentials login(@RequestBody Credentials credentials) throws UnsupportedEncodingException {
        LoggedInCredentials loggedIn = new LoggedInCredentials();

        loggedIn.setJwt("");
        return loggedIn;
    }

    @RequestMapping(value = "/refreshlogin", method = RequestMethod.GET)
    public LoggedInCredentials refresh( @RequestHeader(value="X-Jwt") String jwtToken) throws UnsupportedEncodingException {
        LoggedInCredentials loggedIn = new LoggedInCredentials();
        String token = "";
        loggedIn.setJwt(token);
        return loggedIn;
    }
}
