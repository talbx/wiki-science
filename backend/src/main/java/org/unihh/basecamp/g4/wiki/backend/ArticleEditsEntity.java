package org.unihh.basecamp.g4.wiki.backend;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleEditsEntity {

    private String title;
    private int edits;
}