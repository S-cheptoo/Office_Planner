package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.Meeting;
import com.tracom.officeplanner.Models.Room;
import com.tracom.officeplanner.Repository.MeetingRepository;
import com.tracom.officeplanner.Services.MeetingService;
import com.tracom.officeplanner.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MeetingController {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private MeetingService meetingService;
    @Autowired
    private RoomService roomService;

    @GetMapping("/meetings")
    public String getCalendar(Model model){
        model.addAttribute("meeting", new Meeting());
        return "/meetings";
    }
    @GetMapping("/add_meeting")
    public String getAddMeeting(Model model){
        List<Room> listRooms = roomService.listRooms();
        model.addAttribute("rooms", listRooms);
        model.addAttribute("meeting", new Meeting());
        return "/add_meeting";
    }
    @GetMapping("/saved_meeting")
    public String showDetails(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "/saved_meeting";
    }
      @PostMapping("/create_event")
    public String addMeeting(@ModelAttribute Meeting meeting){
        meetingRepository.save(meeting);
        return "/saved_meeting";
      }

    @RequestMapping("/edit_meeting/{meeting_id}")
    public String showEditMeeting(@PathVariable(name = "meeting_id")Long meeting_id, Model model) {
        Meeting meeting = meetingRepository.getMeetingById(meeting_id);
        model.addAttribute("meeting", meeting);
        return "edit_meeting";
    }

    @PostMapping("/update_meeting")
    public String updateMeeting(Meeting meeting){
       meetingService.save(meeting);
        return "redirect:/meetings";
    }

    @RequestMapping("/delete_meeting/{meeting_id}")
    public String deleteMeeting(@PathVariable(name = "meeting_id") Long meeting_id) {
        meetingRepository.deleteById(meeting_id);
        return "redirect:/resources";
    }
}
