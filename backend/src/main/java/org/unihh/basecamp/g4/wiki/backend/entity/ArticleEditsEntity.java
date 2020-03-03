package org.unihh.basecamp.g4.wiki.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ArticleEditsEntity {

    private String title;
    private int edits;
}
