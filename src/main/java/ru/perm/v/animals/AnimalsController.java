package ru.perm.v.animals;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.animals.model.Animal;

@RestController
@RequestMapping("/statistic")
@Slf4j
@Validated
@AllArgsConstructor
public class AnimalsController {

    private final AnimalsService animalsService;

    @GetMapping("/")
    public List<Animal> getAll() {
        return animalsService.getAll();
    }

}
