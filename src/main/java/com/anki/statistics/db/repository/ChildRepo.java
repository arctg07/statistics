package com.anki.statistics.db.repository;

import com.anki.statistics.db.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Iurii Ivanov
 */

public interface ChildRepo extends JpaRepository<Child, Long> {

    @Override
//    @EntityGraph(attributePaths = "children")
    Optional<Child> findById(Long id);
}
