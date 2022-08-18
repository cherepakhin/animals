package ru.perm.v.animals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.perm.v.animals.service.AnimalService;

@SpringBootTest
class AnimalServiceImplTest {

    @Autowired
    AnimalService animalService;

    @Test
    void getAll() {
        assertEquals(3, animalService.getAll().size());
    }

    @Test
    void getById() {
        assertEquals(1L, animalService.getById(1L).getId());
    }
}
