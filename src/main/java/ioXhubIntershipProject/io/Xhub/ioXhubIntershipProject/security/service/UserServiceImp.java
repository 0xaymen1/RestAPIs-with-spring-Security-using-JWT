package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.service;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.dto.RegistreDto;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.Role;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.UserEntity;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.repository.RoleRepository;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Role> getAllRoles() {
         return roleRepository.findAll();
    }


    @Override
    public UserEntity saveUserEntity(RegistreDto registreDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registreDto.getUsername());
        user.setFirstname(registreDto.getFirstname());
        user.setLastname (registreDto.getLastname());
        user.setEmail(registreDto.getEmail());
        user.setPassword(passwordEncoder.encode(registreDto.getPassword()));
        Role role = roleRepository.findByAuthority("ROLE_USER");
        user.setAuthorities(Set.of(role));
       return userRepository.save(user);
    }


    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addToUserEntity(String username, String authority) throws IllegalAccessException {
     if(!userRepository.findByEmail(username).isPresent()){
         throw new IllegalAccessException("user with email" +username+"does not exist");
     }
     Role role=roleRepository.findByAuthority(authority);
     if(role==null){
         throw new IllegalAccessException("role with name" +authority+"does not exist");
     }
        UserEntity userEntity=userRepository.findByEmail(username).get();
        userEntity.getAuthorities().add(role);
    }

    @Override
    public boolean isUserExists(String email) {
        return false;
    }
}
