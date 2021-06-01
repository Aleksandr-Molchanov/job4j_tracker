package ru.job4j.function;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            int first = left.length();
            int second = right.length();
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(second, first);
        };
    }
}
