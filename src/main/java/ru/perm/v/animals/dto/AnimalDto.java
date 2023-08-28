package ru.perm.v.animals.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalDto {

    private Long id = 0L;
    private String name = "";

    public static String staticString = ""; // идиотский вопрос с собеса см. ForIdiotStaticTest

    // еще и в конструктор засунули, тем самым ОБЯЗЫВАЮТ менять и ломать ВСЮ логику
    public AnimalDto(Long id, String name, String s) {
        staticString = s;
        this.id = id;
        this.name = name;
    }

    // Правильный конструктор
    public AnimalDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimalDto)) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return Objects.equals(id, animalDto.id) && Objects.equals(name, animalDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
