package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character ch : left.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (Character ch : right.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}