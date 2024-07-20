package com.koprate.master.Models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="users")

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Uuid;
    private String Icon;
    private String Name;
    private String Email;
    private String Telephone;
    private String Gender;
    private String EmpId;
    private String Username;
    private String Password;
    private boolean IsEnabled;
    private boolean ToChange;
    private String Role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.Role.toString().equals(URole.ADMIN)) {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

}
