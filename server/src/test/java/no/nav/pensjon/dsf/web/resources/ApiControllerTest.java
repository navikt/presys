package no.nav.pensjon.dsf.web.resources;

import no.nav.pensjon.dsf.WebServerApplication;
import no.nav.pensjon.dsf.auth.PresysUser;
import no.nav.pensjon.dsf.auth.jwt.JwtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import java.util.Collections;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.securityContext;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

}
