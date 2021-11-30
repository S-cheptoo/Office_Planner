package com.tracom.officeplanner.Repository;


import com.tracom.officeplanner.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room r WHERE r.id = ?1")
    public Room getRoomById(@Param("room_id")Integer id);

//    @Query("SELECT i FROM Room i WHERE i.id IS NOT NULL AND i.organization.id = ?1")
//    List<Room> findAllByOrganization(int id);
}
