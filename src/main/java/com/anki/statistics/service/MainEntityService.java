package com.anki.statistics.service;

import com.anki.statistics.db.entity.Child;
import com.anki.statistics.db.entity.MainEntity;
import com.anki.statistics.db.repository.ChildRepo;
import com.anki.statistics.db.repository.Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Iurii Ivanov
 *
 * Open Seission In View Test
 */

@Service
@RequiredArgsConstructor
public class MainEntityService {

    private final Repo repo;

    private final ChildRepo childRepo;

    @Transactional
    public Child getChild(Long id) {
        MainEntity parent = repo.findById(id).get();
        List<Child> children = parent.getChildren();

        return children.get(0);
    }


    public MainEntity getParent(Long id) {
        Optional<Child> child = childRepo.findById(id);

        MainEntity mainEntity = child.get().getMainEntity();

        return mainEntity;
    }


    @Transactional(readOnly = true)
    public Optional<MainEntity> findOneParent(String username) {
        return repo.findByName(username);
    }

}
