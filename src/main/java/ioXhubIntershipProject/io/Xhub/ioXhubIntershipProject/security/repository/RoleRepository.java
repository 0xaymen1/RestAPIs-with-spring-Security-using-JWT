package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.repository;


import ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity.Role;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ComponentScan
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByAuthority(String authority);
}
