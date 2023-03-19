package ru.perm.v.animals.java8;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Шпаргалка по java8
 * <p>
 * Function
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
    void testFuncAndParam() {
        // input: Integer, result: String
        Function<Integer, String> fIntToStr = inputInt -> "Result" + inputInt;
        assertEquals("Result100", fIntToStr.apply(100));

    }

    @Test
    void showDoubleColon() {
        Converter<String, Integer> converterStrToInt = Integer::valueOf;
        assertEquals(123, converterStrToInt.convert("123"));
    }

    @Test
    void showFunctionalInterfaceSimple() {
        // Назначил функцию  ЕДИНСТВЕННОМУ методу интерфейса и ТУТ ЖЕ создал экземпляр нового класса
        // Исользовано "::"
        FunctionalInterfaceSimple<String, Integer> converterStrToInt = Integer::valueOf;
        assertEquals(123, converterStrToInt.convertFromTo("123"));
    }

    @Test
    void showFunction_AndThen_AndCompose() {
        Function<String, String> f1 = s -> s + "1";
        Function<String, String> f2 = s -> s + "2";
        Function<String, String> f3 = s -> s + "3";
        Function<String, String> f_end = s -> "End" + s;

        // К параметру в apply применить от f1 до f3
        // В нормальном, ПРЯМОМ направлении
        assertEquals("AndThen123", f1.andThen(f2).andThen(f3).apply("AndThen"));

        // К параметру в apply применить от f3 до f1.
        // Именно в ОБРАТНОМ направлении!
        assertEquals("Compose321", f1.compose(f2).compose(f3).apply("Compose"));

        // input: String, result: Integer
        // parseInputStrAndAddToInt100 это ФУНКЦИЯ
        Function<String, Integer> parseInputStr_And_AddInt100 = s -> 100 + Integer.parseInt(s);
        // Применение назначенного метода через apply()
        assertEquals(102, parseInputStr_And_AddInt100.apply("2"));
    }
}
