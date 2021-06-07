package cs.miu.cs544.team2.controller;

import cs.miu.cs544.team2.Model.AttendanceReport;
import cs.miu.cs544.team2.Model.BarCodeRecord;
import cs.miu.cs544.team2.Model.Student;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.BarCodeRecordService;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.StudentService;
import cs.miu.cs544.team2.Service.UCServiceInterfaces.UCPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {

    @Autowired
    StudentService studentService;

    @Autowired
    BarCodeRecordService barCodeRecordService;

    @Autowired
    UCPersonnelService ucPersonnelService;

    @GetMapping("/{id}")
    public Student getById(String studentId){
        return studentService.getStudent(studentId);
    }

    @GetMapping("/studentrecord")
    public List<BarCodeRecord> allRecord(String id, String courseCode, String perid){
        return barCodeRecordService.getStudentBarCodeRecord(id, courseCode, perid);
    }

    @PostMapping("/updaterecord")
    public BarCodeRecord updateRecord(@RequestBody String studentId, String courseCode, String period, LocalDateTime localDateTime){
        return barCodeRecordService.updateBarCodeRecord(studentId,courseCode,period,localDateTime);
    }

    public List<AttendanceReport> getAllAttendance(String studentId){
        return ucPersonnelService.getAllTimeAttendanceOfAStudent(studentId);
    }



}
