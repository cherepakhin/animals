package ru.perm.v.animals.controller.generated_gpt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.perm.v.animals.controller.AnimalRestController;
import ru.perm.v.animals.controller.exception.AnimalNotFoundException;
import ru.perm.v.animals.controller.exception.BadRequestException;
import ru.perm.v.animals.dto.AnimalDto;
import ru.perm.v.animals.model.AnimalDB;
import ru.perm.v.animals.service.AnimalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GenGptAnimalRestControllerTest {

    @Mock
    private AnimalService animalService;

    @Test
    public void testGetAll() {
        // Arrange
        List<AnimalDB> animalDBList = new ArrayList<>();
        animalDBList.add(new AnimalDB(1L, "Lion"));
        animalDBList.add(new AnimalDB(2L, "Elephant"));
        Mockito.when(animalService.getAll()).thenReturn(animalDBList);
        AnimalRestController animalRestController = new AnimalRestController(animalService);
        // Act
        List<AnimalDto> animalDtoList = animalRestController.getAll();

        // Assert
        assertEquals(2, animalDtoList.size());
        AnimalDto a0 = animalDtoList.get(0);
        Long id = a0.getId();
        assertEquals(1L, id);
        assertEquals("Lion", animalDtoList.get(0).getName());
//        assertEquals(2L, animalDtoList.get(1).getId());
//        assertEquals("Elephant", animalDtoList.get(1).getName());
    }

    @Test
    public void testGetById() {
        // Arrange
        AnimalDB animalDB = new AnimalDB(1L, "Lion");
        Mockito.when(animalService.getById(1L)).thenReturn(animalDB);
        AnimalRestController animalRestController = new AnimalRestController(animalService);

        // Act
        AnimalDto animalDto = animalRestController.getById(1L);

        // Assert
        assertEquals(Optional.of(1L), java.util.Optional.ofNullable(animalDto.getId()));
        assertEquals("Lion", animalDto.getName());
    }

    @Test(expected = MockitoException.class)
    public void testGetByIdNotFound() {
        AnimalRestController animalRestController = new AnimalRestController(animalService);
        // Arrange
        Mockito.when(animalService.getById(1L)).thenThrow(new Exception());

        // Act
        animalRestController.getById(1L);
    }

    @Test(expected = BadRequestException.class)
    public void testGetByIdNotFoundWithResponseStatus() {
        AnimalRestController animalRestController = new AnimalRestController(animalService);
        // Arrange
        @ResponseStatus(HttpStatus.NOT_FOUND)
        class AnimalNotFoundExceptionWithResponseStatus extends AnimalNotFoundException {
            public AnimalNotFoundExceptionWithResponseStatus(Long id) {
                super(id);
            }
        }

        Mockito.when(animalService.getById(1L)).thenThrow(new AnimalNotFoundExceptionWithResponseStatus(1L));

        // Act
        animalRestController.getById(1L);
    }
}