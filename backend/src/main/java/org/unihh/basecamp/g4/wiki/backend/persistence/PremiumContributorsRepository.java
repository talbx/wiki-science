package org.unihh.basecamp.g4.wiki.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unihh.basecamp.g4.wiki.backend.entity.PremiumContributorsEntity;

import java.util.List;

@Repository
public interface PremiumContributorsRepository extends JpaRepository<PremiumContributorsEntity, Integer> {

    @Query(nativeQuery = true, value = "select * from PREMIUM_CONTRIBUTORS p WHERE p.Timestamp LIKE CONCAT(:year,'%')")
    List<PremiumContributorsEntity> findByYear(@Param("year") String year);

    @Query(nativeQuery = true, value = "select * from PREMIUM_CONTRIBUTORS p WHERE p.Timestamp LIKE CONCAT(:year,'-',:month,'%')")
    List<PremiumContributorsEntity> findByYearMonth(@Param("year") String year, @Param("month") String month);

    @Query(nativeQuery = true, value = "select * from PREMIUM_CONTRIBUTORS p WHERE p.Timestamp LIKE CONCAT(:year,'-',:month,'-',:day,'%')")
    List<PremiumContributorsEntity> findByYearMonthDay(@Param("year") String year, @Param("month") String month, @Param("day") String day);

    @Query(nativeQuery = true, value = "select * from PREMIUM_CONTRIBUTORS p WHERE p.Timestamp LIKE CONCAT('%-%-%T',:time,'Z')")
    List<PremiumContributorsEntity> findByTime(@Param("time") String time);
}
