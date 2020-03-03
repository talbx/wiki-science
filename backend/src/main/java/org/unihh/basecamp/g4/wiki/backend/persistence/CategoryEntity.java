package org.unihh.basecamp.g4.wiki.backend.persistence;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryEntity {

    private String name;
    private int amount;

}
