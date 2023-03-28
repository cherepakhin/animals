package ru.perm.v.animals.java8;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

/**
 * Шпаргалка по java8
 * <p>
 * Predicate
 * Принимает на вход значение и возвращает boolean значение в качестве результата.
 * Называется Predicate, т.к. возвращает BOOLEAN(!)
 *
 * @FunctionalInterface public interface Predicate<T> {
 * boolean test(T t);
 * }
 */
public class PredicateTest {


    @Test
    void simpleUse() {
        Predicate<Integer> isNegative = i -> i < 0;
        assertTrue(isNegative.test(-6));
    }

    /**
     * Вложенный Predicate
     */
    @Test
    void useAndOr() {
        Predicate<Integer> isLess100 = i -> i < 100;
        Predicate<Integer> isGreater10 = i -> i > 10;

        assertTrue(isGreater10.and(isLess100).test(50)); // 10<50<100
        assertTrue(isGreater10.or(isLess100).test(500)); // 500<10 OR 500>100
    }
}
