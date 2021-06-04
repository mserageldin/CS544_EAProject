package cs.miu.cs544.team2.Repository;


import cs.miu.cs544.team2.Model.Role;
import cs.miu.cs544.team2.Model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public interface RoleRepo extends JpaRepository<Role,Integer> {
    boolean existsRoleByType(RoleType roleType);
}
