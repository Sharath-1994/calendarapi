package com.calendar.api.util;

import com.calendar.api.model.enums.MeetingResponse;
import com.calendar.api.model.response.Meeting;
import com.calendar.api.model.response.MeetingAttendee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AppTestUtil {

    public static List<Meeting> meetingList() throws ParseException {

        List<Meeting> meetings = new ArrayList<>();

        Meeting meeting = new Meeting("Sharath", "1", "Awards", "A234", new SimpleDateFormat("dd-mm-yyyy hh:mm").parse("01-01-2020 1:30 pm"), new SimpleDateFormat("dd-mm-yyyy hh:mm").parse("01-01-2020 12:30 pm"));

        meetings.add(meeting);

        return meetings;

    }


    public static List<MeetingAttendee> getMeetingAttendees() {

        List<MeetingAttendee> meetingAttendees = new ArrayList<>();

        MeetingAttendee meetingAttendee = new MeetingAttendee("Sharath", "sharath@walmart.com", MeetingResponse.ACCEPTED);
        MeetingAttendee meetingAttendee1 = new MeetingAttendee("Neha", "Neha@walmart.com", MeetingResponse.DECLINED);

        meetingAttendees.add(meetingAttendee);
        meetingAttendees.add(meetingAttendee1);

        return meetingAttendees;

    }
}
