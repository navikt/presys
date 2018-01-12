package no.nav.autoconfigure.serviceuser;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Serviceuser properties that can be used with ABAC and LDAP.
 */
@ConfigurationProperties(prefix = "serviceuser")
@EnableConfigurationProperties
public class ServiceUserProperties {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

