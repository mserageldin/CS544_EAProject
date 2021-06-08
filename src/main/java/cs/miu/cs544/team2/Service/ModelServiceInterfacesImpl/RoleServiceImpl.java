package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;


import cs.miu.cs544.team2.Model.Role;
import cs.miu.cs544.team2.Repository.RoleRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Role getRole(String role) {
        List<Role> roleList = roleRepo.findAll();
        for(Role role1: roleList){
            if(role1.getRoleType().equalsIgnoreCase(role)) return role1;
        }
        return null;
    }


}
