package ru.perm.v.animals.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.Statistic;
import ru.perm.v.animals.repo.StatisticRepository;
import ru.perm.v.animals.service.StatisticService;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    StatisticRepository repository;

    @Override
    public List<Statistic> getReport() {
        return repository.findAll();
    }

    @Override
    public List<Statistic> findByCountryId(Long id) {
        return repository.findByCountryId(id);
    }

    @Override
    public List<Statistic> findByAnimalId(Long animalId) {
        return repository.findByAnimalId(animalId);
    }

    @Override
    public List<Statistic> findByCountryIdAndAnimalId(Long countryId, Long animalId) {
        return repository.findByCountryIdAndAnimalId(countryId, animalId);
    }
}
