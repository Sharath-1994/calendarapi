package com.calendar.api.model;


import com.calendar.api.model.enums.MeetingResponse;

import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int userId;
    private String emailId;

    //User can have one or more meetings in a day
    private List<MeetingRoom> usersMeeting;

    //Mapper to give for a given meeting whether user is accepted the meeting or no
    private Map<String, MeetingResponse> meetingStatusMap;

    public User() {

    }

    public User(int userId, String emailId, String name) {
        this.userId = userId;
        this.emailId = emailId;
        this.name = name;

    }

    public User(int userId, String name, String emailId, List<MeetingRoom> usersMeeting, Map<String, MeetingResponse> meetingStatusMap) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.usersMeeting = usersMeeting;
        this.meetingStatusMap = meetingStatusMap;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<MeetingRoom> getUsersMeeting() {
        return usersMeeting;
    }

    public void setUsersMeeting(List<MeetingRoom> usersMeeting) {
        this.usersMeeting = usersMeeting;
    }

    public Map<String, MeetingResponse> getMeetingStatusMap() {
        return meetingStatusMap;
    }

    public void setMeetingStatusMap(Map<String, MeetingResponse> meetingStatusMap) {
        this.meetingStatusMap = meetingStatusMap;
    }


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
