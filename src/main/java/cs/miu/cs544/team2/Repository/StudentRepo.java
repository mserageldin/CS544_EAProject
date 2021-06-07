package cs.miu.cs544.team2.Repository;


import cs.miu.cs544.team2.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findByStudentId(String studentId);
    boolean existsByStudentId(String studentId);
    boolean existsByBarcode(String barCode);
    Student findByBarcode(String barCode);
    boolean existsByEmailAddress(String email);
    Student findByEmailAddress(String email);
}
