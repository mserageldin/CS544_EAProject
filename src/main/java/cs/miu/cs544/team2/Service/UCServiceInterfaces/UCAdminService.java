package cs.miu.cs544.team2.Service.UCServiceInterfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface UCAdminService {
    void addCourse(String courseCode, String abbreviation, String name, String description);
    void dropCourse(String courseCode);
    void addCourseOffering(String courseCode, int month, int year, int capacity,String buildingName, String roomNumber);
    void dropCourseOffering(String period, String courseCode);
    void registerStudent(String firstName, String lastName, String email, String visaStatus, String status, String track, LocalDate entryDate);
    void dropStudent(String studentId);
    void addFaculty(String firstName, String lastName, String email, String title);
    void dropFaculty(String email);
    void addPersonnel(String firstName, String lastName, String email, String title);
    void dropPersonnel(String email);
    void addAdministrator(String firstName, String lastName, String email, String title);
    void dropAdministrator(String email);
    void addRole(String email, String role);
    void dropRole(String email, String role);
    void addLocation(String name, String building, String roomNumber, int capacity);
    void dropLocation(String  building, String roomNumber);
    void addTimeSlot(String code, String title, LocalTime startTime, LocalTime endTime);
}
