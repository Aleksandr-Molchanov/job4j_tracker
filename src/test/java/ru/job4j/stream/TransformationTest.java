package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TransformationTest {

    @Test
    public void transform() {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        Transformation tr = new Transformation();
        List<Integer> rsl = tr.transform(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(rsl, is(expected));
    }
}