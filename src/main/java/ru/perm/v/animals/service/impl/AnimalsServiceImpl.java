package ru.perm.v.animals.service.impl;

import static java.util.Arrays.asList;

import java.util.Comparator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.Animal;
import ru.perm.v.animals.service.AnimalsService;

@Service
@Slf4j
public class AnimalsServiceImpl implements AnimalsService {

    List<Animal> animals = asList(
        new Animal(2L, "Two"),
        new Animal(1L, "One"),
        new Animal(3L, "Three")
    );

    @Override
    public List<Animal> getAll() {
        animals.sort(Comparator.comparing(Animal::getId));
        return animals;
    }

    @Override
    public Animal getById(Long id) {
        return animals.stream().filter(a -> a.getId().equals(id)).findFirst().get();
    }
}
