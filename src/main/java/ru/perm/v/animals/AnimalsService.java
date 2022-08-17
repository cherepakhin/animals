package ru.perm.v.animals;

import java.util.List;
import ru.perm.v.animals.model.Animal;

public interface AnimalsService {
    List<Animal> getAll();
    Animal getById(Long id);
}
