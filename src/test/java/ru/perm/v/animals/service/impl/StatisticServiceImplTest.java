package ru.perm.v.animals.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.perm.v.animals.model.StatisticDB;
import ru.perm.v.animals.service.StatisticService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StatisticServiceImplTest {

    @Autowired
    StatisticService statisticService;

    @Test
    void getAll() {
        List<StatisticDB> report = statisticService.getReport();
        assertEquals(6, report.size());
    }

    @Test
    void findByCountryId() {
        Long COUNTRY_ID = 100L;
        List<StatisticDB> stat = statisticService.findByCountryId(COUNTRY_ID);
        assertEquals(3, stat.size());
    }

    @Test
    void findByCountryIdAndAnimalId() {
        Long COUNTRY_ID = 100L;
        Long ANIMAL_ID = 2L;
        List<StatisticDB> stat = statisticService.findByCountryIdAndAnimalId(COUNTRY_ID, ANIMAL_ID);
        assertEquals(1, stat.size());
        assertEquals(COUNTRY_ID, stat.get(0).getCountry().getId());
        assertEquals(ANIMAL_ID, stat.get(0).getAnimal().getId());
        assertEquals(20, stat.get(0).getQty());
    }
}
