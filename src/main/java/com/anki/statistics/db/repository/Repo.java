package com.anki.statistics.db.repository;

import com.anki.statistics.db.entity.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Iurii Ivanov
 */

public interface Repo extends JpaRepository<MainEntity, Long> {


    @Override
//    @EntityGraph(attributePaths = "children")
    Optional<MainEntity> findById(Long id);


    Optional<MainEntity> findByName(String name);
}
