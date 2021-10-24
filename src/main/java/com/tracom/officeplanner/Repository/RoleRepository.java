package com.tracom.officeplanner.Repository;

import com.tracom.officeplanner.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r WHERE r.name=?1")
    Role getRoleByName(String name);

}
