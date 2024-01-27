package com.pack.authentication.api.service;

import com.pack.authentication.api.entity.UserEntity;
import com.pack.authentication.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class SecureUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> user = userRepository.findByUserName(username);
        if (user.isPresent()) {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            Arrays.asList(user.get().getUserName().split(",")).stream().forEach(authority -> {
                authorities.add(new SimpleGrantedAuthority(authority));
            });
            return new User(user.get().getUserName(), user.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("user not found");
        }

//        return new User("admin", "admin", new ArrayList<>());
//        return null;

    }
}
