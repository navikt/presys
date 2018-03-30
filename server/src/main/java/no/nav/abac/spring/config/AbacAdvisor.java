package no.nav.abac.spring.config;

import no.nav.abac.core.annotation.Abac;
import no.nav.abac.core.annotation.AbacMethodInterceptor;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class AbacAdvisor extends AbstractPointcutAdvisor {
    private static final StaticMethodMatcherPointcut POINTCUT = new StaticMethodMatcherPointcut() {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return method.isAnnotationPresent(Abac.class);
        }
    };

    private final AbacMethodInterceptor interceptor;

    AbacAdvisor(AbacMethodInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public Pointcut getPointcut() {
        return POINTCUT;
    }

    @Override
    public Advice getAdvice() {
        return interceptor;
    }
}
