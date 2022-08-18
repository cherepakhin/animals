package ru.perm.v.animals.controller;

import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.animals.dto.AnimalDto;
import ru.perm.v.animals.model.Animal;

import java.util.List;
import ru.perm.v.animals.service.AnimalService;

@RestController
@RequestMapping("/animal")
@Slf4j
@Validated
@AllArgsConstructor
public class AnimalsController {

    private final AnimalService animalService;

    @GetMapping("/")
    public List<AnimalDto> getAll() {
        return animalService.getAll().stream().map(AnimalDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AnimalDto getById(@PathVariable Long id) {
        Animal animal = animalService.getById(id);
        return new AnimalDto(animal);
    }
}
