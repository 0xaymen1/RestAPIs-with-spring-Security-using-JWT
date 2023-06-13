package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.service;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.UserEntity;

public interface AuthService {

    public UserEntity authenticate(String username, String password);

}
