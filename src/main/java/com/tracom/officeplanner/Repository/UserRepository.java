package com.tracom.officeplanner.Repository;


import com.tracom.officeplanner.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u join u.roles r WHERE u.email = :email and r.name='User'")
    public User getUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    public User getUserById(@Param("user_id")Integer id);

    @Query("UPDATE User u set u.enabled = true WHERE u.id = ?1")
    @Modifying
    public void enable(Integer id);

    @Query("SELECT u FROM User u WHERE u.verificationCode=?1")
    public User findByVerificationCode(String code);

    public User findByResetPasswordToken(String token);


}

