package no.nav.abac.spring.consumer;

public class AbacTestResponse {
    public static final String TEST_FULL_RESPONSE = "{\n" +
            "  \"Response\": {\n" +
            "    \"Decision\": \"Permit\",\n" +
            "    \"Status\": {\n" +
            "      \"StatusCode\": {\n" +
            "        \"Value\": \"urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:status:ok\",\n" +
            "        \"StatusCode\": {\n" +
            "          \"Value\": \"urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:status:ok\"\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"Obligations\": [\n" +
            "      {\n" +
            "        \"Id\": \"no.nav.abac.obligation.action.log\",\n" +
            "        \"AttributeAssignment\": [\n" +
            "          {\n" +
            "            \"AttributeId\": \"no.nav.abac.advice.fritekst\",\n" +
            "            \"Value\": \"Mangler konsument (consumerId)\",\n" +
            "            \"Category\": \"urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:subject-category:access-subject\",\n" +
            "            \"DataType\": \"http://www.w3.org/2001/XMLSchema#string\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"AttributeId\": \"no.nav.abac.advice.fritekst2\",\n" +
            "            \"Value\": \"Mangler konsument (consumerId)2\",\n" +
            "            \"Category\": \"urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:subject-category:access-subject2\",\n" +
            "            \"DataType\": \"http://www.w3.org/2001/XMLSchema#string2\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"Id\": \"no.nav.abac.obligation.action.auditlog1\",\n" +
            "        \"AttributeAssignment\": {\n" +
            "          \"AttributeId\": \"no.nav.abac.advice.fritekst\",\n" +
            "          \"Value\": \"Mangler autentiseringsNivaa (authenticationLevel)\",\n" +
            "          \"Category\": \"urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:subject-category:access-subject\",\n" +
            "          \"DataType\": \"http://www.w3.org/2001/XMLSchema#string\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"Id\": \"no.nav.abac.obligation.action.auditlog2\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"AssociatedAdvice\": {\n" +
            "      \"Id\": \"no.nav.abac.advice.ingen_tilgang\",\n" +
            "      \"AttributeAssignment\": {\n" +
            "        \"AttributeId\": \"no.nav.abac.advice.fritekst\",\n" +
            "        \"Value\": \"Mangler konsument (consumerId)\",\n" +
            "        \"Category\": \"urn:oasis:names:tc:no.nav.pensjon.abac.core.xacml:1.0:subject-category:access-subject\",\n" +
            "        \"DataType\": \"http://www.w3.org/2001/XMLSchema#string\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"PolicyIdentifierList\": {\n" +
            "      \"PolicyIdReference\": [\n" +
            "        {\n" +
            "          \"Id\": \"http://axiomatics.com/alfa/identifier/no.nav.abac.policies.felles.sjekk_obligatoriske_attributter\",\n" +
            "          \"Version\": \"1.0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Id\": \"http://axiomatics.com/alfa/identifier/no.nav.abac.policies.eksempeldomene.eksempel.eksternbruker.uttaksplan\",\n" +
            "          \"Version\": \"1.0\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"PolicySetIdReference\": [\n" +
            "        {\n" +
            "          \"Id\": \"http://axiomatics.com/alfa/identifier/no.nav.abac.policies.eksempeldomene.eksempel\",\n" +
            "          \"Version\": \"1.0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Id\": \"http://axiomatics.com/alfa/identifier/no.nav.abac.policies.root_policy\",\n" +
            "          \"Version\": \"1.0\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
