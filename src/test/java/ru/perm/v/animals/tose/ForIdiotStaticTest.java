package ru.perm.v.animals.tose;

import org.junit.jupiter.api.Test;
import ru.perm.v.animals.dto.AnimalDto;

import static org.junit.Assert.assertEquals;

public class ForIdiotStaticTest {

    @Test
    void staticTest() {
        AnimalDto animalDto1 = new AnimalDto(1L,"DTO1", "STATIC1");

        assertEquals("STATIC1", animalDto1.staticString);

        // staticString переменная КЛАССА. При изменении меняется во всех ЭКЗЕМПЛЯРАХ
        // "STATIC1" -> "STATIC2"
        AnimalDto animalDto2 = new AnimalDto(1L,"DTO1", "STATIC2");
        assertEquals("STATIC2", animalDto2.staticString);
        assertEquals("STATIC2", AnimalDto.staticString);

        animalDto2.staticString = "ЧУШЬ";
        assertEquals("ЧУШЬ", animalDto1.staticString);
        assertEquals("ЧУШЬ", animalDto2.staticString);
        assertEquals("ЧУШЬ", AnimalDto.staticString);
    }
}
