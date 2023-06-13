package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.repository;

import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.UserEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@ComponentScan
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);
    Boolean existsByUsername(String username);
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username , String password);

}
