package ru.perm.v.animals.service.impl.bito;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ru.perm.v.animals.model.CountryDB;
import ru.perm.v.animals.repo.CountryRepository;
import ru.perm.v.animals.service.CountryService;
import ru.perm.v.animals.service.impl.CountryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {

    @Mock
    private CountryRepository countryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAll() {
        List<CountryDB> expectedCountries = List.of(
            new CountryDB(1L, "Russia"),
            new CountryDB(2L, "USA"),
            new CountryDB(3L, "China")
        );
        Mockito.when(countryRepository.findAll()).thenReturn(expectedCountries);
        CountryService countryService = new CountryServiceImpl(countryRepository);
        List<CountryDB> actualCountries = countryService.getAll();
        Assert.assertEquals(3, actualCountries.size());
        Assert.assertEquals(expectedCountries, actualCountries);
    }
}
