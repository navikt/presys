package no.nav.abac.spring.consumer;

import no.nav.abac.core.dto.response.*;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class AbacResponseMapperTest {

    @InjectMocks
    private AbacResponseMapper mapper;

    private XacmlResponse result;

    @Before
    public void before() {
        result = mapper.map(AbacTestResponse.TEST_FULL_RESPONSE);
    }

    @Test
    public void mapsDecision() {
        MatcherAssert.assertThat(result.getDecision(), Is.is(Decision.PERMIT));
    }

    @Test
    public void mapsOriginalDecision() {
        assertThat(result.getOriginalDecision(), is(Decision.PERMIT));
    }

    @Test
    public void mapsObligations() {
        assertThat(result.getObligations().size(), is(3));
    }

    @Test
    public void mapsObligationWithMultipleAttributeAssignments() {
        Obligation obligation = result.getObligations().get(0);
        assertThat(obligation.getId(), is("no.nav.abac.obligation.action.log"));

        assertThat(obligation.getAttributeAssignments().size(), is(2));
        AttributeAssignment assignment = obligation.getAttributeAssignments().get(0);
        assertThat(assignment.getAttributeId(), is("no.nav.abac.advice.fritekst"));
        assertThat(assignment.getValue(), is("Mangler konsument (consumerId)"));
        assertThat(assignment.getCategory(), is("urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:subject-category:access-subject"));
        assertThat(assignment.getDataType(), is("http://www.w3.org/2001/XMLSchema#string"));

        assignment = obligation.getAttributeAssignments().get(1);
        assertThat(assignment.getAttributeId(), is("no.nav.abac.advice.fritekst2"));
        assertThat(assignment.getValue(), is("Mangler konsument (consumerId)2"));
        assertThat(assignment.getCategory(), is("urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:subject-category:access-subject2"));
        assertThat(assignment.getDataType(), is("http://www.w3.org/2001/XMLSchema#string2"));
    }

    @Test
    public void mapsObligationWithOneAttributeAssignment() {
        Obligation obligation = result.getObligations().get(1);
        assertThat(obligation.getId(), is("no.nav.abac.obligation.action.auditlog1"));

        assertThat(obligation.getAttributeAssignments().size(), is(1));
        AttributeAssignment assignment = obligation.getAttributeAssignments().get(0);
        assertThat(assignment.getAttributeId(), is("no.nav.abac.advice.fritekst"));
        assertThat(assignment.getValue(), is("Mangler autentiseringsNivaa (authenticationLevel)"));
        assertThat(assignment.getCategory(), is("urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:subject-category:access-subject"));
        assertThat(assignment.getDataType(), is("http://www.w3.org/2001/XMLSchema#string"));
    }

    @Test
    public void mapsObligationWithZeroAttributeAssignments() {
        Obligation obligation = result.getObligations().get(2);
        assertThat(obligation.getId(), is("no.nav.abac.obligation.action.auditlog2"));
        assertThat(obligation.getAttributeAssignments().size(), is(0));
    }

    @Test
    public void mapsAdviceWithAttributeAssignment() {
        Advice advice = result.getAdvices().get(0);
        assertThat(advice.getId(), is("no.nav.abac.advice.ingen_tilgang"));

        assertThat(advice.getAttributeAssignments().size(), is(1));
        AttributeAssignment assignment = advice.getAttributeAssignments().get(0);
        assertThat(assignment.getAttributeId(), is("no.nav.abac.advice.fritekst"));
        assertThat(assignment.getValue(), is("Mangler konsument (consumerId)"));
        assertThat(assignment.getCategory(), is("urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:subject-category:access-subject"));
        assertThat(assignment.getDataType(), is("http://www.w3.org/2001/XMLSchema#string"));
    }
}
