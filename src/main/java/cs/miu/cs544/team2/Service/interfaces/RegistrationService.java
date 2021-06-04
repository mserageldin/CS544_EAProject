package cs.miu.cs544.team2.Service.interfaces;


import cs.miu.cs544.team2.Model.CourseOffering;
import cs.miu.cs544.team2.Model.Registration;
import cs.miu.cs544.team2.Model.Student;

public interface RegistrationService {
    void saveRegistration(CourseOffering courseOffering, Student student);
    Registration getRegistration(Student student);
    void deleteRegistration(Student student);
    boolean updateRegistration(Student student);
}
