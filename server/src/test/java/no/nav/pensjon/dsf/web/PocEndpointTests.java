package no.nav.pensjon.dsf.web;

import no.nav.pensjon.dsf.auth.JwtService;

import no.nav.pensjon.dsf.auth.PresysUser;
import no.nav.pensjon.dsf.web.exceptions.ResourceNotFound;
import no.nav.pensjon.dsf.web.resources.person.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import org.springframework.test.web.servlet.ResultActions;


import static org.mockito.BDDMockito.*;
import static  no.nav.pensjon.presys.utils.ebcdic.TestPerson.createPerson;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

public class PocEndpointTests extends  WebServerApplicationTests {

	@MockBean
	private PersonRepository repo;

	@Autowired
	private JwtService jwt;

	@Autowired
	private MockMvc mockMvc;
	@Before
	public void before(){
		given(repo.findPerson("123")).willReturn(createPerson("123", "lars", 0).get());
		given(repo.findPerson("321")).willThrow(ResourceNotFound.class);

	}

	@Test
	public void contextLoads() throws  Exception {
		mockMvc.perform(get("/api/internal/isAlive")).andExpect(status().isOk());
	}


	@Test
	public void personFoundAndValidToken() throws  Exception {
		performGet("/api/person/123", validToken())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.navn", is("lars")));

	}

	@Test
	public void personNotFound() throws  Exception {
		performGet("/api/person/321", validToken()).andExpect(status().isNotFound());
	}

	@Test
	public void withInvalidToken() throws  Exception {
		performGet("/api/person/123", invalidToken()).andExpect(status().isUnauthorized());
	}

	public ResultActions performGet(String url, String token) throws Exception {
		return  mockMvc.perform(get(url, 321).header("Authorization","Bearer " + token));
	}

	public String validToken(){
		GrantedAuthority ga = new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "saksbehandler";
			}
		};
		PresysUser usr = new PresysUser("lars", "123", "lars", "dahl", "lars", true, true, true, true, Arrays.asList(ga));
		return jwt.issueToken(usr);
	}

	public String invalidToken(){
		GrantedAuthority ga = new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "saksbehandler";
			}
		};
		PresysUser usr = new PresysUser("lars", "123", "lars", "dahl", "lars", false, false, false, false, Arrays.asList(ga));
		return jwt.issueToken(usr);
	}

}
