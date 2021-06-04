package cs.miu.cs544.team2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.miu.cs544.team2.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

}
