package com.calendar.api.model;

import java.util.Date;
import java.util.List;

public class MeetingRoom {

    private String meetingId;
    private String meetingSubject;
    private User owner;
    private List<User> invitees;
    private boolean isBooked;
    private String meetingRoomName;
    private Date start;
    private Date end;

    public MeetingRoom(String meetingId, String meetingSubject, User owner, List<User> invitees, boolean isBooked, String meetingRoomName, Date start, Date end) {
        this.meetingId = meetingId;
        this.meetingSubject = meetingSubject;
        this.owner = owner;
        this.invitees = invitees;
        this.isBooked = isBooked;
        this.meetingRoomName = meetingRoomName;
        this.start = start;
        this.end = end;
    }

    public MeetingRoom(){

    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<User> invitees) {
        this.invitees = invitees;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getMeetingRoomName() {
        return meetingRoomName;
    }

    public void setMeetingRoomName(String meetingRoomName) {
        this.meetingRoomName = meetingRoomName;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "meetingId=" + meetingId +
                ", meetingSubject='" + meetingSubject + '\'' +
                ", isBooked=" + isBooked +
                ", meetingRoomName='" + meetingRoomName + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
