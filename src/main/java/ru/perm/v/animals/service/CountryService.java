package ru.perm.v.animals.service;


import ru.perm.v.animals.model.CountryDB;

import java.util.List;

/**
 * Сервис получения стран из БД
 */

public interface CountryService {
    /**
     * Все страны
     * @return страны
     */
    List<CountryDB> getAll();

    /**
     * Страна по id
     * @param id
     * @return страна
     */
    CountryDB getById(Long id);
}
