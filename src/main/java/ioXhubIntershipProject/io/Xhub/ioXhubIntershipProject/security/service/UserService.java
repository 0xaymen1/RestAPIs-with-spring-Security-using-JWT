package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.service;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.dto.RegistreDto;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.Role;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.rmi.registry.Registry;
import java.util.List;


@Service
public interface UserService {

    List<UserEntity> getAllUsers();
    List<Role> getAllRoles();

    UserEntity saveUserEntity(RegistreDto registreDto);


    Role saveRole(Role role);
    void addToUserEntity(String username ,String authority) throws IllegalAccessException;
    boolean isUserExists(String email);
}
