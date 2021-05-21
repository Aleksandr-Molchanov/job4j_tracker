package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void whenSortingInAscendingOrder() {
        SortBuNameItem sort = new SortBuNameItem();
        Item item1 = new Item(1, "b");
        Item item2 = new Item(3, "c");
        Item item3 = new Item(2, "a");
        List<Item> items = Arrays.asList(item1, item2, item3);
        List<Item> expect = Arrays.asList(item3, item1, item2);
        items.sort(new SortBuNameItem());
        assertEquals(items, expect);
    }

    @Test
    public void whenSortingInDescendingOrder() {
        SortBuNameItem sort = new SortBuNameItem();
        Item item1 = new Item(1, "b");
        Item item2 = new Item(3, "c");
        Item item3 = new Item(2, "a");
        List<Item> items = Arrays.asList(item1, item2, item3);
        List<Item> expect = Arrays.asList(item2, item1, item3);
        items.sort(new SortBuNameItem().reversed());
        assertEquals(items, expect);
    }
}