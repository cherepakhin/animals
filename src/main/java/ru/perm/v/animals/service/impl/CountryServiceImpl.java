package ru.perm.v.animals.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.Country;
import ru.perm.v.animals.repo.CountryRepository;
import ru.perm.v.animals.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(Long id) {
        List<Country> countries = countryRepository.findAll();
        System.out.println(countries);
        return countryRepository.getOne(id);
    }
}
