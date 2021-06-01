package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "aaa", "aa", "aaaa");
        Comparator<String> cmpDescSize = (left, right) -> {
            int first = left.length();
            int second = right.length();
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(second, first);
        };
        strings.sort(cmpDescSize);
        System.out.println(strings);
    }
}
