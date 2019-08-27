package no.nav.ldap;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchResultEntry;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EmbeddedLdapServerTest {

    /**
     * https://docs.ldap.com/ldap-sdk/docs/in-memory-directory-server.html
     */
    @Test
    public void getEntry() throws LDAPException {
        InMemoryDirectoryServerConfig config = new InMemoryDirectoryServerConfig("dc=test,dc=local");
        disableSchemaValidation(config);
        InMemoryDirectoryServer server = new InMemoryDirectoryServer(config);
        server.importFromLDIF(true, "target/test-classes/schema.ldif");
        server.startListening();

        try (LDAPConnection connection = server.getConnection()) {
            SearchResultEntry entry = connection.getEntry("dc=test,dc=local");
            assertNotNull(entry);
        }

        server.shutDown(true);
    }

    private static void disableSchemaValidation(InMemoryDirectoryServerConfig config) {
        config.setSchema(null);
    }
}
