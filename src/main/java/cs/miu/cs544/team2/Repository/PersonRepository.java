package cs.miu.cs544.team2.Repository;

import org.springframework.data.repository.CrudRepository;

import cs.miu.cs544.team2.Model.Person;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {


	Optional<Person> findByUsername(String username);

}

