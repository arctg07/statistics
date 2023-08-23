package com.anki.statistics.kafka.message;


import com.anki.statistics.model.EngRusDto;

/**
 * @author Iurii Ivanov
 */

public record StatisticsMessage(String lang, int count, EngRusDto sentence) {
}
