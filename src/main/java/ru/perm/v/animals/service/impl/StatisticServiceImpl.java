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
    public List<Statistic> getReportByAnimal() {
        //TODO: не сделано getReportByAnimal()
        return null;
    }

    @Override
    public List<Statistic> getReportByCountry() {
        //TODO: не сделано getReportByCountry() {
        return null;
    }
}
