package com.calendar.api.model;

import java.util.List;


public class Building {

    private String buildingName;

    private List<MeetingRoom> meetingRooms;

    public Building() {

    }

    public Building(String buildingName, List<MeetingRoom> meetingRooms) {
        this.buildingName = buildingName;
        this.meetingRooms = meetingRooms;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingName='" + buildingName + '\'' +
                '}';
    }
}
