package org.unihh.basecamp.g4.wiki.backend;

import org.unihh.basecamp.g4.wiki.backend.persistence.CategoryEntity;

import java.util.List;

public interface WikiRepository {

    List<CategoryEntity> findTop50OrOrderByAmount();
}
