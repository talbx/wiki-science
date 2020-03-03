package org.unihh.basecamp.g4.wiki.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.unihh.basecamp.g4.wiki.backend.entity.LatestContributorsEntity;

import java.util.List;

@Repository
public interface LatestContributorsRepository extends JpaRepository<LatestContributorsEntity, Integer> {


    List<LatestContributorsEntity> findTop100ByOrderByContributionsDesc();

    @Query(nativeQuery = true, value = "SELECT * FROM IP_ADRESSES ORDER BY CONTRIBUTIONS DESC LIMIT 100")
    List<LatestContributorsEntity> top100Ips();

}
