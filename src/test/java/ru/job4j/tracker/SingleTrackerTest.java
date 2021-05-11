package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class SingleTrackerTest {
    @Test
    public void whenInstanceOne() {
        SingleTracker first = SingleTracker.getInstance();
        SingleTracker second = SingleTracker.getInstance();
        assertThat(first, is(second));
    }

    @Test
    public void whenInstanceNotNull() {
        SingleTracker first = SingleTracker.getInstance();
        assertNotNull(first);
    }
}