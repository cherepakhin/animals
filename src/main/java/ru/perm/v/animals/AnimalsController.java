package ru.perm.v.animals;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.animals.model.Animal;

import java.util.List;

@RestController
@RequestMapping("/statistic")
// @Slf4j not used
@Validated
@AllArgsConstructor
public class AnimalsController {

    private final AnimalsService animalsService;

    @GetMapping("/")
    public List<Animal> getAll() {
        return animalsService.getAll();
    }

}
