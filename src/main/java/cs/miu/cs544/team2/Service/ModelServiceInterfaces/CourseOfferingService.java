package cs.miu.cs544.team2.Service.ModelServiceInterfaces;

import cs.miu.cs544.team2.Model.Course;
import cs.miu.cs544.team2.Model.CourseOffering;

import java.util.List;

public interface CourseOfferingService {
    void saveCourseOffering(CourseOffering courseOffering);
    List<CourseOffering> getAllCourseOffering(String period);
    CourseOffering getCourseOffering(Course course, String period);
    void deleteCourseOffering(Course course, String period);

}

