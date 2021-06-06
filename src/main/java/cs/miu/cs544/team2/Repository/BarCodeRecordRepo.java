package cs.miu.cs544.team2.Repository;


import cs.miu.cs544.team2.Model.BarCodeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = false)
public interface BarCodeRecordRepo extends JpaRepository<BarCodeRecord,Integer> {
    List<BarCodeRecord> findByStudentIdAndCourseCodeAndPeriod(String studentId, String courseCode, String period);
    List<BarCodeRecord> findByFacultyNameAndCourseCodeAndPeriod(String facultyName, String courseCode, String period);
    BarCodeRecord findByStudentIdAndCourseCodeAndPeriodAndTimeStamp(String studentId, String courseCode, String period, LocalDateTime localDateTime);
    boolean existsByStudentIdAndCourseCodeAndPeriodAndTimeStamp(String studentId, String courseCode, String period, LocalDateTime localDateTime);
    boolean existsByStudentIdAndCourseCodeAndPeriod(String studentId, String courseCode, String period);
    boolean existsByFacultyNameAndCourseCodeAndPeriod(String facultyName, String courseCode, String period);

}
