package org.unihh.basecamp.g4.wiki.backend.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryCount {

    String country;
    Integer count;
}
