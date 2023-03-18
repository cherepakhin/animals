package ru.perm.v.animals.dto;

import ru.perm.v.animals.model.Country;

public class CountryDto {
    private Long id = 0L;
    private String name = "";

    public CountryDto() {
    }

    public CountryDto(Country  country) {
        this(country.getId(),country.getName());
    }

    public CountryDto(Long id, String name) {
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
}