package cs.miu.cs544.team2.Service.UCServiceInterfacesImpl;

import cs.miu.cs544.team2.Model.*;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.BarCodeRecordService;
import cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl.LocationServiceImpl;
import cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl.StudentServiceImpl;
import cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl.TimeslotServiceImpl;
import cs.miu.cs544.team2.Service.UCServiceInterfaces.UCPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UCPersonnelServiceImpl implements UCPersonnelService {

    @Autowired
    private BarCodeRecordService barCodeRecordService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private TimeslotServiceImpl timeslotService;
    @Autowired
    private LocationServiceImpl locationService;


    @Override
    public List<AttendanceReport> getAllTimeAttendanceOfAStudent(String studentId) {
        List<BarCodeRecord> barCodeRecordList = barCodeRecordService.getStudentBarCodeRecordById(studentId);
        List<AttendanceReport> attendanceReportList = new ArrayList<>();
        Set<String> courseCode;
        courseCode = barCodeRecordList.stream().map(BarCodeRecord::getCourseCode).collect(Collectors.toSet());
        for(String k: courseCode){
            int count=0;
            BarCodeRecord record = null;
            for (BarCodeRecord c: barCodeRecordList){
                if(c.getCourseCode().equalsIgnoreCase(k)){
                    record = c;
                    count++;
                }
            }
            if(null != record){
                attendanceReportList.add(new AttendanceReport(record.getStudent().getFirstName(), record.getStudent().getLastName(),record.getStudent().getStudentId(), k, count));
            }
        }
        return attendanceReportList;
    }

    @Override
    public void updateStudentAttendanceRecord(String studentId, String building, String roomNumber, LocalDateTime timestamp) {
        Student student = studentService.getStudent(studentId);
        Location location = locationService.getLocation(building,roomNumber);
        Timeslot timeslot = timeslotService.getTimeSlot(timestamp);
        String period = timestamp.getMonth().toString();
        String courseCode = "";
        String facultyName = "";
        List<CourseOffering> courseOfferings = location.getOfferings();
        for(CourseOffering a: courseOfferings){
            if(a.getPeriod().equalsIgnoreCase(period)){
                courseCode = a.getCourse().getCode();
                facultyName = a.getFaculty().getFirstName();
            }
        }
        barCodeRecordService.saveBarCodeRecord(student,location,timeslot,courseCode,facultyName);
    }



}
