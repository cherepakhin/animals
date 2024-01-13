package ru.perm.v.animals.easycode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.perm.v.animals.AnimalsController;
import ru.perm.v.animals.AnimalsService;
import ru.perm.v.animals.model.Animal;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalsControllerEasyCodeTest {

    @Mock
    private AnimalsService animalsService;

    @InjectMocks
    private AnimalsController animalsController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(animalsController).build();
    }

    @Test
    public void testGetAll() throws Exception {
        // Arrange
        List<Animal> animals = Arrays.asList(
                new Animal(1L, "Cat"),
                new Animal(2L, "Dog")
        );
        when(animalsService.getAll()).thenReturn(animals);

        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/statistic/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Cat"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Dog"));

        // Assert
        verify(animalsService, times(1)).getAll();
    }
}
