package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    static class Builder {
        private List<Integer> source;

        Builder buildNum(List<Integer> source) {
            this.source = source;
            return this;
        }

        EasyStream build() {
            EasyStream stream = new EasyStream();
            stream.source = source;
            return stream;
        }
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder()
                .buildNum(source)
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer num : source) {
            rsl.add(fun.apply(num));
        }
        return new Builder()
                .buildNum(rsl)
                .build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer num : source) {
            if (fun.test(num)) {
                rsl.add(num);
            }
        }
        return new Builder()
                .buildNum(rsl)
                .build();
    }

    public List<Integer> collect() {
        return new ArrayList<>(source);
    }

    @Override
    public String toString() {
        return "EasyStream{"
                + "source=" + source
                + '}';
    }
}
