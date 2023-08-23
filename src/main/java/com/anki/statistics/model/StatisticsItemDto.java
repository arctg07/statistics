package com.anki.statistics.model;

import jakarta.persistence.Column;

/**
 * @author Iurii Ivanov
 */

public record StatisticsItemDto(
        Long id,
        String mainLanguage,
        String wordEng,
        String wordRus,
        String count) {
}
