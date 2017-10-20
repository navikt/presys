package no.nav.pensjon.dsf.config;

import no.nav.pensjon.dsf.WebServerApplication;
import no.nav.pensjon.dsf.config.auth.abac.PEPAbacConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PEPAbacConfig.class
})
public class WebAppInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebServerApplication.class);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
