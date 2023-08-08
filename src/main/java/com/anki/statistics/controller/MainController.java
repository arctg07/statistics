package com.anki.statistics.controller;

import com.anki.statistics.db.entity.Child;
import com.anki.statistics.db.entity.MainEntity;
import com.anki.statistics.model.ChildDto;
import com.anki.statistics.model.ParentDto;
import com.anki.statistics.service.MainEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Iurii Ivanov
 */

@RestController
@RequestMapping("example")
@RequiredArgsConstructor
public class MainController {

    private final MainEntityService service;

    @GetMapping("/{id}")
    public ChildDto getChildByParentId(@PathVariable Long id) {
        Child child = service.getChild(id);
        return new ChildDto(child.getId(), child.getName(), child.getMainEntity().getId());
    }

    @GetMapping("/parent/{id}")
    public ParentDto getParentByChildId(@PathVariable Long id) {
        MainEntity parent = service.getParent(id);
        return new ParentDto(parent.getId(), parent.getName(), parent.getChildren().stream().map(
                x -> new ChildDto(x.getId(), x.getName(), x.getMainEntity().getId())
        ).collect(Collectors.toList()));
    }

    @GetMapping("/parent/name/{name}")
//    @Transactional
    public ParentDto getParentByName(@PathVariable String name) {
        Optional<MainEntity> oneParent = service.findOneParent(name);

        List<Child> children = oneParent.get().getChildren();

        return oneParent.map(parent ->
                new ParentDto(
                        parent.getId(),
                        parent.getName(),
                        parent.getChildren().stream().map(
                                x -> new ChildDto(
                                        x.getId(),
                                        x.getName(),
                                        x.getMainEntity().getId())
                        ).collect(Collectors.toList()))
        ).orElse(null);
    }
}