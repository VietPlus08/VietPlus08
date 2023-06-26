package com.example.demo.service;

import com.example.demo.entities.AppUser;
import com.example.demo.repos.IAppUserRepo;
import com.example.demo.dto.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    final
    IAppUserRepo repo;

    public UserService(IAppUserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = repo.findByUserName(username);
        if (appUser == null){
            throw new UsernameNotFoundException(username);
        }
        UserDetails user =  new CustomUserDetails(appUser);
        return user;
    }
}
