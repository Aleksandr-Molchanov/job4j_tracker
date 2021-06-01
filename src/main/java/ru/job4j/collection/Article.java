package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] in = origin.split("[\\p{IsPunctuation}\\p{IsWhite_Space}]+");
        String[] ln = line.split("[\\p{IsPunctuation}\\p{IsWhite_Space}]+");
        Set<String> words = new HashSet<String>(Arrays.asList(in));
        for (String s : ln) {
            if (!words.contains(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}