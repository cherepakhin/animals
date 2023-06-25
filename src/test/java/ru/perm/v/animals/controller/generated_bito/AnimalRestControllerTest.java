package ru.perm.v.animals.controller.generated_bito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.perm.v.animals.controller.AnimalRestController;
import ru.perm.v.animals.controller.exception.BadRequestException;
import ru.perm.v.animals.dto.AnimalDto;
import ru.perm.v.animals.model.AnimalDB;
import ru.perm.v.animals.service.AnimalService;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class AnimalRestControllerTest {
    @Mock
    private AnimalService animalService;
    @InjectMocks
    private AnimalRestController animalRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById_shouldReturnAnimalDto() {
        AnimalDB animalDB = new AnimalDB(1L, "Lion");
        when(animalService.getById(1L)).thenReturn(animalDB);
        AnimalDto animalDto = animalRestController.getById(1L);
        Assertions.assertEquals("Lion", animalDto.getName());
    }

    @Test
    void getById_shouldThrowBadRequestException() {
        when(animalService.getById(anyLong())).thenThrow(new RuntimeException());
        Assertions.assertThrows(BadRequestException.class, () -> animalRestController.getById(1L));
    }

    @Test
    void getAll_shouldReturnListOfAnimals() {
        AnimalDB animalDB1 = new AnimalDB(1L, "Lion");
        AnimalDB animalDB2 = new AnimalDB(2L, "Tiger");
        List<AnimalDB> animalDBList = Arrays.asList(animalDB1, animalDB2);
        when(animalService.getAll()).thenReturn(animalDBList);
        List<AnimalDto> animalDtoList = animalRestController.getAll();
        Assertions.assertEquals(2, animalDtoList.size());
        Assertions.assertEquals("Lion", animalDtoList.get(0).getName());
        Assertions.assertEquals("Tiger", animalDtoList.get(1).getName());
    }
}