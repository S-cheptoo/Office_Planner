package com.tracom.officeplanner.Repository;


import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u join u.roles r WHERE u.email = :email and r.name='USER'")
    public List<User> getUserByEmail(@Param("email") String email);

//    @Query("SELECT u FROM User u join u.role r WHERE u.email= :email and r.name='ADMIN'")
//    public List<User> getAdminByEmail(@Param("email") String email);
//
//    @Query("SELECT u FROM User u join u.role r WHERE u.email= :email and r.name='INITIATOR'")
//    public List<User> getInitiatorByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    public User getUserById(@Param("user_id")Integer id);
}

