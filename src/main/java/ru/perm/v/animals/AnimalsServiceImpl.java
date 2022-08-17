package ru.perm.v.animals;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.Animal;

@Service
@Slf4j
@AllArgsConstructor
public class AnimalsServiceImpl implements AnimalsService {

    List<Animal> animals = new ArrayList<>();

    public AnimalsServiceImpl() {
        animals.addAll(List.of(
            new Animal(1L, "One"),
            new Animal(2L, "Two"),
            new Animal(3L, "Three")
        ));
    }

    @Override
    public List<Animal> getAll() {
        return animals;
    }
}
