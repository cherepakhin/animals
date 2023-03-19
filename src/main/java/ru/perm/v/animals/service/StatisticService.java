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
     * Какие животные и сколько живет в стране
     * @param animalId ид страны
     * @return статистика
     */
    List<Statistic> findByAnimalId(Long animalId);

    /**
     * Сколько животных живет в стране с id животного и id страны
     * @param countryId ид страны
     * @param animalId ид животного
     * @return статистика
     */
    List<Statistic> findByCountryIdAndAnimalId(Long countryId, Long animalId);

}
