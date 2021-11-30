package com.tracom.officeplanner.Repository;

import com.tracom.officeplanner.Models.ConfirmationToken;
import com.tracom.officeplanner.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
