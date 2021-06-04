package cs.miu.cs544.team2.Service.interfaces;


import cs.miu.cs544.team2.Model.Student;

public interface StudentService {
    void saveStudent(Student student);
    Student getStudent(String id);
    void deleteStudent(String id);
    boolean updateStudent(Student student);
}
