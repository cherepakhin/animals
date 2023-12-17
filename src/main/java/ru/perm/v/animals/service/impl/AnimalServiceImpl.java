package ru.perm.v.animals.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.AnimalDB;
import ru.perm.v.animals.repo.AnimalRepository;
import ru.perm.v.animals.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;

    @Override
    public List<AnimalDB> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public AnimalDB getById(Long id) {
        return animalRepository.getById(id);
    }
}
