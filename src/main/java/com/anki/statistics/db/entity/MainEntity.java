package com.anki.statistics.db.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

/**
 * @author Iurii Ivanov
 */

@Data
@Entity
@Table(name = "main", schema = "statistics")
public class MainEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "mainEntity", cascade = CascadeType.ALL)
    private List<Child> children;
}
