package no.nav.abac.core.annotation.attribute;

import no.nav.abac.core.annotation.Abac;
import no.nav.abac.core.dto.request.XacmlRequest;
import no.nav.abac.core.dto.response.Decision;
import no.nav.abac.core.exception.MissingAttributeLocatorException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbacAttributePopulatorImplTest {

    private static final Set<String> DEFAULT_RESOURCES = singleton("resource");
    private static final Set<String> DEFAULT_SUBJECTS = singleton("subject");
    private static final Set<String> DEFAULT_ACTION = singleton("action");
    private static final Set<String> DEFAULT_ENVIRONMENT = singleton("environment");

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private AbacAttributeLocator resourceLocatorMock;
    private AbacAttributeLocator subjectLocatorMock;
    private AbacAttributeLocator actionLocatorMock;
    private AbacAttributeLocator environmentLocatorMock;

    @Mock
    private Abac abacMock;

    @Spy
    private XacmlRequest request;

    private AbacAttributePopulatorImpl populator;

    @Before
    public void before() {
        resourceLocatorMock = mockLocator("resource", "res");
        subjectLocatorMock = mockLocator("subject", "subj");
        actionLocatorMock = mockLocator("action", "act");
        environmentLocatorMock = mockLocator("environment", "env");

        createPopulator();

        when(abacMock.resources()).thenReturn(new Abac.Attr[] {});
        when(abacMock.subjects()).thenReturn(new Abac.Attr[] {});
        when(abacMock.actions()).thenReturn(new Abac.Attr[] {});
        when(abacMock.environments()).thenReturn(new Abac.Attr[] {});
    }

    @Test
    public void appendsFailOnIndeterminateToRequest() {
        when(abacMock.failOnIndeterminate()).thenReturn(true);

        populator.populate(request, abacMock);

        assertThat(request.isFailOnIndeterminate(), is(true));
    }

    @Test
    public void appendsBiasToRequest() {
        when(abacMock.bias()).thenReturn(Decision.NOT_APPLICABLE);

        populator.populate(request, abacMock);

        assertThat(request.getBias(), is(Decision.NOT_APPLICABLE));
    }

    @Test
    public void appendsDefaultResourcesToRequest() {
        Object obj = new Object();
        when(resourceLocatorMock.getValue()).thenReturn(obj);

        populator.populate(request, abacMock);

        assertThat(request.getResource().get("resource").getValue(), is(sameInstance(obj)));
    }

    @Test
    public void throwsExceptionWhenResourceAttributeLocatorNotFound() {
        when(resourceLocatorMock.getAttribute()).thenReturn("Test");

        createPopulator();

        expectedException.expect(MissingAttributeLocatorException.class);
        expectedException.expectMessage(containsString("resource"));

        populator.populate(request, abacMock);
    }

    @Test
    public void appendsResourceAttrWithProvidedValue() {
        Abac.Attr attr = mockAttr("key", "val");
        when(abacMock.resources()).thenReturn(new Abac.Attr[] { attr });

        createPopulator();

        populator.populate(request, abacMock);

        assertThat(request.getResource().get("key").getValue().toString(), is("val"));
    }

    @Test
    public void appendsResourceAttrWithValueFromLocator() {
        Abac.Attr attr = mockAttr("resource", "");
        when(abacMock.resources()).thenReturn(new Abac.Attr[] { attr });

        createPopulatorWithoutDefaults();

        populator.populate(request, abacMock);

        assertThat(request.getResource().get("resource").getValue().toString(), is("res"));
    }

    @Test
    public void appendsDefaultSubjectsToRequest() {
        Object obj = new Object();
        when(subjectLocatorMock.getValue()).thenReturn(obj);

        populator.populate(request, abacMock);

        assertThat(request.getAccessSubject().get("subject").getValue(), is(sameInstance(obj)));
    }

    @Test
    public void throwsExceptionWhenSubjectAttributeLocatorNotFound() {
        when(subjectLocatorMock.getAttribute()).thenReturn("Test");

        createPopulator();

        expectedException.expect(MissingAttributeLocatorException.class);
        expectedException.expectMessage(containsString("subject"));

        populator.populate(request, abacMock);
    }

    @Test
    public void appendsSubjectAttrWithProvidedValue() {
        Abac.Attr attr = mockAttr("key", "val");
        when(abacMock.subjects()).thenReturn(new Abac.Attr[] { attr });

        createPopulator();

        populator.populate(request, abacMock);

        assertThat(request.getAccessSubject().get("key").getValue().toString(), is("val"));
    }

    @Test
    public void appendsSubjectAttrWithValueFromLocator() {
        Abac.Attr attr = mockAttr("subject", "");
        when(abacMock.subjects()).thenReturn(new Abac.Attr[] { attr });

        createPopulatorWithoutDefaults();

        populator.populate(request, abacMock);

        assertThat(request.getAccessSubject().get("subject").getValue().toString(), is("subj"));
    }

    @Test
    public void appendsDefaultActionsToRequest() {
        Object obj = new Object();
        when(actionLocatorMock.getValue()).thenReturn(obj);

        populator.populate(request, abacMock);

        assertThat(request.getAction().get("action").getValue(), is(sameInstance(obj)));
    }

    @Test
    public void throwsExceptionWhenActionAttributeLocatorNotFound() {
        when(actionLocatorMock.getAttribute()).thenReturn("Test");

        createPopulator();

        expectedException.expect(MissingAttributeLocatorException.class);
        expectedException.expectMessage(containsString("action"));

        populator.populate(request, abacMock);
    }

    @Test
    public void appendsActionAttrWithProvidedValue() {
        Abac.Attr attr = mockAttr("key", "val");
        when(abacMock.actions()).thenReturn(new Abac.Attr[] { attr });

        createPopulator();

        populator.populate(request, abacMock);

        assertThat(request.getAction().get("key").getValue().toString(), is("val"));
    }

    @Test
    public void appendsActionAttrWithValueFromLocator() {
        Abac.Attr attr = mockAttr("action", "");
        when(abacMock.actions()).thenReturn(new Abac.Attr[] { attr });

        createPopulatorWithoutDefaults();

        populator.populate(request, abacMock);

        assertThat(request.getAction().get("action").getValue().toString(), is("act"));
    }

    @Test
    public void appendsDefaultEnvironmentsToRequest() {
        Object obj = new Object();
        when(environmentLocatorMock.getValue()).thenReturn(obj);

        populator.populate(request, abacMock);

        assertThat(request.getEnvironment().get("environment").getValue(), is(sameInstance(obj)));
    }

    @Test
    public void throwsExceptionWhenEnvironmentAttributeLocatorNotFound() {
        when(environmentLocatorMock.getAttribute()).thenReturn("Test");

        createPopulator();

        expectedException.expect(MissingAttributeLocatorException.class);
        expectedException.expectMessage(containsString("environment"));

        populator.populate(request, abacMock);
    }

    @Test
    public void appendsEnvironmentAttrWithProvidedValue() {
        Abac.Attr attr = mockAttr("key", "val");
        when(abacMock.environments()).thenReturn(new Abac.Attr[] { attr });

        createPopulator();

        populator.populate(request, abacMock);

        assertThat(request.getEnvironment().get("key").getValue().toString(), is("val"));
    }

    @Test
    public void appendsEnvironmentAttrWithValueFromLocator() {
        Abac.Attr attr = mockAttr("environment", "");
        when(abacMock.environments()).thenReturn(new Abac.Attr[] { attr });

        createPopulatorWithoutDefaults();

        populator.populate(request, abacMock);

        assertThat(request.getEnvironment().get("environment").getValue().toString(), is("env"));
    }

    private void createPopulator() {
        createPopulator(DEFAULT_RESOURCES, DEFAULT_SUBJECTS, DEFAULT_ACTION, DEFAULT_ENVIRONMENT);
    }

    private void createPopulatorWithoutDefaults() {
        Set<String> empty = new HashSet<>();
        createPopulator(empty,empty,empty,empty);
    }

    private void createPopulator(Set<String> defaultResources, Set<String> defaultSubjects, Set<String> defaultActions, Set<String> defaultEnvironments) {
        populator = new AbacAttributePopulatorImpl(
                asList(resourceLocatorMock, subjectLocatorMock, actionLocatorMock, environmentLocatorMock),
                defaultResources,
                defaultSubjects,
                defaultActions,
                defaultEnvironments);
    }

    private Abac.Attr mockAttr(String id, String value) {
        Abac.Attr attr = mock(Abac.Attr.class);
        when(attr.key()).thenReturn(id);
        when(attr.value()).thenReturn(value);
        return attr;
    }

    private AbacAttributeLocator mockLocator(String key, Object value) {
        AbacAttributeLocator locator = mock(AbacAttributeLocator.class);
        when(locator.getAttribute()).thenReturn(key);
        when(locator.getValue()).thenReturn(value);
        return locator;
    }
}
