package com.koprate.master.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.koprate.master.Models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
