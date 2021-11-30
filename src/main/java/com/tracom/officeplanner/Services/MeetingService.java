package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Meeting;
import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MeetingService {
    @Autowired
    MeetingRepository meetingRepository;

    //save
    public void save(Meeting meeting){
         meetingRepository.save(meeting);
    }
    //List
    public List<Meeting> listMeetings(){
        return meetingRepository.findAll();
    }
    //Edit
    public Meeting editMeeting(long meeting_id)
    {
        return meetingRepository.getMeetingById(meeting_id);
    }
    //Delete
    public void deleteMeeting(Long meeting_id){
        meetingRepository.deleteById(meeting_id);
    }

    public Meeting get(Long id){
        return meetingRepository.getMeetingById(id);
    }
}


