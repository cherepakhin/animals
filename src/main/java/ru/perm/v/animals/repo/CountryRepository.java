package ru.perm.v.animals.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.perm.v.animals.model.CountryDB;

import javax.persistence.Table;

/**
 * Репозиторий стран
 */
@Repository
public interface CountryRepository extends JpaRepository<CountryDB, Long> {

}



