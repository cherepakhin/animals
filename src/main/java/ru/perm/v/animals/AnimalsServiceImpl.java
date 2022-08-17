package ru.perm.v.animals;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.Animal;

@Service
@Slf4j
@AllArgsConstructor
public class AnimalsServiceImpl  implements AnimalsService {

    @Override
    public List<Animal> getAll() {
        Animal animal = new Animal();
        return List.of(animal);
    }
}
