package ru.perm.v.animals.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Просто тренировка Function
 */
class FuncControllerTest {

    @Test
    void convertToInt() {
        FuncController funcController = new FuncController();
        assertEquals("1", funcController.convertToInt("1"));
    }

    @Test
    void funtTest() {
        Function<String, Integer> strToInt1 = Integer::parseInt;
        assertEquals(222, strToInt1.apply("222"));
    }

    @Test
    void funtTestPointer() {
        Function<String, Integer> myStrToInt = s -> Integer.parseInt(s);
        assertEquals(222, myStrToInt.apply("222"));
    }


//    @Test
//    void convertToIntWithFunction() {
//        FuncController funcController = new FuncController();
//        assertEquals("1", funcController.convertToIntWithFunction("1"));
//    }
//    @Test
//    void convertToIntWithFunctionError() {
//        FuncController funcController = new FuncController();
//        assertEquals("2", funcController.convertToIntWithFunction(""));
//    }
}