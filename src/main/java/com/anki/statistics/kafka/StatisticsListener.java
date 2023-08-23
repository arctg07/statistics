package com.anki.statistics.kafka;

import com.anki.statistics.kafka.message.StatisticsMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Iurii Ivanov
 */
@Component
public class StatisticsListener {

    @KafkaListener(topics = "${topic.send-analytics}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenStatistics(StatisticsMessage statisticsMessage) {

    }

}
