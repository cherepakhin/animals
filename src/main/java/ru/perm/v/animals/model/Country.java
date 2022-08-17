package ru.perm.v.animals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    private Long id = Long.valueOf(0);
    @Column(columnDefinition = "varchar(255) default '-'")
    private String name = "";

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
