package ru.perm.v.animals.controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.perm.v.animals.dto.CountryDto;
import ru.perm.v.animals.model.CountryDB;
import ru.perm.v.animals.service.CountryService;

import java.util.List;

import static org.mockito.Mockito.mock;

@WebMvcTest(CountryRestController.class)
public class CountryRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getById() {
        CountryService countryService = mock(CountryService.class);
        CountryRestController countryController = new CountryRestController(countryService);
        Long COUNTRY_ID = 10L;

        CountryDB country = new CountryDB();
        country.setId(COUNTRY_ID);

        Mockito.when(countryService.getById(COUNTRY_ID)).thenReturn(country);
        CountryDto receiveCountry = countryController.getById(COUNTRY_ID);
        Assertions.assertEquals(COUNTRY_ID, receiveCountry.getId());
    }

    @Test
    public void getAll() {
        CountryService countryService = mock(CountryService.class);
        CountryRestController countryController = new CountryRestController(countryService);
        Long COUNTRY_ID_10 = 10L;
        Long COUNTRY_ID_20 = 20L;

        CountryDB country_10 = new CountryDB();
        country_10.setId(COUNTRY_ID_10);

        CountryDB country_20 = new CountryDB();
        country_20.setId(COUNTRY_ID_20);

        Mockito.when(countryService.getAll()).thenReturn(List.of(country_10, country_20));
        List<CountryDto> receiveCountries = countryController.getAll();
        Assertions.assertEquals(2, receiveCountries.size());
        CountryDto countryDto = new CountryDto(COUNTRY_ID_10,"");
        Assertions.assertEquals(countryDto, receiveCountries.get(0));
    }
}
