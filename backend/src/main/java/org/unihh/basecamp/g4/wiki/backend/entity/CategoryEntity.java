package org.unihh.basecamp.g4.wiki.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryEntity {

    private String name;
    private int amount;

}
