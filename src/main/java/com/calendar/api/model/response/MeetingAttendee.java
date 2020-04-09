package com.calendar.api.model.response;

import com.calendar.api.model.enums.MeetingResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetingAttendee {

    @JsonProperty("name")
    private String name;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("meeting_response")
    private MeetingResponse status;

    public MeetingAttendee(){

    }

    public MeetingAttendee(String name, String emailId, MeetingResponse status) {
        this.name = name;
        this.emailId = emailId;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public MeetingResponse getStatus() {
        return status;
    }

    public void setStatus(MeetingResponse status) {
        this.status = status;
    }
}
