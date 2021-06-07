package cs.miu.cs544.team2.Model.object;


import cs.miu.cs544.team2.Model.Person;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class LoginUserDetail implements UserDetails {

    private String uid;
    private String pwd;
    private boolean active = true;

    public LoginUserDetail(Person user){
        this.uid = user.getUsername();
        this.pwd = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //TODO add user role
        return null;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public String getUsername() {
        return this.uid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
