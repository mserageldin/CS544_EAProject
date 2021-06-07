package cs.miu.cs544.team2.controller;

import cs.miu.cs544.team2.Model.AttendanceReport;
import cs.miu.cs544.team2.Model.CourseOffering;
import cs.miu.cs544.team2.Service.UCServiceInterfaces.UCFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    @Autowired
    private UCFacultyService uCFacultyService;

    @GetMapping("/students")
    public List<AttendanceReport> getAllStudentBarCodeRecord(@PathVariable("facultyName") String facultyName, String courseCode, String period){
         return uCFacultyService.getAllStudentBarCodeRecord(facultyName, courseCode, period);

    }

    @GetMapping("/courses")
    public List<CourseOffering> getAllLastSixMonthCourses(@PathVariable("email") String email){
        List<CourseOffering> lastSixMonthCourses = uCFacultyService.getLast6Courses(email);
        return  lastSixMonthCourses;
    }



}
