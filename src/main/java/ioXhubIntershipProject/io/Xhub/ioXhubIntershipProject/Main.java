package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

/*@Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
           userService.saveRole(new Role( null,"ROLE_USER","this user role"));
            userService.saveRole(new Role(null,"ROLE_ADMIN","this admin role"));


userService.saveUserEntity(new UserEntity(null,"aymen1", "aymen", "bsf", "aymen1@gmail.com", "1234", new HashSet<>()));
userService.saveUserEntity(new UserEntity(null,"ahmed1", "ahmed", "ben", "ahmed1@gmail.com", "4321", new HashSet<>()));

          userService.addToUserEntity("aymen1@gmail.com" , "ROLE_ADMIN" );
            userService.addToUserEntity("ahmed1@gmail.com" , "ROLE_USER" );
        };}*/
}




