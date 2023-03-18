package ru.perm.v.animals.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.perm.v.animals.model.Statistic;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    List<Statistic> findByCountryId(Long id);
    List<Statistic> findByCountryIdAndAnimalId(Long countryId, Long animalId);
}



