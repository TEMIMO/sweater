package com.example.sweater.repos;

import com.example.sweater.domain.Location;
import com.example.sweater.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDAO extends JpaRepository<Location, Long> {

    @Query(value="select l from Location l where l.id = :locationId")
    Location findByLocationId(
            @Param("locationId")long lnCode
    );
}
