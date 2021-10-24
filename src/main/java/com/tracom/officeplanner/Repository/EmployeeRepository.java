package com.tracom.officeplanner.Repository;


import com.tracom.officeplanner.Models.Employee;
import com.tracom.officeplanner.Models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.id = ?1")
    public Employee getEmployeeById(@Param("id")Long id);
}
