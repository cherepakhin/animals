package ru.perm.v.animals.dto;

import java.util.Objects;

public class AnimalDto {

    private Long id = 0L;
    private String name = "";

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
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return id.equals(animalDto.id) && name.equals(animalDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
