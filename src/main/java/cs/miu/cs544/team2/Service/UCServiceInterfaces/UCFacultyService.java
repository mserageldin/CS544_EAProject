package cs.miu.cs544.team2.Service.UCServiceInterfaces;

import cs.miu.cs544.team2.Model.AttendanceReport;
import cs.miu.cs544.team2.Model.CourseOffering;

import java.util.List;

public interface UCFacultyService {
    List<AttendanceReport> getAllStudentBarCodeRecord(String facultyName, String courseCode, String period);
    List<CourseOffering> getLast6Courses(String emailAddress);
}
