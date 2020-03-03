package org.unihh.basecamp.g4.wiki.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ArticleEntity {

    private String title;

    private int length;
}
