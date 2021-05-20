package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(1, "b"),
                new Item(3, "c"),
                new Item(2, "a")
        );
        System.out.println(items);
        Collections.sort(items);
        System.out.println("Результат возрастающей сортировки по Id:");
        System.out.println(items);
        Collections.sort(items, Collections.reverseOrder());
        System.out.println("Результат убывающей сортировки по Id:");
        System.out.println(items);
        Collections.sort(items, new SortBuNameItem());
        System.out.println("Результат возрастающей сортировки по Name:");
        System.out.println(items);
        Collections.sort(items, new SortBuNameItem().reversed());
        System.out.println("Результат убывающей сортировки по Name:");
        System.out.println(items);
    }
}
