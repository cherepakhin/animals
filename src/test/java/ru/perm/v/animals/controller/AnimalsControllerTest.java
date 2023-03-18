package ru.perm.v.animals.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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
    void getById() throws Exception {
        Long ID = 10L;
        String NAME="ANIMAL_10";
        Animal animal = new Animal();
        animal.setId(ID);
        animal.setName("ANIMAL_10");
        Mockito.when(animalService.getById(ID)).thenReturn(animal);

        mockMvc.perform(get("/animal/"+ID))
                .andExpect(jsonPath("$.id").value(ID))
                .andExpect(jsonPath("$.name").value(NAME))
                .andExpect(status().isOk())
                .andReturn();
    }
}
