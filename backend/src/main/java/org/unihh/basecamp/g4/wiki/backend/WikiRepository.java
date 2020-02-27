package org.unihh.basecamp.g4.wiki.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WikiRepository extends JpaRepository<Category, Integer> {

    List<CategoryEntity> findTop50OrOrderByAmount();
}
