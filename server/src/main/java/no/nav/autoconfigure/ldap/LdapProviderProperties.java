package no.nav.autoconfigure.ldap;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ldap.provider")
public class LdapProviderProperties {

    // all DNs relative to ldap.basedn
    private String userDnPattern;
    private String serviceuserDnPattern;

    private String userSearchBase;
    private String userSearchFilter = "(&(objectClass=user)(sAMAccountName={0}))";

    private String groupSearchBase;
    private String groupSearchFilter = "(&(objectClass=group)(member={0}))";
    private String rolePrefix = "ROLE_";
    private boolean convertRoleToUpperCase = true;

    public String getUserDnPattern() {
        return userDnPattern;
    }

    public String getServiceuserDnPattern() {
        return serviceuserDnPattern;
    }

    public String getUserSearchBase() {
        return userSearchBase;
    }

    public String getUserSearchFilter() {
        return userSearchFilter;
    }

    public String getGroupSearchBase() {
        return groupSearchBase;
    }

    public String getGroupSearchFilter() {
        return groupSearchFilter;
    }

    public String getRolePrefix() {
        return rolePrefix;
    }

    public boolean isConvertRoleToUpperCase() {
        return convertRoleToUpperCase;
    }

    public void setUserDnPattern(String userDnPattern) {
        this.userDnPattern = userDnPattern;
    }

    public void setServiceuserDnPattern(String serviceuserDnPattern) {
        this.serviceuserDnPattern = serviceuserDnPattern;
    }

    public void setUserSearchBase(String userSearchBase) {
        this.userSearchBase = userSearchBase;
    }

    public void setUserSearchFilter(String userSearchFilter) {
        this.userSearchFilter = userSearchFilter;
    }

    public void setGroupSearchBase(String groupSearchBase) {
        this.groupSearchBase = groupSearchBase;
    }

    public void setGroupSearchFilter(String groupSearchFilter) {
        this.groupSearchFilter = groupSearchFilter;
    }

    public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }

    public void setConvertRoleToUpperCase(boolean convertRoleToUpperCase) {
        this.convertRoleToUpperCase = convertRoleToUpperCase;
    }
}
