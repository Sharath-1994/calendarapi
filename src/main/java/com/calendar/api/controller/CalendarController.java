package com.calendar.api.controller;

import com.calendar.api.model.response.Meeting;
import com.calendar.api.model.response.MeetingAttendee;
import com.calendar.api.model.response.MeetingRoomAvailability;
import com.calendar.api.service.CalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("calendar/v1/")
public class CalendarController {

    private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

    @Autowired
    CalendarService calendarService;

    @GetMapping("/meeting/{meetingId}")
    public ResponseEntity<Object> getResponsesOfInvitees(@PathVariable String meetingId) {

        logger.info("getting list of attendees for a given meetingId: {}", meetingId);
        List<MeetingAttendee> responseList;

        try {
            responseList = calendarService.getAttendeesMeetingResponse(meetingId);
            if (responseList != null) {
                logger.info("get all attendees for meetingId :{}", meetingId);
                return new ResponseEntity<>(responseList, HttpStatus.OK);
            } else {
                logger.info("no available meetingId :{}", meetingId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting id not found");
            }
        } catch (Exception ex) {
            logger.error("getAttendeesMeetingResponse error and stacktrace: {}", ex.getStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    // TODO: 09/04/20 Tried to implement by time range but was unable to do due to time constraint. To be done in future
    @GetMapping("/rooms")
    public ResponseEntity<Object> getAvailableMeetingRooms(@PathParam("building") String building,
                                                           @PathParam("startTime") String startTime, @PathParam("endTime") String endTime) throws Exception {

        List<MeetingRoomAvailability> meetingRoomList;
        try {
            meetingRoomList = calendarService.getMeetingRooms(building, startTime, endTime);
            if (meetingRoomList != null) {
                logger.info("get available meeting room for building :{}", building);
                return new ResponseEntity<>(meetingRoomList, HttpStatus.OK);
            } else {
                logger.info("no available building :{}", building);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No building rooms Available. Please try with valid building id");
            }
        } catch (Exception ex) {
            logger.error("getMeetingRooms error and stacktrace :{}", ex.getStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    //User email Id need to be provided in order to get the unique record.
    // TODO: 09/04/20 Tried to implement by data range but was unable to do due to time constraint. To be done in future
    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getMeetingsForUser(@PathVariable("userId") String userId) throws Exception {

        int id = Integer.valueOf(userId);

        logger.info("getting list of meetings for a give userId: {}", userId);

        List<Meeting> meetings;

        try {
            meetings = calendarService.getListOfMeetingForUser(id);
            if (meetings != null) {
                return new ResponseEntity<>(meetings, HttpStatus.OK);
            } else {
                logger.debug("unable to find userId:{}", userId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to find the user for given userId");
            }

        } catch (Exception ex) {
            logger.error("getMeetingRooms error and stacktrace :{}", ex.getStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
