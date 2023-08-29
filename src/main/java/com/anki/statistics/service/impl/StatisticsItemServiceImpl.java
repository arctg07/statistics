package com.anki.statistics.service.impl;

import com.anki.statistics.db.entity.StatisticsItem;
import com.anki.statistics.db.repository.StatisticsItemRepo;
import com.anki.statistics.kafka.message.StatisticsMessage;
import com.anki.statistics.model.StatisticsItemDto;
import com.anki.statistics.service.StatisticsItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Iurii Ivanov
 */

@Service
@RequiredArgsConstructor
public class StatisticsItemServiceImpl implements StatisticsItemService {

    private final StatisticsItemRepo statisticsItemRepo;

    @Override
    public void createNewItem(StatisticsMessage message) {
        StatisticsItem statisticsItem = new StatisticsItem();
        statisticsItem.setMainLanguage(message.lang());
        statisticsItem.setWordEng(message.eng());
        statisticsItem.setWordRus(message.rus());
        statisticsItem.setCount(String.valueOf(message.count()));

        statisticsItemRepo.save(statisticsItem);
    }

    @Override
    public List<StatisticsItemDto> getAllRusEngStat() {
        List<StatisticsItem> all = statisticsItemRepo.findAll();
        return all.stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    private StatisticsItemDto mapToView(StatisticsItem item) {
        return new StatisticsItemDto(
                item.getId(),
                item.getMainLanguage(),
                item.getWordEng(),
                item.getWordRus(),
                item.getCount()
        );
    }
}
