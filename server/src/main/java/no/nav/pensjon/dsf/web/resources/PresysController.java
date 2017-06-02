package no.nav.pensjon.dsf.web.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by s150563 on 02.06.2017.
 */
@RestController
@RequestMapping("api/internal")
public class PresysController {

    @RequestMapping(method = {RequestMethod.GET}, value="/isAlive")
    public ResponseEntity<String> isAlive() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
