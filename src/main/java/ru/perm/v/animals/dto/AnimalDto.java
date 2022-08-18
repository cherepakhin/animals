package ru.perm.v.animals.dto;

import ru.perm.v.animals.model.Animal;

public class AnimalDto {

    private Long id = 0L;
    private String name = "";

    public AnimalDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AnimalDto(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
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
}
