package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;


import cs.miu.cs544.team2.Model.Person;
import cs.miu.cs544.team2.Repository.PersonRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	  @Autowired
	    private PersonRepo personRepo;
	@Override
	public void savePerson(Person person) {
		if(null != person){
	         
        	personRepo.save(person);
        
    }
	}
}
