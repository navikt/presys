package no.nav.pensjon.dsf.web.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresysController {

    @RequestMapping("/isAlive")
    public String isAlive() {
        return "OK";
    }

    @RequestMapping("/isReady")
    public String isReady() {
        return "OK";
    }
}
