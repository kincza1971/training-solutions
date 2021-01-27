package week02.d05;

import java.util.ArrayList;
import java.util.List;

public class Office {
    List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {

        for(int i = 0; i < meetingRooms.size(); i++) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }
    public void printNamesReverse() {

        for(int i = meetingRooms.size(); i>-1; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }
    public void printEvenNames() {

        for(int i = 1; i < meetingRooms.size(); i++) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }
    public void printAreas() {

        for(int i = 0; i < meetingRooms.size(); i++) {
            String kiirni;
            kiirni = "Tárgyaló: " + meetingRooms.get(i).getName();
            kiirni = kiirni + " Szélesség: " + meetingRooms.get(i).getWidth();
            kiirni = kiirni + " Hosszúság: " + meetingRooms.get(i).getLength();
            kiirni = kiirni + " Terület: " + meetingRooms.get(i).getArea();
            System.out.println((kiirni));
        }
    }
    public void printMeeetingRoomsWithName(String name){

        for(int i = 0; i < meetingRooms.size(); i++) {
            String kiirni;
            String room = meetingRooms.get(i).getName();
            if (room.equals(name)) {
                kiirni = "Tárgyaló: " + room;
                kiirni = kiirni + " Szélesség: " + meetingRooms.get(i).getWidth();
                kiirni = kiirni + " Hosszúság: " + meetingRooms.get(i).getLength();
                kiirni = kiirni + " Terület: " + meetingRooms.get(i).getArea();
                System.out.println((kiirni));
                i = meetingRooms.size()+1;
            }
        }
    }
    public void printMeetingRoomsContains(String part){

        for(int i = 0; i < meetingRooms.size(); i++) {
            String kiirni;
            String room = meetingRooms.get(i).getName().toLowerCase();
            if (room.contains(part)) {
                kiirni = "Tárgyaló: " + meetingRooms.get(i).getName();
                kiirni = kiirni + " Szélesség: " + meetingRooms.get(i).getWidth();
                kiirni = kiirni + " Hosszúság: " + meetingRooms.get(i).getLength();
                kiirni = kiirni + " Terület: " + meetingRooms.get(i).getArea();
                System.out.println((kiirni));
                i = meetingRooms.size()+1;
            }
        }
    }
    public void printAreasLargerThan(int area){

        for(int i = 0; i < meetingRooms.size(); i++) {
            String kiirni;
            int room = meetingRooms.get(i).getArea();
            if (room > area) {
                kiirni = "Tárgyaló: " + meetingRooms.get(i).getName();
                kiirni = kiirni + " Szélesség: " + meetingRooms.get(i).getWidth();
                kiirni = kiirni + " Hosszúság: " + meetingRooms.get(i).getLength();
                kiirni = kiirni + " Terület: " + meetingRooms.get(i).getArea();
                System.out.println((kiirni));
                i = meetingRooms.size()+1;
            }
        }
    }
}
