package cs.miu.cs544.team2.Service;

import cs.miu.cs544.team2.Model.Course;
import cs.miu.cs544.team2.Repository.CourseRepo;
import cs.miu.cs544.team2.Service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;


    @Override
    public void saveCourse(Course course) {
        if(null != course){
            if(!courseRepo.existsByCode(course.getCode())){
                courseRepo.save(course);
            }
        }
    }

    @Override
    public Course getCourse(String code) {
        if(null != code){
            if(courseRepo.existsByCode(code)){
                return courseRepo.findByCode(code);
            }
        }
        return null;
    }

    @Override
    public void deleteCourse(String code) {
        if(null != code){
            if(courseRepo.existsByCode(code)){
                courseRepo.delete(courseRepo.findByCode(code));
            }
        }

    }

    @Override
    public boolean updateCourse(Course course) {
        return false;
    }
}
