package com.anki.statistics.controller;

import com.anki.statistics.model.StatisticsItemDto;
import com.anki.statistics.service.StatisticsItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Iurii Ivanov
 */

@RestController
@RequestMapping("statistics")
@RequiredArgsConstructor
@Tag(name = "ENG-RUS-STAT")
public class StatisticsController {

    private  final StatisticsItemService service;

    @GetMapping("/list-eng-rus-statistics")
    @Operation(description = "GET ALL ENG-RUS WORDS STAT", summary = "GET ALL ENG-RUS WORDS STAT")
    public List<StatisticsItemDto> getStatisticsForRusEngWords() {
        return service.getAllRusEngStat();
    }
}
