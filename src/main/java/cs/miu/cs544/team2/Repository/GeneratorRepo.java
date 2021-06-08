package cs.miu.cs544.team2.Repository;

import cs.miu.cs544.team2.Model.Generator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public interface GeneratorRepo extends JpaRepository<Generator,Integer> {
    boolean existsById(Integer id);
}
