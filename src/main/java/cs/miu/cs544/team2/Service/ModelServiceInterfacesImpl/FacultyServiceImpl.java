package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;


import cs.miu.cs544.team2.Model.Faculty;
import cs.miu.cs544.team2.Repository.FacultyRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepo facultyRepo;

    @Override
    public void saveFaculty(Faculty faculty) {
        if(null != faculty){
            if(!facultyRepo.existsByEmailAddress(faculty.getEmailAddress())){
                facultyRepo.save(faculty);
            }
        }
    }

    @Override
    public Faculty getFaculty(String email) {
        if(null != email){
            if(!facultyRepo.existsByEmailAddress(email)){
                return facultyRepo.findByEmailAddress(email);
            }
        }
        return null;
    }

    @Override
    public void deleteFaculty(String email) {
        if(null != email){
            if(facultyRepo.existsByEmailAddress(email)){
                facultyRepo.delete(facultyRepo.findByEmailAddress(email));
            }
        }
    }

    @Override
    public boolean updateFaculty(Faculty faculty) {
        return false;
    }
}
