package org.unihh.basecamp.g4.wiki.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unihh.basecamp.g4.wiki.backend.entity.RedirectsEntity;

public interface RedirectsRepository extends JpaRepository<RedirectsEntity, Integer> {

}
