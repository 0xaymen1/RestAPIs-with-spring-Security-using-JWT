package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.auth;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.dto.RegistreDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.dto.LoginDto;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.Role;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.UserEntity;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.repository.RoleRepository;
import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.List;

@RestController
@RequestMapping("auth")

public class AuthController {

    @Autowired
    private final UserService userService;
    private final RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/hello")
        public String hello() {

            return "Hello I am Login";
        }

    @PostMapping("/addrole")
    public Role addRole(@RequestBody Role role) {
        return userService.saveRole(role);
    }
    @PostMapping("/register")
    public UserEntity addUser(@RequestBody RegistreDto registreDto) {
        return userService.saveUserEntity(registreDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return userService.getAllRoles();
    }

   /* @PostMapping("/Login")
    public UserEntity addUser(@RequestBody Login login) {
        return userService.saveUserEntity(login);
    }*/



}

