package no.nav.pensjon.dsf.web.resources;

import no.nav.pensjon.dsf.WebServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = WebServerApplication.class)
@AutoConfigureMockMvc
public class PresysControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void isAlive() throws Exception {
        mvc.perform(get("/isAlive"))
                .andExpect(status().isOk())
                .andExpect(content().string("{}"));
    }

    @Test
    public void isReady() throws Exception {
        mvc.perform(get("/isReady"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"status\":\"UP\"")));
    }

    @Test
    public void metrics() throws Exception {
        mvc.perform(get("/metrics"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("uptime")));
    }

}
