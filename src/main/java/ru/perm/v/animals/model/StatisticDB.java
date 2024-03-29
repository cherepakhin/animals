package ru.perm.v.animals.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * Статистика
 */
@Table(name = "statistic")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatisticDB {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_id", nullable = false)
    CountryDB country = new CountryDB();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "animal_id", nullable = false)
    AnimalDB animal = new AnimalDB();

    @Column(name = "qty", nullable = false)
    Integer qty = 0;

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", country=" + country +
                ", animal=" + animal +
                ", qty=" + qty +
                '}';
    }
}
