package ru.perm.v.animals.controller;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Шпаргалка по Function
 */
public class FunctionTest {

    @Test
    void funcTestDoubleColon() {
        Function<String, Integer> strToIntDoubleColon = Integer::parseInt;
        assertEquals(222, strToIntDoubleColon.apply("222"));
    }

    @Test
    void funcTestPointer() {
        Function<String, Integer> strToIntStrelka = s -> Integer.parseInt(s);
        assertEquals(222, strToIntStrelka.apply("222"));
    }

    @Test
    void funcTestLongImplement() {
        Function<String, Integer> strToIntLongImplement = new Function<String, Integer>() {
            @Override
            public Integer apply(String from) {
                return Integer.parseInt(from);
            }
        };

        assertEquals(222, strToIntLongImplement.apply("222"));
    }
}
