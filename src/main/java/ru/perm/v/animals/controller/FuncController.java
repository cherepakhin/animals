package ru.perm.v.animals.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.animals.model.Animal;

import java.util.Optional;

@RestController
@RequestMapping("/func")
@Slf4j
@Validated
public class FuncController {
    private final Function<String, Integer> strToInt = new Function<String, Integer>() {
        @Override
        public Integer apply(String from) {
            return Integer.parseInt(from);
        }
    };


    @GetMapping("/{id}")
    public String convertToInt(@PathVariable String id) {
        return strToInt.apply(id).toString();
    }

//    @GetMapping("/doublecolon/{id}")
//    public String convertToIntWithFunction(@PathVariable String id) {
//        Function<String, Integer> strToIntDoubleColon = Integer::parseInt;
//        Optional ret = Optional.of(strToIntDoubleColon.apply(id));
//        return ret.orElse("-").toString();
//    }
}
