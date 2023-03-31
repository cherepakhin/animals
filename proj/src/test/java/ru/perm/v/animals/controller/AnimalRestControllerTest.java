package ru.perm.v.animals.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.perm.v.animals.controller.exception.BadRequestException;
import ru.perm.v.animals.model.AnimalDB;
import ru.perm.v.animals.service.AnimalService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnimalRestController.class)
class AnimalRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    AnimalService animalService;

    AnimalRestController animalRestController;

    @Test
    void getById() throws Exception {
        Long ID = 10L;
        String NAME = "ANIMAL_10";

        AnimalDB animal = new AnimalDB(ID, NAME);

        Mockito.when(animalService.getById(ID)).thenReturn(animal);

        mockMvc.perform(get("/animal/" + ID))
                .andExpect(jsonPath("$.id").value(ID))
                .andExpect(jsonPath("$.name").value(NAME))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAll() throws Exception {
        Long ID_10 = 10L;
        String NAME_10 = "ANIMAL_10";
        AnimalDB animal_10 = new AnimalDB(ID_10, NAME_10);

        Long ID_20 = 20L;
        String NAME_20 = "ANIMAL_20";
        AnimalDB animal_20 = new AnimalDB(ID_20, NAME_20);

        Mockito.when(animalService.getAll()).thenReturn(List.of(animal_10, animal_20));

        mockMvc.perform(get("/animal/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(ID_10))
                .andExpect(jsonPath("$[0].name").value(NAME_10))
                .andExpect(jsonPath("$[1].id").value(ID_20))
                .andExpect(jsonPath("$[1].name").value(NAME_20))
                .andReturn();
    }

    /**
     * Тест WEB GET запроса
     */
    @Test
    void notFoundException() throws Exception {
        Long ID = 10L;
        Mockito.when(animalService.getById(ID)).thenThrow(new EntityNotFoundException("ERROR1"));
        mockMvc.perform(get("/animal/" + ID))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

    /**
     * Тест при Exception в сервисе
     */
    @Test
    void getByNameIfExceptionInService() {
        Long ID=1L;
        Mockito.when(animalService.getById(ID)).thenThrow(new EntityNotFoundException());
        AnimalRestController animalRestController = new AnimalRestController(animalService);
        Assertions.assertThrows(BadRequestException.class,
                () -> animalRestController.getById(ID));
    }
}
