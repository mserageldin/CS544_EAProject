package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cs.miu.cs544.team2.Model.Person;
import cs.miu.cs544.team2.Repository.PersonRepo;
import cs.miu.cs544.team2.util.UserSecurity;
import lombok.var;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private PersonRepo perosonRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> optionalUser = perosonRep.findByUsername(username);
        if (optionalUser.isPresent()){
            return new UserSecurity(optionalUser.get());
        }

        String error = String.format("Username is not found");
        throw new UsernameNotFoundException(error);
    }


    public boolean createUser(Person personDTO) {
        Person pesron = new Person();

        var finduser = perosonRep.findByUsername(personDTO.getUsername()).orElse(null);
        if( finduser!=null) {
            return false;
        }

        pesron.setUsername(personDTO.getUsername());
        pesron.setPassword(passwordEncoder.encode(personDTO.getPassword()));
        pesron.setEmailAddress(personDTO.getEmailAddress());
        pesron.setFirstName(personDTO.getFirstName());
        pesron.setLastName(personDTO.getLastName());

        perosonRep.save(pesron);

        return true;
    }
}
