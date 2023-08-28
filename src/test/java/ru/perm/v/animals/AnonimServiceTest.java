package ru.perm.v.animals;

import org.junit.jupiter.api.Test;
import ru.perm.v.animals.service.AnonimServiceInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonimServiceTest {
    @Test
    public void simpleUseWithCreate() {
        // Создается анонимный класс по интерфейсу
        AnonimServiceInterface service = new AnonimServiceInterface() {
            @Override
            public String getName() {
                return "name";
            }
        };
        assertEquals("name", service.getName());
    }

    @Test
    public void simpleUseWithoutCreate() {
        assertEquals("name", new AnonimServiceInterface() {
            @Override
            public String getName() {
                return "name";
            }
        }.getName());
    }
}
