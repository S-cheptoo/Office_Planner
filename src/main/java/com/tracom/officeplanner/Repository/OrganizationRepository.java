package com.tracom.officeplanner.Repository;


import com.tracom.officeplanner.Models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query ("SELECT o from Organization  o where o.org_id = ?1")
    Organization getOrganizationById(@Param("org_id")Long id);
}
