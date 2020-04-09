# Welcome to Calendar App

About Events
•	An event would typically consist of {start, end, location, Owner, user-list, title}.
•	Events can either be like meetings (with a dedicated location and appropriate guest-list) or as well be like holidays, birthdays, reminders etc.
•	An event once created, can be either accepted or rejected by the constituent users - if neither it should be in neutral state.

Below are the API which will be implemented - 

1. Given a Meeting ID, provide an API to give details of invitees with their responses i.e., ACCEPT, DECLINE etc.

2. API to find available rooms in specific building at particular time-slot

3. Given a user, provide an API to fetch list of event/meetings for the given date range.


   Please use the API url for above API - 
   
   1. localhost:8081/calendar/v1/meeting/1
   2. localhost:8081/calendar/v1/rooms?building=A&startTime=12:15&endTime=12:30
   3. localhost:8081/calendar/v1/user/10
 
 

