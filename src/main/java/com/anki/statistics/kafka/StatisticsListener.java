package com.anki.statistics.kafka;

import com.anki.statistics.kafka.message.StatisticsMessage;
import com.anki.statistics.service.StatisticsItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Iurii Ivanov
 */
@Component
@RequiredArgsConstructor
public class StatisticsListener {

    private final StatisticsItemService service;

    @KafkaListener(topics = "${kafka.topic.send-analytics}", groupId = "${kafka.consumer.group-id}")
    public void listenStatistics(StatisticsMessage statisticsMessage) {

        System.out.println("READ SUCCESSFULLY");
        System.out.println(statisticsMessage.toString());

        try {
            System.out.println("READ SUCCESSFULLY");
            service.createNewItem(statisticsMessage);
        } catch (Exception exception) {
            System.out.println("service error");
        }

    }

}
