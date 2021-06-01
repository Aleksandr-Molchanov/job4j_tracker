package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
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
            } else if (map.containsKey(ch) && map.get(ch) == 1) {
                map.remove(ch);
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return map.size() == 0;
    }
}