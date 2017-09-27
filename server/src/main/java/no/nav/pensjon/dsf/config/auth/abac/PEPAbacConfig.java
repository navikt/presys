package no.nav.pensjon.dsf.config.auth.abac;

import no.nav.abac.xacml.StandardAttributter;
import no.nav.freg.abac.core.annotation.attribute.AbacAttributeLocator;
import no.nav.freg.abac.core.annotation.attribute.ResolvingAbacAttributeLocator;
import no.nav.freg.abac.spring.config.AbacConfig;
import no.nav.freg.abac.spring.config.AbacRestTemplateConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import no.nav.abac.xacml.NavAttributter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Configuration
@Import({
        AbacConfig.class,
        AbacRestTemplateConfig.class
})
public class PEPAbacConfig {
    @Bean
    Set<String> abacDefaultEnvironment() {
        Set<String> values = new HashSet<>();
        values.add(NavAttributter.ENVIRONMENT_FELLES_PEP_ID);
        return values;
    }

    @Bean
    Set<String> abacDefaultActions() {
        Set<String> values = new HashSet<>();
        values.add(StandardAttributter.ACTION_ID);
        return values;
    }

    @Bean
    Set<String> abacDefaultSubjects() {
        Set<String> values = new HashSet<>();
        values.add(StandardAttributter.SUBJECT_ID);
        values.add(NavAttributter.SUBJECT_FELLES_SUBJECTTYPE);
        return values;
    }

    @Bean
    Set<String> abacDefaultResources() {
        Set<String> values = new HashSet<>();
        values.add(NavAttributter.RESOURCE_FELLES_DOMENE);
        return values;
    }

    @Bean
    AbacAttributeLocator fellesDomeneLocator() {
        return new ResolvingAbacAttributeLocator(NavAttributter.RESOURCE_FELLES_DOMENE, () -> "pensjon");
    }

    @Bean
    AbacAttributeLocator pepIdLocator() {
        return new ResolvingAbacAttributeLocator(NavAttributter.ENVIRONMENT_FELLES_PEP_ID, () -> "presys");
    }

    @Bean
    AbacAttributeLocator defaultActionLocator() {
        return new ResolvingAbacAttributeLocator(StandardAttributter.ACTION_ID, () -> "read");
    }

    @Bean
    AbacAttributeLocator defaultSubjectTypeLocator() {
        return new ResolvingAbacAttributeLocator(NavAttributter.SUBJECT_FELLES_SUBJECTTYPE, () -> "InternBruker");
    }

    @Bean
    AbacAttributeLocator defaultSubjectIDLocator() {
        return new ResolvingAbacAttributeLocator(StandardAttributter.SUBJECT_ID, () -> ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }
}
