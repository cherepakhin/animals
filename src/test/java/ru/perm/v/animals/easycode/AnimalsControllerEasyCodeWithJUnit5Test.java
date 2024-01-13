package ru.perm.v.animals.easycode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.perm.v.animals.AnimalsController;
import ru.perm.v.animals.AnimalsService;
import ru.perm.v.animals.model.Animal;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AnimalsControllerEasyCodeWithJUnit5Test {

    // PROMPT:
// write junit5 test for AnimalsController.java
//    @RequestMapping("/statistic")
//// @Slf4j not used
//    @Validated
//    @AllArgsConstructor
//    public class AnimalsController {
//
//
//        private final AnimalsService animalsService;
//
//
//        @GetMapping("/")
//        public List<Animal> getAll() {
//            return animalsService.getAll();
//        }
//
//
//    }

    @Mock
    private AnimalsService animalsService;

    @InjectMocks
    private AnimalsController animalsController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<Animal> animals = Arrays.asList(
                new Animal(1L, "Cat"),
                new Animal(2L, "Dog")
        );
        when(animalsService.getAll()).thenReturn(animals);

        // Act
        List<Animal> result = animalsController.getAll();

        // Assert
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Cat", result.get(0).getName());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Dog", result.get(1).getName());
        Mockito.verify(animalsService, Mockito.times(1)).getAll();
    }
}


