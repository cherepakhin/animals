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
    void funcTestPointerTwoParam() {

        int radix = 16;
        Function<String, Integer> strToIntStrelka = s -> Integer.parseInt(s, radix);
        assertEquals(255, strToIntStrelka.apply("FF"));
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

    @Test
    void showFunctionAndThen_AndCompose() {
        Function<String, String> f1 = s -> s + "1";
        Function<String, String> f2 = s -> s + "2";
        Function<String, String> f3 = s -> s + "3";
        Function<String, String> f4 = s -> s + "4";
        assertEquals("Compose4312", f1.andThen(f2).compose(f3).compose(f4).apply("Compose"));
        assertEquals("AndThen123", f1.andThen(f2).andThen(f3).apply("AndThen"));
    }
}
