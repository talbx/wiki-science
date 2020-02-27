package org.unihh.basecamp.g4.wiki.backend;

import java.util.List;

public interface WikiRepository {

    List<CategoryEntity> findTop50OrOrderByAmount();
}
