package ru.perm.v.animals.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.perm.v.animals.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}



