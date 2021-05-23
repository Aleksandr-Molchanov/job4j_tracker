package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] l = left.split("\\.");
        String[] r = right.split("\\.");
        int numL = Integer.parseInt(l[0]);
        int numR = Integer.parseInt(r[0]);
        return Integer.compare(numL, numR);
    }
}