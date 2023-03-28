package ru.perm.v.animals.controller;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.animals.dto.CountryDto;
import ru.perm.v.animals.model.CountryDB;
import ru.perm.v.animals.service.CountryService;

/**
 * Страна
 */
@RestController
@RequestMapping("/country")
@Slf4j
@Validated
@AllArgsConstructor
public class CountryRestController {

    private CountryService countryService;

    @GetMapping("/")
    public List<CountryDto> getAll() {
        log.info("get /country/getAll");
        List<CountryDB> countries = countryService.getAll();
        return countries.stream()
                .map(country -> new CountryDto(country.getId(), country.getName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CountryDto getById(@PathVariable Long id) {
        log.info("get /country/" + id);
        CountryDB country = countryService.getById(id);
        return new CountryDto(country.getId(), country.getName());
    }
}
