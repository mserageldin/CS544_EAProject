package cs.miu.cs544.team2.Repository;

import cs.miu.cs544.team2.Model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public interface AdministratorRepo extends JpaRepository<Administrator,Integer> {
    Administrator findByEmailAddress(String email);
    boolean existsByEmailAddress(String email);
}
