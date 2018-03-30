package no.nav.abac.core.dto.request;

import no.nav.abac.core.dto.response.Decision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XacmlRequest {
    private Map<String, XacmlAttribute> resource = new HashMap<>();
    private Map<String, XacmlAttribute> accessSubject = new HashMap<>();
    private Map<String, XacmlAttribute> action = new HashMap<>();
    private Map<String, XacmlAttribute> environment = new HashMap<>();
    private boolean failOnIndeterminate = false;
    private Decision bias;

    public XacmlRequest resource(String id, Object value) {
        resource.put(id, new XacmlAttribute(id, value));
        return this;
    }

    public XacmlRequest accessSubject(String id, Object value) {
        accessSubject.put(id, new XacmlAttribute(id, value));
        return this;
    }

    public XacmlRequest action(String id, Object value) {
        action.put(id, new XacmlAttribute(id, value));
        return this;
    }

    public XacmlRequest environment(String id, Object value) {
        environment.put(id, new XacmlAttribute(id, value));
        return this;
    }

    public XacmlRequest bias(Decision bias) {
        this.bias = bias;
        return this;
    }

    public XacmlRequest failOnIndeterminate(boolean val) {
        this.failOnIndeterminate = val;
        return this;
    }

    public boolean isFailOnIndeterminate() {
        return failOnIndeterminate;
    }

    public Map<String, XacmlAttribute> getResource() {
        return resource;
    }

    public Map<String, XacmlAttribute> getAccessSubject() {
        return accessSubject;
    }

    public Map<String, XacmlAttribute> getAction() {
        return action;
    }

    public Map<String, XacmlAttribute> getEnvironment() {
        return environment;
    }

    public Decision getBias() {
        return bias;
    }

    public List<XacmlAttribute> getResources() {
        return new ArrayList<>(resource.values());
    }

    public List<XacmlAttribute> getAccessSubjects() {
        return new ArrayList<>(accessSubject.values());
    }

    public List<XacmlAttribute> getActions() {
        return new ArrayList<>(action.values());
    }

    public List<XacmlAttribute> getEnvironments() {
        return new ArrayList<>(environment.values());
    }
}
