package ru.perm.v.animals.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.perm.v.animals.model.CountryDB;
import ru.perm.v.animals.service.CountryService;

@SpringBootTest
class CountryServiceImplTest {

    @Autowired
    CountryService countryService;

    @Test
    void getAll() {
        List<CountryDB> countries = countryService.getAll();
        assertEquals(2, countries.size());

        CountryDB country0 = new CountryDB(0L, "Россия");
        assertEquals(0L, countries.get(0).getId());
        assertEquals(country0, countries.get(0));
    }

    @Test
    void getById() {
        CountryDB countryDB = countryService.getById(100L);
        assertEquals(100L, countryDB.getId());
    }
}
