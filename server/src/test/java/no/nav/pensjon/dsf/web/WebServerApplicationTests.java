package no.nav.pensjon.dsf.web;

import no.nav.pensjon.dsf.WebServerApplication;
import org.junit.Test;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Import(WebServerApplication.class)
public class WebServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
