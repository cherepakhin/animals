package ru.perm.v.animals.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.animals.model.Animal;

import java.util.List;
import ru.perm.v.animals.service.AnimalService;

@RestController
@RequestMapping("/statistic")
@Slf4j
@Validated
@AllArgsConstructor
public class AnimalsController {

    private final AnimalService animalService;

    @GetMapping("/")
    public List<Animal> getAll() {
        return animalService.getAll();
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id) {
        Animal animal = animalService.getById(id);
        System.out.println(animal);
        return animal;
    }
}