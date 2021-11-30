package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.Organization;
import com.tracom.officeplanner.Models.Room;
import com.tracom.officeplanner.Repository.RoomRepository;
import com.tracom.officeplanner.Services.OrganizationService;
import com.tracom.officeplanner.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/rooms")
    public String getRooms(Model model){
        List<Room> listRooms = roomService.listRooms();
        model.addAttribute("rooms", listRooms);
        return "/rooms";
    }
    @GetMapping("/add_room")
    public String getAddRooms(Model model){
        List<Organization> listOrganizations = organizationService.listOrganizations();
        model.addAttribute("organizations", listOrganizations);

        model.addAttribute("room", new Room());
        return "/add_room";
    }
    @PostMapping("/create_room")
    public String createRoom(@ModelAttribute Room room){
        roomRepository.save(room);
        return "redirect:/rooms";
    }
}
