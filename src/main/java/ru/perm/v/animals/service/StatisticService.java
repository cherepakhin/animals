package ru.perm.v.animals.service;

import ru.perm.v.animals.model.Statistic;

import java.util.List;

/**
 * Сервис статистики
 */
public interface StatisticService {
    /**
     * Полная стистика
     */
    List<Statistic> getReport();

    /**
     * Какие животные живут в стране
     * @param id животного
     * @return статистика
     */
    List<Statistic> findByCountryId(Long id);

    /**
     * В сколько и каких живет животное
     * @return статистика
     */
    List<Statistic> getReportByAnimal(Long animalId);

    /**
     * Какие животные и сколько живет в стране
     * @param countryId ид страны
     * @return список животных
     */
    List<Statistic> getReportByCountry(Long countryId);

    /**
     * Сколько животных живет в стране с id животного и id страны
     * @param countryId ид страны
     * @param animalId ид животного
     * @return статистика
     */
    List<Statistic> getdByCountryIdAndAnimalId(Long countryId, Long animalId);

}
