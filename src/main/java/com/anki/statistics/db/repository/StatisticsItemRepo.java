package com.anki.statistics.db.repository;

import com.anki.statistics.db.entity.StatisticsItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Iurii Ivanov
 */

public interface StatisticsItemRepo extends JpaRepository<StatisticsItem, Long> {

}
