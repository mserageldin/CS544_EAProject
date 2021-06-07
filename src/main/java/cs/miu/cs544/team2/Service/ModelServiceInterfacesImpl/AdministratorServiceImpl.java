package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;

import cs.miu.cs544.team2.Model.Administrator;
import cs.miu.cs544.team2.Repository.AdministratorRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepo administratorRepo;


    @Override
    public void saveAdministrator(Administrator administrator) {
        if(null != administrator){
            if(!administratorRepo.existsByEmailAddress(administrator.getEmailAddress())){
                administratorRepo.save(administrator);
            }
        }
    }

    @Override
    public Administrator getAdministrator(String email) {
        if(null != email){
            if(administratorRepo.existsByEmailAddress(email)){
                return administratorRepo.findByEmailAddress(email);
            }
        }
        return null;
    }

    @Override
    public void deleteAdministrator(String email) {
        if(null != email){
            if(administratorRepo.existsByEmailAddress(email)){
                administratorRepo.delete(administratorRepo.findByEmailAddress(email));
            }
        }
    }

    @Override
    public boolean updateAdministrator(Administrator faculty) {
        return false;
    }
}
