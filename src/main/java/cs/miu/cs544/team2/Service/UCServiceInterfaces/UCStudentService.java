package cs.miu.cs544.team2.Service.UCServiceInterfaces;

import cs.miu.cs544.team2.Model.BarCodeRecord;
import cs.miu.cs544.team2.Model.CourseOffering;
import cs.miu.cs544.team2.Model.Registration;

import java.time.LocalDateTime;
import java.util.List;

public interface UCStudentService {
    void register(String studentId, String courseCode, String period);
    List<BarCodeRecord> getStudentAttendance(String studentId, String courseCode,String period);
    List<Registration> getRegistredCourses(String studentId);
    List<CourseOffering> getCourseOffers(String period);
    void takeAttendance(String barCode, String building, String roomNumber, LocalDateTime timeStamp);
}
