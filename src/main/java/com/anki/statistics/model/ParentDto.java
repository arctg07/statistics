package com.anki.statistics.model;

import java.util.List;

/**
 * @author Iurii Ivanov
 */

public record ParentDto (Long id, String name, List<ChildDto> children) {
}
