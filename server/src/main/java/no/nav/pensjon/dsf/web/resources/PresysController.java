package no.nav.pensjon.dsf.web.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by s150563 on 02.06.2017.
 */
@RestController
@RequestMapping("api/internal")
public class PresysController {

    @RequestMapping(method = {RequestMethod.GET}, value="/isAlive")
    public String isAlive() {
        return "OK";
    }

    @RequestMapping(method = {RequestMethod.GET}, value="/selftest")
    public Selftest selftest() {
        /* see https://confluence.adeo.no/display/AURA/Selftest */
        Selftest test = new Selftest("presys");

        test.setAggregateResult(0);
        test.addCheck(new SelfCheck("dummy endpoint", "dummy description").setResult(0));

        return test;
    }

    private static class Selftest {
        private String application;

        private int aggregateResult;

        private Instant timestamp;

        private List<SelfCheck> checks = new ArrayList<>();

        public Selftest(String application) {
            this.application = application;
            this.timestamp = Instant.now();
        }

        public Selftest setAggregateResult(int result) {
            this.aggregateResult = result;
            return this;
        }

        public Selftest addCheck(SelfCheck check) {
            checks.add(check);
            return this;
        }

        public String getApplication() {
            return application;
        }

        public String getTimestamp() {
            return timestamp.toString();
        }

        public int getAggregateResult() {
            return aggregateResult;
        }

        public List<SelfCheck> getChecks() {
            return checks;
        }
    }

    private static class SelfCheck {

        private String endpoint;

        private String description;

        private int result;

        public SelfCheck(String endpoint, String description) {
            this.endpoint = endpoint;
            this.description = description;
        }

        public SelfCheck setResult(int result) {
            this.result = result;
            return this;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public String getDescription() {
            return description;
        }

        public int getResult() {
            return result;
        }
    }
}
