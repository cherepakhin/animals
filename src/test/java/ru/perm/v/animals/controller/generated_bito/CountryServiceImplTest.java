package ru.perm.v.animals.controller.generated_bito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ru.perm.v.animals.model.CountryDB;
import ru.perm.v.animals.repo.CountryRepository;
import ru.perm.v.animals.service.impl.CountryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {
    @Mock
    private CountryRepository countryRepository;
    @InjectMocks
    private CountryServiceImpl countryService;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetById() {
        List<CountryDB> countries = new ArrayList<>();
        CountryDB country1 = new CountryDB(1L, "Russia");
        CountryDB country2 = new CountryDB(2L, "USA");
        countries.add(country1);
        countries.add(country2);
        when(countryRepository.findAll()).thenReturn(countries);
        when(countryRepository.getById(1L)).thenReturn(country1);
        CountryDB result = countryService.getById(1L);
        assertEquals(country1, result);
    }
    @Test
    public void testGetByIdNotFound() {
        List<CountryDB> countries = new ArrayList<>();
        CountryDB country1 = new CountryDB(1L, "Russia");
        CountryDB country2 = new CountryDB(2L, "USA");
        countries.add(country1);
        countries.add(country2);
        when(countryRepository.findAll()).thenReturn(countries);
        when(countryRepository.getById(3L)).thenReturn(null);
        CountryDB result = countryService.getById(3L);
        assertEquals(null, result);
    }

    @Test
    public void testGetAll() {
        List<CountryDB> countries = new ArrayList<>();
        countries.add(new CountryDB(1L, "Russia"));
        countries.add(new CountryDB(2L, "USA"));
        when(countryRepository.findAll()).thenReturn(countries);
        List<CountryDB> result = countryService.getAll();
        assertEquals(countries, result);
    }
}