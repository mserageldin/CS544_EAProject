package cs.miu.cs544.team2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl.AuthenticationService;
import cs.miu.cs544.team2.filter.JWTFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfigurator extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationService user;


    @Autowired
    private JWTFilter jwtFilter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception{

        auth.userDetailsService(user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests()
                .antMatchers("/authenticate/**").permitAll()
                  .antMatchers("/swagger-ui.html").permitAll()
              .antMatchers("/student/**").hasRole("Student")
                 .antMatchers("/administrator/**").hasRole("Administrator")
                .antMatchers("/personnel/**").hasRole("Personnel")
                .antMatchers("/faculty/**").hasRole("Faculty")

                .anyRequest().permitAll()//.authenticated()
                 .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        ;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();// NoOpPasswordEncoder.getInstance();
    }



    @Bean
    @Override//it used to be defined in default but with newer version we should add it in order to use autowired
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}