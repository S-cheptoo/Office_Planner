package com.tracom.officeplanner.Repository;

import com.tracom.officeplanner.Models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long > {

    @Query("SELECT m FROM Meeting m where m.id=?1")
    public Meeting getMeetingById(@Param("meeting_id")Long id);
}
