package no.nav.abac.spring.consumer;

import no.nav.abac.core.dto.request.XacmlAttribute;
import no.nav.abac.core.dto.request.XacmlRequest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import no.nav.abac.spring.exception.JsonMarshallingException;
import org.springframework.util.ObjectUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class AbacRequestMapper {

    String map(XacmlRequest request) {
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            JsonGenerator generator = new JsonFactory().createGenerator(stream);

            generator.writeStartObject();
            generator.writeFieldName("Request");
            generator.writeStartObject();

            writeXacmlAttributes(request.getResources(), "Resource", generator);
            writeXacmlAttributes(request.getAccessSubjects(), "AccessSubject", generator);
            writeXacmlAttributes(request.getActions(), "Action", generator);
            writeXacmlAttributes(request.getEnvironments(), "Environment", generator);

            generator.writeEndObject();
            generator.writeEndObject();
            generator.close();

            return new String(stream.toByteArray());
        } catch (IOException e) {
            throw new JsonMarshallingException("Failed to write request as Json", e);
        }
    }

    private void writeXacmlAttributes(List<XacmlAttribute> attributes, String group, JsonGenerator generator) throws IOException {
        if (!ObjectUtils.isEmpty(attributes)) {
            generator.writeFieldName(group);
            generator.writeStartObject();
            generator.writeArrayFieldStart("Attribute");

            for (XacmlAttribute attribute : attributes) {
                generator.writeStartObject();
                generator.writeObjectField("AttributeId", attribute.getAttributeId());
                generator.writeObjectField("Value", attribute.getValue());
                generator.writeEndObject();
            }

            generator.writeEndArray();
            generator.writeEndObject();
        }
    }
}
