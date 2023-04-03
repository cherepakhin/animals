package ru.perm.v.animals.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.animals.controller.exception.BadRequestException;
import ru.perm.v.animals.dto.AnimalDto;
import ru.perm.v.animals.model.AnimalDB;
import ru.perm.v.animals.service.AnimalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
@Slf4j
@Validated
@AllArgsConstructor
public class AnimalRestController {

    private final AnimalService animalService;

    @GetMapping("/")
    public List<AnimalDto> getAll() {
        log.info("get /animal/getAll");
        return animalService
                .getAll()
                .stream()
                .map(animalDB -> new AnimalDto(animalDB.getId(), animalDB.getName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AnimalDto getById(@PathVariable Long id) {
        log.info("get /animal/" + id);
        try {
            AnimalDB animal = animalService.getById(id);
            return new AnimalDto(animal.getId(), animal.getName());
        } catch (Exception e) {
            throw new BadRequestException(String.format("Animal not found id=%d. (Exception message: %s)", id, e.getMessage()));
        }
    }
}
