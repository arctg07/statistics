package com.anki.statistics.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Iurii Ivanov
 */

@Entity
@Data
@Table(name = "translator_statistics", schema = "statistics")
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "main_lang")
    private String mainLanguage;
    @Column(name = "word_eng")
    private String wordEng;
    @Column(name = "word_rus")
    private String wordRus;
    @Column(name = "count")
    private String count;

}
