package ru.perm.v.animals.service;

import ru.perm.v.animals.model.Statistic;

import java.util.List;

public interface StatisticService {
    List<Statistic> getReport();
    List<Statistic> getReportByAnimal();
    List<Statistic> getReportByCountry();

}
