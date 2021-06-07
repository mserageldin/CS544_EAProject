package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;


import cs.miu.cs544.team2.Model.CourseOffering;
import cs.miu.cs544.team2.Model.Registration;
import cs.miu.cs544.team2.Model.Student;
import cs.miu.cs544.team2.Repository.RegistrationRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepo registrationRepo;

    @Override
    public void saveRegistration(CourseOffering courseOffering, Student student) {
        if(null != student && null != courseOffering){
            if(!registrationRepo.existsByStudent(student)){
                registrationRepo.save(new Registration(LocalDate.now(),courseOffering,student));
            }
        }
    }

    @Override
    public Registration getRegistration(Student student) {
        if(null != student){
            if(registrationRepo.existsByStudent(student)){
               return registrationRepo.findByStudent(student);
            }
        }
        return null;
    }

    @Override
    public void deleteRegistration(Student student) {
        if(null != student){
            if(registrationRepo.existsByStudent(student)){
                registrationRepo.delete(registrationRepo.findByStudent(student));
            }
        }
    }

    @Override
    public boolean updateRegistration(Student student) {
        return false;
    }
}
