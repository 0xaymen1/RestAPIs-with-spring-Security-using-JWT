package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class RegistreDto {

        private String username;
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private Set<String> roles;


}
