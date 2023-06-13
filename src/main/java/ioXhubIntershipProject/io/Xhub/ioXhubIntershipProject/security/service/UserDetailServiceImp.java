package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.service;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.UserEntity;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
