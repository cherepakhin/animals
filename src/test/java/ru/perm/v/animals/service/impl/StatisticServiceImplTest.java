package ru.perm.v.animals.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.perm.v.animals.model.Statistic;
import ru.perm.v.animals.service.StatisticService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StatisticServiceImplTest {

    @Autowired
    StatisticService statisticService;

    @Test
    void getAll() {
        List<Statistic> report = statisticService.getReport();
        assertEquals(6, report.size());
    }

    @Test
    void findByCountryId() {
        Long COUNTRY_ID = 1L;
        List<Statistic> stat = statisticService.findByCountryId(COUNTRY_ID);
        assertEquals(3, stat.size());
    }
}
