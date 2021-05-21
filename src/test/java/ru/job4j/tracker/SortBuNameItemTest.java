package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortBuNameItemTest {

    @Test
    public void whenNamesAreEqual() {
        SortBuNameItem sort = new SortBuNameItem();
        int result = sort.compare(new Item("a"), new Item("a"));
        assertThat(result, is(0));
    }

    @Test
    public void whenFirstNameIsGreaterThanSecond() {
        SortBuNameItem sort = new SortBuNameItem();
        int result = sort.compare(new Item("c"), new Item("a"));
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstNameIsLessThanSecond() {
        SortBuNameItem sort = new SortBuNameItem();
        int result = sort.compare(new Item("a"), new Item("b"));
        assertThat(result, is(-1));
    }
}