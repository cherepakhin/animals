package ru.perm.v.animals.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.perm.v.animals.dto.CountryDto;
import ru.perm.v.animals.model.Country;

/**
 * Сервис получения стран из БД
 */

public interface CountryService {
    /**
     * Все страны
     * @return
     */
    List<Country> getAll();

    /**
     * Страна по id
     * @param id
     * @return страна
     */
    Country getById(Long id);
}
