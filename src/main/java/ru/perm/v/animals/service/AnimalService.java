package ru.perm.v.animals.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.model.Animal;

/**
 * Сервис получения животных из БД
 */
public interface AnimalService {
    List<Animal> getAll();
    Animal getById(Long id);
}
