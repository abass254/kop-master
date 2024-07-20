package com.koprate.master.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.InvalidJpaQueryMethodException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.koprate.master.Models.User;
import com.koprate.master.Repository.UserRepo;
import com.koprate.master.ViewModels.Register;

public class UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username){
        var user = userRepo.findByLogin(username);
        return user;
    }

    public UserDetails registerUser(Register data) throws InvalidJpaQueryMethodException{
        if(userRepo.findByLogin(data.login()) != null){
            throws new InvalidJpaQueryMethodException("Username already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        return userRepo.save(newUser);
    }
}
