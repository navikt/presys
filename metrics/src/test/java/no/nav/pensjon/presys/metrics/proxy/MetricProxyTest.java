package no.nav.pensjon.presys.metrics.proxy;

import mockit.Mocked;
import no.nav.pensjon.presys.metrics.MetricsFactory;
import no.nav.pensjon.presys.metrics.Timer;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MetricProxyTest {

    @Test(expected = IOException.class)
    public void skalKasteUnderliggendeExceptionFraTjenesten(@Mocked Timer timer) throws Exception {
        Tjeneste proxy = MetricsFactory.createTimerProxy("navn", new FeilendeTjeneste(), Tjeneste.class);
        proxy.feilendeNettverkskall();
    }

    public interface Tjeneste {
        boolean feilendeNettverkskall() throws IOException;
    }

    public class FeilendeTjeneste implements Tjeneste {
        public boolean feilendeNettverkskall() throws IOException {
            throw new IOException("feil");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void proxySkalKasteIllegalStateExceptionDersomIncludeMethodsErGjortOgExcludeMethodsKalles() throws Exception {
        final EventProxy eventProxy = new EventProxy("navPaEvent", new Object());
        eventProxy.includeMethods(Collections.singletonList("enMetodeSomSkalInkluderes"));
        eventProxy.excludeMethods(Collections.singletonList("enMetodeSomSkalEkskluderes"));
    }

    @Test(expected = IllegalStateException.class)
    public void proxySkalKasteIllegalStateExceptionDersomExcludeMethodsErGjortOgIncludeMethodsKalles() throws Exception {
        final EventProxy eventProxy = new EventProxy("navPaEvent", new Object());
        eventProxy.excludeMethods(Collections.singletonList("enMetodeSomSkalEkskluderes"));
        eventProxy.includeMethods(Collections.singletonList("enMetodeSomSkalInkluderes"));
    }

    @Test
    public void skalIgnorereMetoder() {
        final EventProxy eventProxy = new EventProxy("navPaEvent", new Object());

        eventProxy.excludeMethods(Arrays.asList("metode1", "metode2"));

        assertFalse(eventProxy.shouldMeasureMethod("metode1"));
        assertFalse(eventProxy.shouldMeasureMethod("metode2"));
        assertFalse(eventProxy.shouldMeasureMethod("toString"));
        assertFalse(eventProxy.shouldMeasureMethod("hashCode"));
        assertFalse(eventProxy.shouldMeasureMethod("equals"));

        assertTrue(eventProxy.shouldMeasureMethod("metode3"));
        assertTrue(eventProxy.shouldMeasureMethod("metode4"));
    }

    @Test
    public void skalMaleValgteMetoder() {
        final EventProxy eventProxy = new EventProxy("navPaEvent", new Object());

        eventProxy.includeMethods(Arrays.asList("metode1", "metode2"));

        assertTrue(eventProxy.shouldMeasureMethod("metode1"));
        assertTrue(eventProxy.shouldMeasureMethod("metode2"));

        assertFalse(eventProxy.shouldMeasureMethod("toString"));
        assertFalse(eventProxy.shouldMeasureMethod("hashCode"));
        assertFalse(eventProxy.shouldMeasureMethod("equals"));
        assertFalse(eventProxy.shouldMeasureMethod("metode3"));
        assertFalse(eventProxy.shouldMeasureMethod("metode4"));
    }
}