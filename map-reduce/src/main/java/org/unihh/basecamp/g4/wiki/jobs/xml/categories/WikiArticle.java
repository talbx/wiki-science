package org.unihh.basecamp.g4.wiki.jobs.xml.categories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiArticle {
    //{"id": "", "revid": "", "url":"", "title": "", "text": "..."}
    String id;
    String revid;
    String url;
    String title;
    String text;
}
