package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int size = Math.min(first.length, second.length);
        rsl = second[0].compareTo(first[0]);
        if (rsl != 0) {
            return rsl;
        } else {
            for (int index = 1; index < size; index++) {
                rsl = first[index].compareTo(second[index]);
            }
            if (rsl == 0) {
                rsl = Integer.compare(first.length, second.length);
            }
        }
        return rsl;
    }
}