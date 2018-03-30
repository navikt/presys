package no.nav.abac.spring.consumer;

import no.nav.abac.core.dto.request.XacmlRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(MockitoJUnitRunner.class)
public class AbacRequestMapperTest {

    @InjectMocks
    private AbacRequestMapper mapper;

    @Test
    public void mapsResource() {
        XacmlRequest request = new XacmlRequest()
                .resource("rs1","rs1Val");

        String result = mapper.map(request);

        assertThat(result, is("{\"Request\":{\"Resource\":{\"Attribute\":[{\"AttributeId\":\"rs1\",\"Value\":\"rs1Val\"}]}}}"));
    }

    @Test
    public void mapsMultipleResources() {
        XacmlRequest request = new XacmlRequest()
                .resource("rs1","rs1Val")
                .resource("rs2","rs2Val");

        String result = mapper.map(request);

        assertThat(result, containsString("{\"AttributeId\":\"rs1\",\"Value\":\"rs1Val\"}"));
        assertThat(result, containsString("{\"AttributeId\":\"rs2\",\"Value\":\"rs2Val\"}"));
    }

    @Test
    public void mapsAccessSubject() {
        XacmlRequest request = new XacmlRequest()
                .accessSubject("a","a1Val");

        String result = mapper.map(request);

        assertThat(result, is("{\"Request\":{\"AccessSubject\":{\"Attribute\":[{\"AttributeId\":\"a\",\"Value\":\"a1Val\"}]}}}"));
    }

    @Test
    public void mapsMultipleAccessSubjects() {
        XacmlRequest request = new XacmlRequest()
                .accessSubject("ac1","ac1Val")
                .accessSubject("ac2","ac2Val");

        String result = mapper.map(request);

        assertThat(result, containsString("{\"AttributeId\":\"ac1\",\"Value\":\"ac1Val\"}"));
        assertThat(result, containsString("{\"AttributeId\":\"ac2\",\"Value\":\"ac2Val\"}"));
    }

    @Test
    public void mapsAction() {
        XacmlRequest request = new XacmlRequest()
                .action("a","a1Val");

        String result = mapper.map(request);

        assertThat(result, is("{\"Request\":{\"Action\":{\"Attribute\":[{\"AttributeId\":\"a\",\"Value\":\"a1Val\"}]}}}"));
    }

    @Test
    public void mapsMultipleActions() {
        XacmlRequest request = new XacmlRequest()
                .action("a1","a1Val")
                .action("a2","a2Val");

        String result = mapper.map(request);

        assertThat(result, containsString("{\"AttributeId\":\"a1\",\"Value\":\"a1Val\"}"));
        assertThat(result, containsString("{\"AttributeId\":\"a2\",\"Value\":\"a2Val\"}"));
    }

    @Test
    public void mapsEnvironment() {
        XacmlRequest request = new XacmlRequest()
                .environment("e","e1Val");

        String result = mapper.map(request);

        assertThat(result, is("{\"Request\":{\"Environment\":{\"Attribute\":[{\"AttributeId\":\"e\",\"Value\":\"e1Val\"}]}}}"));
    }

    @Test
    public void mapsMultipleEnvironments() {
        XacmlRequest request = new XacmlRequest()
                .environment("e1","e1Val")
                .environment("e2","e2Val");

        String result = mapper.map(request);

        assertThat(result, containsString("{\"AttributeId\":\"e1\",\"Value\":\"e1Val\"}"));
        assertThat(result, containsString("{\"AttributeId\":\"e2\",\"Value\":\"e2Val\"}"));
    }

    @Test
    public void mapsMultipleDifferentTypes() {
        XacmlRequest request = new XacmlRequest()
                .resource("rs1", "rs1Val")
                .accessSubject("ac1", "ac1Val")
                .action("a1", "a1Val")
                .environment("e1", "e1Val");

        String result = mapper.map(request);

        assertThat(result, is("{\"Request\":{\"Resource\":{\"Attribute\":[{\"AttributeId\":\"rs1\",\"Value\":\"rs1Val\"}]}," +
                "\"AccessSubject\":{\"Attribute\":[{\"AttributeId\":\"ac1\",\"Value\":\"ac1Val\"}]}," +
                "\"Action\":{\"Attribute\":[{\"AttributeId\":\"a1\",\"Value\":\"a1Val\"}]}," +
                "\"Environment\":{\"Attribute\":[{\"AttributeId\":\"e1\",\"Value\":\"e1Val\"}]}}}"));
    }

    @Test
    public void mapsEmptyRequest() {
        XacmlRequest request = new XacmlRequest();

        String result = mapper.map(request);

        assertThat(result, is("{\"Request\":{}}"));
    }
}
