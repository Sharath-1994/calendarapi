package com.calendar.api.sampledata;

import com.calendar.api.model.Building;
import com.calendar.api.model.enums.MeetingResponse;
import com.calendar.api.model.MeetingRoom;
import com.calendar.api.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class contains application data since no DB is being used
 */

// TODO: 09/04/20 Given an opportunity i can model this SampleData class well.

public class SampleData {

/**Storing the values in hashmap to get meeting based on meetingId just like how we get data from database
    Eg- Select meetingId from Meetingroom;
 */
    public static MeetingRoom findMeetingRoomById(String meetingId) throws Exception {

        List<MeetingRoom> meetingRoomList = meetingRoomData();

        Map<String, MeetingRoom> meetingRoomHashMap = new HashMap<>();

        for (MeetingRoom meetingRoom : meetingRoomList) {
            meetingRoomHashMap.put(meetingRoom.getMeetingId(), meetingRoom);
        }

        return meetingRoomHashMap.get(meetingId);
    }

    /**Storing the values in hashmap to get User based on userid just like how we get data from database
     Eg- Select id from User;
     */
    public static User findUserById(int userid) throws Exception {
        List<User> userList = userListData();

        Map<Integer, User> userMap = new HashMap<>();

        userList.forEach(user -> userMap.put(user.getUserId(), user));

        return userMap.get(userid);
    }

    /**Storing the values in hashmap to get MeeingroomIn Building based on building just like how we get data from database
     Eg- Select id from User;
     */
    public static List<MeetingRoom> findMeetingRoomsInGivenBuilding(String building) throws ParseException {

        Map<String, List<MeetingRoom>> buildingHashMap = new HashMap<>();

        Building building1 = dataForABuilding();

        List<MeetingRoom> meetingRoomList = new ArrayList<>();

        for (MeetingRoom meetingRoom : building1.getMeetingRooms()) {
            if (!meetingRoom.isBooked()) {
                meetingRoomList.add(meetingRoom);
            }
        }

        building1.setMeetingRooms(meetingRoomList);

        buildingHashMap.put(building1.getBuildingName(), building1.getMeetingRooms());

        return buildingHashMap.get(building);
    }

    /**
        Below are the static data used for calendar api.
     */
    private static List<MeetingRoom> meetingRoomData() throws ParseException {

        User owner = new User(1, "Sharath.k.r@walmart.com", "Sharath");

        List<User> meetingAttendees = new ArrayList<>();

        List<MeetingRoom> meetingRoomList = new ArrayList<>();

        MeetingRoom meetingRoom = getMeetingRoom("1", "A234", "Awards", true, "01-01-2020 12:30 pm", "01-01-2020 1:30 pm");

        User attendees = new User(10, "Utam", "Utam@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.ACCEPTED);
            }
        });
        User attendees1 = new User(20, "Sagar", "Sagar@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.ACCEPTED);
            }
        });
        User attendees2 = new User(30, "Neha", "Neha@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.DECLINED);
            }
        });
        User attendees3 = new User(40, "Ankita", "Ankita@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.DECLINED);
            }
        });
        User attendees4 = new User(50, "Ajay", "Ajay@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.ACCEPTED);
            }
        });

        User attendees5 = new User(60, "krishna", "Krishna@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.ACCEPTED);
            }
        });

        meetingRoom.setInvitees(meetingAttendees);
        meetingAttendees.add(attendees);
        meetingAttendees.add(attendees1);
        meetingAttendees.add(attendees2);
        meetingAttendees.add(attendees3);
        meetingAttendees.add(attendees4);
        meetingAttendees.add(attendees5);


        meetingRoomList.add(meetingRoom);

        return meetingRoomList;
    }


    private static Building dataForABuilding() throws ParseException {

        Building building1 = new Building();
        building1.setBuildingName("A");

        List<MeetingRoom> meetingRooms = new ArrayList<>();

        MeetingRoom meetingRoom1 = getMeetingRoom("1", "A234", "Awards", false, "01-01-2020 12:30 pm", "01-01-2020 1:30 pm");
        MeetingRoom meetingRoom2 = getMeetingRoom("2", "A134", "Review", false, "01-01-2020 12:30 pm", "01-01-2020 1:30 pm");

        meetingRooms.add(meetingRoom1);
        meetingRooms.add(meetingRoom2);

        building1.setMeetingRooms(meetingRooms);

        return building1;

    }

    private static MeetingRoom getMeetingRoom(String meetingId, String meetingRoomName, String meetingSubject, boolean isBooked, String startTime, String endTime) throws ParseException {

        User owner = new User(30, "Sharath.k.r@walmart.com", "Sharath");
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setMeetingId(meetingId);
        meetingRoom.setMeetingRoomName(meetingRoomName);
        meetingRoom.setBooked(isBooked);
        meetingRoom.setOwner(owner);
        meetingRoom.setMeetingSubject(meetingSubject);
        meetingRoom.setStart(new SimpleDateFormat("dd-mm-yyyy hh:mm").parse(startTime));
        meetingRoom.setEnd(new SimpleDateFormat("dd-mm-yyyy hh:mm").parse(endTime));

        return meetingRoom;

    }

    private static List<User> userListData() throws Exception {

        MeetingRoom meetingRoom = getMeetingRoom("1", "A234", "Awards", true, "01-01-2020 12:30 pm", "01-01-2020 1:30 pm");

        List<User> userList = new ArrayList<>();

        User user1 = new User(10, "Utam", "Utam@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.ACCEPTED);
            }
        });
        User user2 = new User(20, "Sagar", "Sagar@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.ACCEPTED);
            }
        });
        User user3 = new User(30, "Neha", "Neha@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.DECLINED);
            }
        });
        User user4 = new User(40, "Ankita", "Ankita@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.DECLINED);
            }
        });
        User user5 = new User(50, "Ajay", "Ajay@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.ACCEPTED);
            }
        });

        User user6 = new User(60, "krishna", "Krishna@walmart.com", Arrays.asList(meetingRoom), new HashMap<String, MeetingResponse>() {
            {
                put("1", MeetingResponse.ACCEPTED);
            }
        });

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);

        return userList;
    }


}
