package ru.perm.v.animals.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.perm.v.animals.model.Animal;
import ru.perm.v.animals.service.AnimalService;
import org.springframework.test.web.servlet.request.*;

@WebMvcTest(AnimalsController.class)
class AnimalsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    AnimalService animalService;

    @Test
    void getById() {
        Animal animal = new Animal();
        Mockito.when(animalService.getById(0L)).thenReturn(animal);
//        this.mockMvc.perform();
    }
}
