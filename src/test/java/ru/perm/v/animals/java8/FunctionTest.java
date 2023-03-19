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
    void funcParamResult() {
        // input: Integer, result: String
        Function<Integer, String> fIntToStr = inputInt -> "Result" + inputInt;
        assertEquals("Result100", fIntToStr.apply(100));

        Function<String, String> f1 = s -> "1" + s;
        Function<String, String> f2 = s -> "2" + s;
        assertEquals("12Compose", f1.compose(f2)
                .apply("Compose"));
        assertEquals("21AndThen", f1.andThen(f2)
                .apply("AndThen"));


        // input: String, result: Integer
        // parseInputStrAndAddToInt100 это ФУНКЦИЯ
        Function<String, Integer> parseInputStrAndAddToInt100 = s -> 100 + Integer.parseInt(s);
        // Применение назначенного метода через apply()
        assertEquals(102, parseInputStrAndAddToInt100.apply("2"));
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
    void showFunctionAndThen_AndCompose() {
//        Function<String, String> f2 = s -> "2"+ s;
//        Function<String, String> f3 = s -> "3"+ s;
//        Function<String, String> f4 = s -> "4"+ s;
//        assertEquals("12Compose", f1.compose(f2)
//                .apply("Compose"));


//        Function<String, String> f3 = s -> "3"+ s;
//        Function<String, String> f4 = s -> "4"+ s;
//        assertEquals("1234Compose", f1.compose(f2).compose(f3).compose(f4)
//                .apply("Compose"));
//        assertEquals("4321AndThen", f1.andThen(f2).andThen(f3).andThen(f4)
//                .apply("AndThen"));
    }
}
