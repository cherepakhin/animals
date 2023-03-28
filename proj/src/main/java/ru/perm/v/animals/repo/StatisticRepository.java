package ru.perm.v.animals.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.perm.v.animals.model.StatisticDB;

import java.util.List;

/**
 * Репозиторий статистики
 */
@Repository
public interface StatisticRepository extends JpaRepository<StatisticDB, Long> {
    /**
     * Список животных по стране
     * @param id ид животного
     * @return статистика
     */
    List<StatisticDB> findByCountryId(Long id);
    /**
     * Статистика по стране и животному
     * @param countryId ид страны
     * @param animalId  ид животного
     * @return статистика
     */
    List<StatisticDB> findByCountryIdAndAnimalId(Long countryId, Long animalId);

    /**
     * Статистика по id животного.
     * @param animalId
     * @return
     */
    List<StatisticDB> findByAnimalId(Long animalId);
}



