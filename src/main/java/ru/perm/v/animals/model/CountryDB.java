package ru.perm.v.animals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Страна
 */
@Entity
@Table(name = "country")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CountryDB {
    @Id
    private Long id = 0L;
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

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
