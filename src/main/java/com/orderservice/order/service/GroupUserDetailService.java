package com.orderservice.order.service;


import com.orderservice.order.entity.User;
import com.orderservice.order.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUserName(username);
        return user.map(GroupUserDetails:: new).orElseThrow(()->new UsernameNotFoundException(username +"dont have access"));

    }


}