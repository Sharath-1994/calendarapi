package com.calendar.api.service;

import com.calendar.api.model.response.Meeting;
import com.calendar.api.model.response.MeetingAttendee;
import com.calendar.api.model.MeetingRoom;
import com.calendar.api.model.response.MeetingRoomAvailability;
import com.calendar.api.model.User;
import com.calendar.api.repository.CalendarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CalendarService {

    private static final Logger logger = LoggerFactory.getLogger(CalendarService.class);

    @Autowired
    CalendarRepository repository;

    public List<MeetingAttendee> getAttendeesMeetingResponse(String meetingId) {

        logger.info("Received request to find attendees status for given meetingId: {} } ", meetingId);

        List<MeetingAttendee> meetingAttendees = new ArrayList<>();

        try {
            MeetingRoom meetingRoomList = repository.findUsersStatusByMeetingId(meetingId);
            if (meetingRoomList != null) {
                for (User user : meetingRoomList.getInvitees()) {
                    if (user.getMeetingStatusMap().containsKey(meetingId)) {
                        MeetingAttendee attendee = new MeetingAttendee(user.getName(), user.getEmailId(), user.getMeetingStatusMap().get(meetingId));
                        meetingAttendees.add(attendee);
                    }
                }
            } else {
                logger.debug(" Unable to find meetingId :{}", meetingId);
                return null;
            }
        } catch (Exception ex) {
            logger.info("findUsersStatusByMeetingId returned exception and stacktrace :{}", ex.getStackTrace());
        }

        logger.info("Returning meetingAttendees list for given meetingId: {} } ", meetingId);

        return meetingAttendees;

    }

    public List<MeetingRoomAvailability> getMeetingRooms(String buildingName, String startTime, String endTime) {

        logger.info("Received request to go get available meeting room available for given buildingName: {} ", buildingName);

        List<MeetingRoom> meetingRoomList;

        List<MeetingRoomAvailability> meetingRoomAvailabilities = new ArrayList<>();

        try {
            meetingRoomList = repository.findAvailableMeetingRoomsForGivenBuildingAndTime(buildingName, startTime, endTime);

            if (meetingRoomList != null) {
                for (MeetingRoom room :
                        meetingRoomList) {
                    MeetingRoomAvailability meetingRoom = new MeetingRoomAvailability(room.getMeetingId(), room.getMeetingRoomName());
                    meetingRoomAvailabilities.add(meetingRoom);
                }
            } else {
                logger.debug("Unable to find rooms for given buildingName: {} ", buildingName);
                return null;
            }
        } catch (Exception ex) {
            logger.error("findAvailableMeetingRoomsForGivenBuildingAndTime returned exception stacktrace: {}", ex.getStackTrace());
        }

        logger.info("Returning available meeting rooms for buildingName: {} ", buildingName);
        return meetingRoomAvailabilities;

    }


    public List<Meeting> getListOfMeetingForUser(int userId) throws Exception {

        logger.info("Received request to go get meetings for a given userId: {} ", userId);

        User singleUser = repository.findUserByUserId(userId);

        if (singleUser == null) {
            logger.debug("Unable to find user for given userId: {} ", userId);
            return null;
        }

        List<MeetingRoom> meetingRooms;
        List<Meeting> userMeetings = new ArrayList<>();

        meetingRooms = singleUser.getUsersMeeting();

        if (!meetingRooms.isEmpty()) {
            for (MeetingRoom meetingRoom : meetingRooms) {
                Meeting meeting = new Meeting(singleUser.getName(), meetingRoom.getMeetingId(), meetingRoom.getMeetingSubject(), meetingRoom.getMeetingRoomName(), meetingRoom.getStart(), meetingRoom.getEnd());
                userMeetings.add(meeting);
            }
        } else {
            logger.info("For meetings are accepted to given userId: {}", userId);
            return null;
        }
        return userMeetings;

    }
}
