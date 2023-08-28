package ru.perm.v.animals;

import org.junit.jupiter.api.Test;
import ru.perm.v.animals.dto.AnimalDto;

import static org.junit.Assert.assertEquals;

public class AnimalDTOStaticTest {

    @Test
    void staticTest() {
        AnimalDto animalDto1 = new AnimalDto(1L,"DTO1", "STATIC1");

        // staticString переменная КЛАССА. При изменении меняется во всех ЭКЗЕМПЛЯРАХ
        // "STATIC1" -> "STATIC2"
        AnimalDto animalDto2 = new AnimalDto(1L,"DTO1", "STATIC2");

        assertEquals("STATIC2", animalDto1.staticString);
        assertEquals("STATIC2", animalDto2.staticString);
        assertEquals("STATIC2", AnimalDto.staticString);
    }
}
