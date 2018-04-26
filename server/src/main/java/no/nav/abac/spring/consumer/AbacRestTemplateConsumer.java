package no.nav.abac.spring.consumer;

import no.nav.abac.core.consumer.AbacConsumer;
import no.nav.abac.core.dto.request.XacmlRequest;
import no.nav.abac.core.dto.response.XacmlResponse;
import no.nav.abac.core.exception.UnexpectedHttpCodeException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static java.util.Collections.singletonList;

public class AbacRestTemplateConsumer implements AbacConsumer {

    private static final MediaType APPLICATION_XACML_AND_JSON = MediaType.parseMediaType("application/xacml+json");

    private RestTemplate restTemplate;
    private String url;
    private AbacRequestMapper requestMapper;
    private AbacResponseMapper responseMapper;

    public AbacRestTemplateConsumer(RestTemplate restTemplate, String url, AbacRequestMapper requestMapper, AbacResponseMapper responseMapper) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @Override
    public XacmlResponse evaluate(XacmlRequest requestBody) {
        HttpEntity<String> httpRequest = prepareHttpRequest(requestBody);

        ResponseEntity<String> abacResult = restTemplate.postForEntity(url, httpRequest, String.class);

        if (!abacResult.getStatusCode().is2xxSuccessful()) {
            throw new UnexpectedHttpCodeException(abacResult.getStatusCodeValue(), 200, abacResult.getStatusCode().getReasonPhrase());
        }

        return responseMapper.map(abacResult.getBody());
    }

    private HttpEntity<String> prepareHttpRequest(XacmlRequest request) {
        String requestAsJson = requestMapper.map(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_XACML_AND_JSON);
        headers.setAccept(singletonList(APPLICATION_XACML_AND_JSON));
        return new HttpEntity<>(requestAsJson, headers);
    }
}
