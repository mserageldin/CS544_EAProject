package cs.miu.cs544.team2.Service;


import cs.miu.cs544.team2.Model.Role;
import cs.miu.cs544.team2.Repository.RoleRepo;
import cs.miu.cs544.team2.Service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void saveRole(Role role) {
        if(null != role){
            if(!roleRepo.existsRoleByType(role.getType())){
                roleRepo.save(role);
            }
        }
    }
}
