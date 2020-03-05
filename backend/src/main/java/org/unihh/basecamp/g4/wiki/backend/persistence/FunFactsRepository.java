package org.unihh.basecamp.g4.wiki.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unihh.basecamp.g4.wiki.backend.entity.FunFactsEntity;

@Repository
public interface FunFactsRepository extends JpaRepository<FunFactsEntity, Integer> {

    FunFactsEntity findByTitle(String title);
}
