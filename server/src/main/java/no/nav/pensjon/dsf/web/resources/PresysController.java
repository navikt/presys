package no.nav.pensjon.dsf.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/internal")
public class PresysController {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${application.version}")
    private String applicationVersion;

    @RequestMapping(method = {RequestMethod.GET}, value="/isAlive")
    public String isAlive() {
        return "OK";
    }

    @RequestMapping(method = {RequestMethod.GET}, value="/isReady")
    public String isReady() {
        return "OK";
    }

    @RequestMapping(method = {RequestMethod.GET}, value="/selftest")
    public Selftest selftest() {
        /* see https://confluence.adeo.no/display/AURA/Selftest */
        Selftest test = new Selftest(applicationContext.getId(), applicationVersion);

        test.setAggregateResult(0);
        test.addCheck(new SelfCheck("dummy endpoint", "dummy description").setResult(0));

        return test;
    }

    private static class Selftest {
        private String application;

        private String version;

        private int aggregateResult;

        private Instant timestamp;

        private List<SelfCheck> checks = new ArrayList<>();

        public Selftest(String application, String version) {
            this.application = application;
            this.version = version;
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

        public String getVersion() {
            return version;
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
