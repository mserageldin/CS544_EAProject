package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;

import cs.miu.cs544.team2.Model.Personnel;
import cs.miu.cs544.team2.Repository.PersonnelRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnelServiceImpl implements PersonnelService {
    @Autowired
    private PersonnelRepo personnelRepo;

    @Override
    public void savePersonnel(Personnel personnel) {
        if(null != personnel){
            if(!personnelRepo.existsByEmailAddress(personnel.getEmailAddress())){
                personnelRepo.save(personnel);
            }
        }
    }

    @Override
    public Personnel getPersonnel(String email) {
        if(null != email){
            if(personnelRepo.existsByEmailAddress(email)){
                return personnelRepo.findByEmailAddress(email);
            }
        }
        return null;
    }

    @Override
    public void deletePersonnel(String email) {
        if(null != email){
            if(personnelRepo.existsByEmailAddress(email)){
                personnelRepo.delete(personnelRepo.findByEmailAddress(email));
            }
        }
    }

    @Override
    public boolean updatePersonnel(Personnel personnel) {
        return false;
    }
}
