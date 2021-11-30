package com.tracom.officeplanner.Repository;

import com.tracom.officeplanner.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, Long> {
    @Query("SELECT d from Department  d where d.id = ?1")
    public Department getDepartmentById(@Param("dp_id")Long id);
}

