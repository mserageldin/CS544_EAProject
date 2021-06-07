package cs.miu.cs544.team2.Service.ModelServiceInterfaces;

import cs.miu.cs544.team2.Model.BarCodeRecord;
import cs.miu.cs544.team2.Model.Location;
import cs.miu.cs544.team2.Model.Student;
import cs.miu.cs544.team2.Model.Timeslot;

import java.time.LocalDateTime;
import java.util.List;

public interface BarCodeRecordService {
    void saveBarCodeRecord(Student student, Location location, Timeslot timeslot, String courseCode, String facultyName);
    List<BarCodeRecord> getStudentBarCodeRecord(String studentId, String courseCode, String period);
    List<BarCodeRecord> getAllStudentBarCodeRecord(String facultyName, String courseCode, String period);
    void updateBarCodeRecord(String studentId, String courseCode, String period, LocalDateTime localDateTime);
    List<BarCodeRecord> getStudentBarCodeRecordById(String studentId);
}
