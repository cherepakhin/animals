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
}
