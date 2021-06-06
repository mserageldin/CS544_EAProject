package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;


import cs.miu.cs544.team2.Model.Course;
import cs.miu.cs544.team2.Model.CourseOffering;
import cs.miu.cs544.team2.Repository.CourseOfferingRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {
    @Autowired
    private CourseOfferingRepo courseOfferingRepo;

    @Override
    public void saveCourseOffering(CourseOffering courseOffering) {
        if(null != courseOffering){
            if(!courseOfferingRepo.existsByCourseAndPeriod(courseOffering.getCourse(),courseOffering.getPeriod())){
                courseOfferingRepo.save(courseOffering);
            }
        }

    }

    @Override
    public List<CourseOffering> getAllCourseOffering(String period) {
        if(null != period){
            if(!courseOfferingRepo.existsByPeriod(period)){
              return courseOfferingRepo.findAllByPeriod(period);
            }
        }
        return null;
    }

    @Override
    public CourseOffering getCourseOffering(Course course, String period) {
        if(null != period && null != course){
            if(!courseOfferingRepo.existsByCourseAndPeriod(course,period)){
                return courseOfferingRepo.findByCourseAndPeriod(course,period);
            }
        }
        return null;
    }

    @Override
    public void deleteCourseOffering(Course course, String period) {
        if(null != period && null != course){
            if(!courseOfferingRepo.existsByCourseAndPeriod(course,period)){
                courseOfferingRepo.delete(getCourseOffering(course,period));
            }
        }
    }

}
