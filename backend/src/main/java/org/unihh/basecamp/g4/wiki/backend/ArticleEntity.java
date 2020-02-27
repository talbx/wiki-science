package org.unihh.basecamp.g4.wiki.backend;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleEntity {

    String title;

    int length;
}
