package no.nav.autoconfigure.abac;

import no.nav.autoconfigure.serviceuser.ServiceUserProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

/**
 * Configures ABAC properties.
 *
 * Username and password can also be set via a Service user:
 * serviceuser.username = foo
 * serviceuser.password = bar
 */
@ConfigurationProperties(prefix = "abac")
public class AbacProperties implements InitializingBean {

    private final ServiceUserProperties serviceUserProperties;

    private String url;

    private String username;

    private String password;

    public AbacProperties(ServiceUserProperties serviceUserProperties) {
        this.serviceUserProperties = serviceUserProperties;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void afterPropertiesSet() throws Exception {
        if (StringUtils.hasText(getUsername()) && StringUtils.hasText(getPassword())) {
            return;
        }

        setUsername(serviceUserProperties.getUsername());
        setPassword(serviceUserProperties.getPassword());
    }
}
