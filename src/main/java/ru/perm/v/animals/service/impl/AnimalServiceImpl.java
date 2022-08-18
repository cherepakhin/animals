package ru.perm.v.animals.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.Animal;
import ru.perm.v.animals.repo.AnimalRepository;
import ru.perm.v.animals.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getById(Long id) {
        Animal animal = animalRepository.getById(id);
        System.out.println(animal);
        return animal;
    }
}
