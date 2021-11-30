package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Models.Room;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.ResourceRepository;
import com.tracom.officeplanner.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private RoomRepository roomRepository;

    //List
    public List<Room> listRooms(){
        return roomRepository.findAll();
    }
    //Deleting
    public void deleteRoom(Integer room_id){
        roomRepository.deleteById(room_id);
    }
    //Editing
    public Room editRoom(Integer room_id)
    {
        return roomRepository.getRoomById(room_id);
    }

    public List<Resource> listResources() {
        return resourceRepository.findAll();
    }

    public Room get(Integer id){
        return roomRepository.getRoomById(id);
    }

}
