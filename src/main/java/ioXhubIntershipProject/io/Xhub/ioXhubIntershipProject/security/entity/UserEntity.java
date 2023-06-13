package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    public UserEntity(Long userid , String username, String firstname, String lastname, String email, String password, Set<Role> roles) {
        this.userid=userid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }


    @PrePersist
    public void onCreate() {
        this.create_at = new Date(System.currentTimeMillis());
    }
    @PreUpdate
    public void onUpdate() {
        this.updated_at = new Date(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long userid;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Date create_at;
    private Date updated_at;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="user_role_junction",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Role> authorities;


    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities.stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
