package cs.miu.cs544.team2.Service.ModelServiceInterfaces;


import cs.miu.cs544.team2.Model.Course;

public interface CourseService {
    void saveCourse(Course course);
    Course getCourse(String code);
    void deleteCourse(String code);
    boolean updateCourse(Course course);
}
