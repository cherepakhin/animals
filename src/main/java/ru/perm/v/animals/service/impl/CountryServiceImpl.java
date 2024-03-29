package ru.perm.v.animals.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.CountryDB;
import ru.perm.v.animals.repo.CountryRepository;
import ru.perm.v.animals.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    public CountryServiceImpl(@Autowired CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryDB> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public CountryDB getById(Long id) {
        List<CountryDB> countries = countryRepository.findAll();
        System.out.println(countries);
        return countryRepository.getById(id);
    }
}
