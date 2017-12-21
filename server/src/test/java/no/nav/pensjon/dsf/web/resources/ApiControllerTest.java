package no.nav.pensjon.dsf.web.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import no.nav.pensjon.dsf.WebServerApplication;
import no.nav.pensjon.dsf.auth.PresysUser;
import no.nav.pensjon.dsf.auth.jwt.JwtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.securityContext;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = WebServerApplication.class)
@AutoConfigureMockMvc
public class ApiControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ObjectMapper objectMapper;

    @Configuration
    static class ContextConfiguration {
        @Bean
        public AbstractLdapAuthenticationProvider ldapAuthenticationProvider(ContextSource contextSource, UserDetailsContextMapper contextMapper) {

            BindAuthenticator authenticator = new BindAuthenticator((BaseLdapPathContextSource) contextSource);
            authenticator.setUserDnPatterns(new String[]{"uid={0},ou=people,dc=test,dc=local"});

            DefaultLdapAuthoritiesPopulator populator = new DefaultLdapAuthoritiesPopulator(
                    contextSource, "ou=groups,dc=test,dc=local");
            populator.setGroupSearchFilter("(uniqueMember={0})");

            LdapAuthenticationProvider provider = new LdapAuthenticationProvider(authenticator, populator);

            provider.setHideUserNotFoundExceptions(false);
            provider.setUserDetailsContextMapper(contextMapper);
            provider.setUseAuthenticationRequestCredentials(true);

            return provider;
        }
    }

    @Test
    public void should_Fail_When_RequestIsInvalid() throws Exception {
        mvc.perform(post("/api/login")
                .with(securityContext(SecurityContextHolder.getContext()))
        ).andExpect(status().isUnauthorized())
                .andExpect(status().reason("Authentication Failed: Malformed JSON"))
                .andExpect(unauthenticated());
    }

    @Test
    public void should_Fail_When_BadCredentials() throws Exception {
        mvc.perform(post("/api/login")
                .content("{\"username\": \"bob\", \"password\": \"wrongpassword\"}")
                .with(securityContext(SecurityContextHolder.getContext()))
        ).andExpect(status().isUnauthorized())
                .andExpect(status().reason("Authentication Failed: Bad credentials"))
                .andExpect(unauthenticated());
    }

    @Test
    public void should_ReturnToken_When_OK() throws Exception {
        String responseJson = mvc.perform(post("/api/login")
                .content("{\"username\": \"bob\", \"password\": \"bobspassword\"}")
                .with(securityContext(SecurityContextHolder.getContext()))
        ).andExpect(status().isOk())
                .andExpect(authenticated()
                        .withUsername("bob")
                        .withRoles("0000-GA-PENSJON_SAKSBEHANDLER")
                )
                .andReturn()
                .getResponse()
                .getContentAsString();

        TokenResponse response = objectMapper.readValue(responseJson, TokenResponse.class);

        Claims claims = jwtService.parseToken(response.token);

        assertEquals("bob", claims.getSubject());
        assertEquals("Bob Hamilton", claims.get("name"));
        assertEquals("Hamilton", claims.get("surname"));
        assertEquals("presys", claims.getIssuer());

        List<String> scopes = claims.get("scopes", List.class);
        assertEquals(1, scopes.size());
        assertEquals("ROLE_0000-GA-PENSJON_SAKSBEHANDLER", scopes.get(0));

    }

    @Test
    public void should_Fail_When_AuthorizationHeaderIsMissing() throws Exception {
        mvc.perform(get("/api")
                .with(securityContext(SecurityContextHolder.getContext()))
        ).andExpect(status().isUnauthorized())
                .andExpect(status().reason("Authentication Failed: Missing Authorization"))
                .andExpect(unauthenticated());
    }

    @Test
    public void should_Fail_When_BearerIsMissing() throws Exception {
        mvc.perform(get("/api")
                .header("Authorization", "mytoken")
                .with(securityContext(SecurityContextHolder.getContext()))
        ).andExpect(status().isUnauthorized())
                .andExpect(status().reason("Authentication Failed: Missing Bearer"))
                .andExpect(unauthenticated());
    }

    @Test
    public void should_Fail_When_JwtIsInvalid() throws Exception {
        mvc.perform(get("/api")
                .with(jwtAuthorization("a.b.c"))
                .with(securityContext(SecurityContextHolder.getContext()))
        ).andExpect(status().isUnauthorized())
                .andExpect(status().reason(containsString("Authentication Failed: Unable to read JSON value")))
                .andExpect(unauthenticated());
    }

    @Test
    public void should_DisplayOK_When_Authenticated() throws Exception {
        String token = jwtService.issueToken(new PresysUser("testuser", "password", "Ola",
                "Nordmann", "ola@nordmann.no", Collections.singletonList(new SimpleGrantedAuthority("0000-GA-PENSJON_SAKSBEHANDLER"))));

        mvc.perform(get("/api")
                .with(jwtAuthorization(token))
                .with(securityContext(SecurityContextHolder.getContext())) // See: https://github.com/spring-projects/spring-security/issues/4516
        ).andExpect(status().isOk())
                .andExpect(header().doesNotExist("Set-Cookie"))
                .andExpect(content().string("OK"))
                .andExpect(authenticated());
    }

    private static RequestPostProcessor jwtAuthorization(String token) {
        return request -> {
            request.addHeader("Authorization", "Bearer " + token);
            return request;
        };
    }

    private static class TokenResponse {
        public String token;
    }

}
