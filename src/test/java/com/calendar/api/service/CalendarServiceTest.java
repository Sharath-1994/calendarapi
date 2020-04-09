package com.calendar.api.service;

import com.calendar.api.model.MeetingRoom;
import com.calendar.api.model.User;
import com.calendar.api.repository.CalendarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class CalendarServiceTest {

    @Mock
    private CalendarRepository calendarRepository;

    @InjectMocks
    private CalendarService calendarService;

    @Test
    public void testGetAttendeesMeetingResponseForGivenMeetingId() throws Exception {

        MeetingRoom attendee = new MeetingRoom("1", "Awards", new User(3,"Sharath@walmart.com", "Sharath"), new ArrayList<>(), true, "A1234", new SimpleDateFormat("dd-mm-yyyy hh:mm").parse("01-01-2020 12:30 pm"), new SimpleDateFormat("dd-mm-yyyy hh:mm").parse("01-01-2020 1:30 pm"));

        Mockito.when(calendarRepository.findUsersStatusByMeetingId("1")).thenReturn(attendee);


    }


}
