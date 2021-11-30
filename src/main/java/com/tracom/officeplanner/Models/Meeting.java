package com.tracom.officeplanner.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name ="meetings")
public class Meeting {
    @Id
    @Column(name="meeting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="meeting_type")
    private String meeting_type;
    @Column(name="meeting_description")
    private String meeting_description;
    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate start_date;

    @Column(name = "start_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime start_time;

    @Column(name = "end_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @FutureOrPresent
    private LocalDate end_date;

    @Column(name="end_time", nullable = false, unique = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime end_time;

//    @Column(name="recurrence")
//    @Enumerated(EnumType.STRING)
//    private Recurrence recurrence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Meeting(){

    }

//    public Meeting(String meeting_type, String meeting_description, LocalDate startDate, LocalTime startTime, LocalTime endTime, Room room){
//        this.meeting_type=meeting_type;
//        this.meeting_description=meeting_description;
//        this.startDate=startDate;
//        this.startTime=startTime;
//        this.endTime=endTime;
//        this.room=room;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeeting_type() {
        return meeting_type;
    }

    public void setMeeting_type(String meeting_type) {
        this.meeting_type = meeting_type;
    }

    public String getMeeting_description() {
        return meeting_description;
    }

    public void setMeeting_description(String meeting_description) {
        this.meeting_description = meeting_description;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

//    public Recurrence getRecurrence() {
//        return recurrence;
//    }
//
//    public void setRecurrence(Recurrence recurrence) {
//        this.recurrence = recurrence;
//    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", meeting_type='" + meeting_type + '\'' +
                ", meeting_description='" + meeting_description + '\'' +
                ", start_date=" + start_date +
                ", start_time=" + start_time +
                ", end_date=" + end_date +
                ", end_time=" + end_time +
//                ", recurrence='" + recurrence + '\'' +
                ", room=" + room +
                '}';
    }
}
