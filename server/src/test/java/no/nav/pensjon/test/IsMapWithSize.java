package no.nav.pensjon.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Map;

public class IsMapWithSize<K, V> extends TypeSafeMatcher<Map<? extends K, ? extends V>> {
    private final int size;

    public IsMapWithSize(final int size) {
        this.size = size;
    }

    @Override
    public boolean matchesSafely(Map<?extends K, ? extends V> map) {
        return map.size() == size;
    }

    @Override
    public void describeMismatchSafely(Map<? extends K, ? extends V> map, Description mismatchDescription) {
        mismatchDescription.appendText("map was ").appendValue(map.size());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(" has ").appendValue(size).appendText(" key/value pairs");
    }

    public static <K, V> Matcher<Map<? extends K, ? extends V>> hasSize(final int size) {
        return new IsMapWithSize<>(size);
    }
}
