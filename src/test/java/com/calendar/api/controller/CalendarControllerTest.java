package com.calendar.api.controller;

import com.calendar.api.model.response.Meeting;
import com.calendar.api.model.response.MeetingAttendee;
import com.calendar.api.service.CalendarService;
import com.calendar.api.util.AppTestUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CalendarControllerTest {

    @Mock
    private CalendarService calendarService;

    @InjectMocks
    private CalendarController calendarController;


    @Test
    public void testGetMeetingsForUser() throws Exception {

        List<Meeting> meetingList = AppTestUtil.meetingList();

        Mockito.when(calendarService.getListOfMeetingForUser(1)).thenReturn(meetingList);

        ResponseEntity<Object> responseEntity = calendarController.getMeetingsForUser("1");

        List<Meeting> meetings = (List<Meeting>) responseEntity.getBody();

        Assert.assertEquals("Invalid http response", HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals("No data found", "1", meetings.get(0).getMeetingId());

    }

    @Test
    public void testGetResponsesOfInvitees(){

        List<MeetingAttendee> meetingAttendees = AppTestUtil.getMeetingAttendees();

        Mockito.when(calendarService.getAttendeesMeetingResponse("1")).thenReturn(meetingAttendees);

        ResponseEntity<Object> responseEntity = calendarController.getResponsesOfInvitees("1");

        List<MeetingAttendee> attendeeList = (List<MeetingAttendee>) responseEntity.getBody();

        Assert.assertEquals("Invalid http response", HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals("No data found", "sharath@walmart.com", attendeeList.get(0).getEmailId());

    }


}
