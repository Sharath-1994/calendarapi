package com.calendar.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Meeting {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("meetingId")
    private String meetingId;

    @JsonProperty("meeting_Subject")
    private String meetingSubject;

    @JsonProperty("meetingRoom")
    private String meetingRoomName;

    @JsonProperty("start")
    private Date start;

    @JsonProperty("end")
    private Date end;

    public Meeting() {

    }

    public Meeting(String userName, String meetingId, String meetingSubject, String meetingRoomName, Date start, Date end) {
        this.userName = userName;
        this.meetingId = meetingId;
        this.meetingSubject = meetingSubject;
        this.meetingRoomName = meetingRoomName;
        this.start = start;
        this.end = end;
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
}
