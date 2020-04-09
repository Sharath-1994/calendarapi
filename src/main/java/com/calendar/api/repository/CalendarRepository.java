package com.calendar.api.repository;


import com.calendar.api.model.MeetingRoom;
import com.calendar.api.model.User;
import com.calendar.api.sampledata.SampleData;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class CalendarRepository {


    public MeetingRoom findUsersStatusByMeetingId(String meetingId) throws Exception {

        return SampleData.findMeetingRoomById(meetingId);

    }

    public List<MeetingRoom> findAvailableMeetingRoomsForGivenBuildingAndTime(String buildingName, String startTime, String endTime) throws Exception {

        return SampleData.findMeetingRoomsInGivenBuilding(buildingName);

    }

    public User findUserByUserId(int userId) throws Exception {

        return SampleData.findUserById(userId);

    }
}
