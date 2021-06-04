package cs.miu.cs544.team2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.miu.cs544.team2.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
