package com.miniprojet;

import lombok.Data;

@Data
public class NewCustomersRequest {
    private Integer id;
    private String name;
    private String email;
    private Integer age;

}
