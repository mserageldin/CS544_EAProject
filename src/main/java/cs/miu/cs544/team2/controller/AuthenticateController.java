package cs.miu.cs544.team2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cs.miu.cs544.team2.Model.Person;
import cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl.AuthenticationService;
import cs.miu.cs544.team2.util.AuthRequest;
import cs.miu.cs544.team2.util.AuthResponse;
import cs.miu.cs544.team2.util.JWTUtil;

@RestController
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationService authservice;


    @PostMapping("/authenticate/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest authenticationRequest){

        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            authenticationManager.authenticate(authenticationToken);
        }
        catch (AuthenticationException authenticationException){
            throw authenticationException;
        }

        UserDetails userDetails = authservice.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(token,true));
    }


    @PostMapping("/authenticate/create")
    public ResponseEntity<AuthResponse> createUser(@RequestBody Person userSignUpDTO){
        boolean created = authservice.createUser(userSignUpDTO);

        if(created) {
            UserDetails userDetails = authservice.loadUserByUsername(userSignUpDTO.getUsername());
            String token = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthResponse(token,true));
        }

        return ResponseEntity.ok(new AuthResponse(null,false));
    }




}