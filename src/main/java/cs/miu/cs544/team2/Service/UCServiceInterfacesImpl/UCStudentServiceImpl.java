package cs.miu.cs544.team2.Service.UCServiceInterfacesImpl;

import cs.miu.cs544.team2.Model.*;
import cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl.*;
import cs.miu.cs544.team2.Service.UCServiceInterfaces.UCStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UCStudentServiceImpl implements UCStudentService {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private CourseOfferingServiceImpl courseOfferingService;
    @Autowired
    private RegistrationServiceImpl registrationService;
    @Autowired
    private BarCodeRecordServiceImpl barCodeRecordService;
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private TimeslotServiceImpl timeslotService;


    @Override
    public void register(String studentId, String courseCode, String period) {
        if(null != studentId && null != courseCode && null != period){
            Student student = studentService.getStudent(studentId);
            Course course = courseService.getCourse(courseCode);
            CourseOffering courseOffering = courseOfferingService.getCourseOffering(course,period);
            registrationService.saveRegistration(courseOffering,student);
        }
    }

    @Override
    public List<BarCodeRecord> getStudentAttendance(String studentId, String courseCode,String period) {
        if(null != studentId && null !=courseCode){
            return barCodeRecordService.getStudentBarCodeRecord(studentId,courseCode,period);
        }
        return null;
    }

    @Override
    public List<Registration> getRegistredCourses(String studentId) {
        if(null != studentId){
            return studentService.getStudent(studentId).getRegistrations();
        }
        return null;
    }

    @Override
    public List<CourseOffering> getCourseOffers(String period) {
        if(null != period){
            return courseOfferingService.getAllCourseOffering(period);
        }
        return null;
    }

    @Override
    public void takeAttendance(String barCode, Location location, LocalDateTime timeStamp) {
        Student student = studentService.getStudentByBarCode(barCode);
        Timeslot timeslot = timeslotService.getTimeSlot(timeStamp);
        String period = timeStamp.getMonth().toString();
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
