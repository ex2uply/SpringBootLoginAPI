package com.projects.spring.security.service;


import com.projects.spring.security.model.Users;
import com.projects.spring.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    final
    AuthenticationManager authenticationManager;

    final
    UserRepo repo;

    private final JWTService jwtService;

    public RegisterService(UserRepo repo, AuthenticationManager authenticationManager, JWTService service, JWTService jwtService) {
        this.repo = repo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);

    }

    public String verify(Users user) {
         Authentication authentication =
                 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

         if(authentication.isAuthenticated()){
             return jwtService.generateToken(user.getUsername());
         }
         return "User is not authenticated";
    }
}
