package no.nav.pensjon.dsf.authn.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfiguration {

    private byte[] password;

    @Bean
    public JwtService jwtService() {
        return new JwtService(password, "presys");
    }

    @Bean
    public JwtAuthenticationProvider jwtAuthenticationProvider(JwtService jwtService) {
        return new JwtAuthenticationProvider(jwtService);
    }

    public void setPassword(String password) {
        this.password = password.getBytes();
    }
}
