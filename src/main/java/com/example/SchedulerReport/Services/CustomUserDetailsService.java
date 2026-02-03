/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.Services;

import com.example.SchedulerReport.entity.UserMaster;
import com.example.SchedulerReport.repository.UserMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ankit Vashistha
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMasterRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMaster user = userRepo.findByUmName(username)
                .orElseThrow(()
                        -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUmName())
                .password(user.getUmPassword()) // DB password
                .roles("USER")
                .build();
    }
}
