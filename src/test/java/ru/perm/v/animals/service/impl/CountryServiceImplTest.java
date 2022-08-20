package ru.perm.v.animals.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.perm.v.animals.model.Country;
import ru.perm.v.animals.service.CountryService;

@SpringBootTest
class CountryServiceImplTest {

    @Autowired
    CountryService countryService;

    @Test
    void getAll() {
        List<Country> countries = countryService.getAll();
        assertEquals(2, countries.size());

        Country country0 = new Country();
        country0.setId(0L);
        country0.setName("Россия");
        assertEquals(0L, countries.get(0).getId());
        assertEquals(country0, countries.get(0));
    }

    @Test
    void getById() {
        Country countryDB = countryService.getById(0L);
        assertEquals(0L, countryDB.getId());
    }
}
