package ru.perm.v.animals.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.perm.v.animals.service.AnimalService;

@SpringBootTest
//TODO: change to mock
@Disabled
class AnimalServiceImplTest {

    @Autowired
    AnimalService animalService;

    @Test
    void getAll() {
        assertEquals(3, animalService.getAll().size());
    }

    @Test
    void getById() {
        assertEquals(0L, animalService.getById(0L).getId());
    }
}
