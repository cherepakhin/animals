package ru.perm.v.animals.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.animals.dto.CountryDto;
import ru.perm.v.animals.model.Country;
import ru.perm.v.animals.service.CountryService;

@RestController
@RequestMapping("/country")
@Slf4j
@Validated
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/")
    public List<CountryDto> getAll() {
        List<Country> countries = countryService.getAll();
        return countries.stream().map(CountryDto::new).collect(Collectors.toList());
    }
}
