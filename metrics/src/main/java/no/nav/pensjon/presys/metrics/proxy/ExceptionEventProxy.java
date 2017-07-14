package no.nav.pensjon.presys.metrics.proxy;

import no.nav.pensjon.presys.metrics.MetodeExceptionEvent;

import java.lang.reflect.Method;

public class ExceptionEventProxy extends MetricProxy {
    public ExceptionEventProxy(String name, Object object) { super(name, object); }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ProxyMetodekall metodekall = new ProxyMetodekall(object, method, args);

        String metodeNavn = method.getName();
        if (!shouldMeasureMethod(metodeNavn)) {
            return metodekall.kallMetode();
        }

        String eventName = this.name + "." + metodeNavn;

        return MetodeExceptionEvent.exceptionEventForMetode(metodekall, eventName);
    }
}