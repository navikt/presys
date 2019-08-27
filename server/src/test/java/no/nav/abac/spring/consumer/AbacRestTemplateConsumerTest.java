package no.nav.abac.spring.consumer;

import no.nav.abac.core.dto.request.XacmlRequest;
import no.nav.abac.core.dto.response.XacmlResponse;
import no.nav.abac.core.exception.UnexpectedHttpCodeException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbacRestTemplateConsumerTest {

    @Captor
    private ArgumentCaptor<HttpEntity<String>> httpEntityCaptor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private RestTemplate restTemplateMock;

    @Mock
    private AbacRequestMapper requestMapperMock;

    @Mock
    private AbacResponseMapper responseMapperMock;

    @Mock
    private XacmlRequest requestMock;

    @Mock
    private XacmlResponse responseMock;

    private AbacRestTemplateConsumer consumer;

    @Before
    public void before() {
        consumer = new AbacRestTemplateConsumer(restTemplateMock, "url", requestMapperMock, responseMapperMock);
        mockRestTemplateResponse("test", HttpStatus.OK);
    }

    @Test
    public void callsRequestMapperWithRequest() {
        consumer.evaluate(requestMock);

        verify(requestMapperMock).map(requestMock);
    }

    @Test
    public void callsRestTemplateWithHttpEntityBodyFromRequestMapper() {
        when(requestMapperMock.map(requestMock)).thenReturn("testJson");

        consumer.evaluate(requestMock);

        verify(restTemplateMock).postForEntity(eq("url"), httpEntityCaptor.capture(), eq(String.class));
        MatcherAssert.assertThat(httpEntityCaptor.getValue().getBody(), is(equalTo("testJson")));
    }

    @Test
    public void callsRestTemplateWithHttpEntityAcceptHeaderXacmlJson() {
        when(requestMapperMock.map(requestMock)).thenReturn("testJson");

        consumer.evaluate(requestMock);

        verify(restTemplateMock).postForEntity(eq("url"), httpEntityCaptor.capture(), eq(String.class));
        MatcherAssert.assertThat(httpEntityCaptor.getValue().getHeaders().getAccept(), CoreMatchers.hasItem(equalTo(MediaType.parseMediaType("application/xacml+json"))));
    }

    @Test
    public void callsRestTemplateWithHttpEntityContentTypeHeaderXacmlJson() {
        when(requestMapperMock.map(requestMock)).thenReturn("testJson");

        consumer.evaluate(requestMock);

        verify(restTemplateMock).postForEntity(eq("url"), httpEntityCaptor.capture(), eq(String.class));
        MatcherAssert.assertThat(httpEntityCaptor.getValue().getHeaders().getContentType(), equalTo(MediaType.parseMediaType("application/xacml+json")));
    }

    @Test
    public void callsRestTemplateWithConvertedResultFromRequestMapper() {
        when(requestMapperMock.map(requestMock)).thenReturn("testJson");

        consumer.evaluate(requestMock);

        verify(restTemplateMock).postForEntity(eq("url"), httpEntityCaptor.capture(), eq(String.class));
        MatcherAssert.assertThat(httpEntityCaptor.getValue().getBody(), is(equalTo("testJson")));
    }

    @Test
    public void throwsExceptionWhenStatusIsNot2xx() {
        mockRestTemplateResponse("b", HttpStatus.BAD_REQUEST);

        expectedException.expect(UnexpectedHttpCodeException.class);
        expectedException.expectMessage(containsString("400"));

        consumer.evaluate(requestMock);
    }

    @Test
    public void callsResponseMapperWithBodyWhenStatus2xx() {
        mockRestTemplateResponse("test", HttpStatus.OK);

        consumer.evaluate(requestMock);

        verify(responseMapperMock).map("test");
    }

    @Test
    public void returnsResultFromResponseMapper() {
        when(responseMapperMock.map(anyString())).thenReturn(responseMock);

        XacmlResponse result = consumer.evaluate(requestMock);

        assertThat(result, is(sameInstance(responseMock)));
    }

    private void mockRestTemplateResponse(String body, HttpStatus status) {
        ResponseEntity<String> entity = new ResponseEntity<>(body, status);
        when(restTemplateMock.postForEntity(anyString(), any(), eq(String.class))).thenReturn(entity);
    }
}
