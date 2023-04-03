package ru.perm.v.animals.service;

import ru.perm.v.animals.model.AnimalDB;

import java.util.List;

/**
 * Сервис получения животных из БД
 */
public interface AnimalService {
    List<AnimalDB> getAll();

    AnimalDB getById(Long id);
}
