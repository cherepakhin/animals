package ru.perm.v.animals;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class J8Test {

    interface Operationable {
        int calculate(int x, int y);
    }

    @Test
    public void lambdaTest() {
        // Для общего случая так:
        Operationable operation = (x, y) -> x + y;
        // а так в ДАННОМ случае проще
        operation = Integer::sum;
        assertEquals(6, operation.calculate(2, 3));
    }

    @Test
    void patterMatchTest() {
        String EXAMPLE_TEST = "This is my small example string which I'm going to "
                + "use for pattern matching.";
        assertTrue(EXAMPLE_TEST.matches("\\w.*"));

        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
        assertEquals(14, splitString.length); // 14 слов
        assertEquals("This", splitString[0]);
        assertEquals("matching.", splitString[13]);
        String replacedSpaseToTab = EXAMPLE_TEST.replaceAll("\\s+", "\t");
        assertEquals(-1, replacedSpaseToTab.indexOf(" "));

        assertTrue("True".matches("[tT]rue|[yY]es"));

        assertTrue("8,9".matches(".*\\d.*"));
    }

    @Test
    void findMatcher() {
        String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
        assertEquals(15, count);
    }
}
