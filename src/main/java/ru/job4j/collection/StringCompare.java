package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int size = Math.min(left.length(), right.length());
        for (int index = 0; index < size; index++) {
            rsl += Integer.compare(left.charAt(index), right.charAt(index));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
            rsl += left.length() - right.length();
        }
        return rsl;
    }
}