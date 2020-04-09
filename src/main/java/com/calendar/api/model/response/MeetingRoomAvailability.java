package com.calendar.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetingRoomAvailability {

    @JsonProperty("meetingId")
    private String meetingId;

    @JsonProperty("meetingRoomName")
    private String meetingRoomName;

    public MeetingRoomAvailability(String meetingId, String meetingRoomName) {
        this.meetingId = meetingId;
        this.meetingRoomName = meetingRoomName;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingRoomName() {
        return meetingRoomName;
    }

    public void setMeetingRoomName(String meetingRoomName) {
        this.meetingRoomName = meetingRoomName;
    }
}
