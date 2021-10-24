package com.tracom.officeplanner.Repository;

import com.tracom.officeplanner.Models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository <Resource, Long > {

        @Query("SELECT r FROM Resource r WHERE r.id = ?1")
        public Resource getResourceById(@Param("rsc_id")Long id);

}
