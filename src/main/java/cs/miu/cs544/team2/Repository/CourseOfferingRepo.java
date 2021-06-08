package cs.miu.cs544.team2.Repository;

import cs.miu.cs544.team2.Model.Course;
import cs.miu.cs544.team2.Model.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseOfferingRepo extends JpaRepository<CourseOffering,Integer> {
    List<CourseOffering> findAllByPeriod(String period);
    CourseOffering findByCourseAndPeriod(Course course, String period);
    boolean existsByCourseAndPeriod(Course courseCode, String period);
    boolean existsByPeriod(String period);
}
