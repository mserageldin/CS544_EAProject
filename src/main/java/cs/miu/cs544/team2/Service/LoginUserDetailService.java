package cs.miu.cs544.team2.Service;

import cs.miu.cs544.team2.Model.Person;
import cs.miu.cs544.team2.Repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    private PersonRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> optionalUser = 
        		userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            return new cs.miu.cs544.team2.Model.object.LoginUserDetail(optionalUser.get());
        }

        String error = String.format("Username is not found");
        throw new UsernameNotFoundException(error);
    }
}
