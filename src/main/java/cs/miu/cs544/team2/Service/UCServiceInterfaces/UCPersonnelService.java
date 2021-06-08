package cs.miu.cs544.team2.Service.UCServiceInterfaces;

import cs.miu.cs544.team2.Model.AttendanceReport;

import java.time.LocalDateTime;
import java.util.List;

public interface UCPersonnelService {
    List<AttendanceReport> getAllTimeAttendanceOfAStudent(String studentId);
    void updateStudentAttendanceRecord(String studentId, String building, String roomNumber, LocalDateTime timestamp);

}
