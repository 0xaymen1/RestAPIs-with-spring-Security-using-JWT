package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.security.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {

    public Role(Long roleId ,String roleName ,
                String Description) {
        this.roleId=roleId;
        this.authority= roleName;
        this.Description=Description;
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
        @Column(name="role_id")
        private Long roleId;
        private String authority;
        private String Description;
        private Date create_at;
        private Date updated_at;

    @Override
    public String getAuthority() {
        return authority;
    }
}
