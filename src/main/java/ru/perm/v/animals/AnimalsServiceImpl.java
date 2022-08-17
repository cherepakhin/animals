package ru.perm.v.animals;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.Animal;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@Service
@Slf4j
public class AnimalsServiceImpl implements AnimalsService {

    List<Animal> animals = asList(
            new Animal(1L, "One"),
            new Animal(2L, "Two"),
            new Animal(3L, "Three")
    );

    @Override
    public List<Animal> getAll() {
        return animals;
    }

    @Override
    public Animal getById(Long id) {
        List<Animal> aa = Stream.of(animals).findFirst().get();
        return null;
    }
}
