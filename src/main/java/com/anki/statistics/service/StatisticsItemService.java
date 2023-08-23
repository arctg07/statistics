package com.anki.statistics.service;

import com.anki.statistics.kafka.message.StatisticsMessage;
import com.anki.statistics.model.StatisticsItemDto;

import java.util.List;

/**
 * @author Iurii Ivanov
 */

public interface StatisticsItemService {

    void createNewItem(StatisticsMessage message);

    List<StatisticsItemDto> getAllRusEngStat();
}
