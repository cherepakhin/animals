package ru.perm.v.animals.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.dto.CountryDto;
import ru.perm.v.animals.model.Country;

public interface CountryService {
    List<Country> getAll();
    Country getById(Long id);
}
