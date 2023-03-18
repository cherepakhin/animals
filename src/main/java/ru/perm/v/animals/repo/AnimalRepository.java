package ru.perm.v.animals.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.perm.v.animals.model.Animal;

/**
 * Репозиторий животных
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}



