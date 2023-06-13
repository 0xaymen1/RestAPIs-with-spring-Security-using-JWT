package ioXhubSpringBootWebApp.io.Xhub.SpringBootWebApp.dto;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CustomerDto {
    private Integer customerid;
    private String customername;
    private String email;
    private Integer age;

}



