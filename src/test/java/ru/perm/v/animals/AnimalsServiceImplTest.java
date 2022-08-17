package ru.perm.v.animals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AnimalsServiceImplTest {

    @Autowired
    AnimalsService animalsService;

    @Test
    void getAll() {
        assertEquals(3, animalsService.getAll().size());
    }

    @Test
    void getById() {
        assertEquals(1L,animalsService.getById(1L).getId());
    }
}