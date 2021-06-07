package cs.miu.cs544.team2.controller;

import cs.miu.cs544.team2.Model.BarCodeRecord;
import cs.miu.cs544.team2.Model.CourseOffering;
import cs.miu.cs544.team2.Model.Registration;
import cs.miu.cs544.team2.Service.UCServiceInterfaces.UCStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private UCStudentService ucStudentService;

    @GetMapping("/attendance/{studentId}")
    public List<BarCodeRecord> getStudentAttendance(@PathVariable("studentId")String studentId, String courseCode, String period){
        return ucStudentService.getStudentAttendance(studentId, courseCode, period);
    }

    @PostMapping("registration/")
    public void registration(@RequestBody String studentId, String courseCode, String period){
        ucStudentService.register(studentId, courseCode, period);
    }

    @GetMapping("/registration/{studentId}")
    public List<Registration> getRegistration(@PathVariable("studentId") String studentId){
        return ucStudentService.getRegistredCourses(studentId);
    }

    @GetMapping("courseoffering")
    public List<CourseOffering> getCourseOffer(@PathVariable("period") String period){
        return ucStudentService.getCourseOffers(period);
    }
}
