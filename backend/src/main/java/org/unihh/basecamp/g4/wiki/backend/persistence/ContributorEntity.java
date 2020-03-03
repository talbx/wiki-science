package org.unihh.basecamp.g4.wiki.backend.persistence;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContributorEntity {

    String nameOrIp;
    int contributions;
}