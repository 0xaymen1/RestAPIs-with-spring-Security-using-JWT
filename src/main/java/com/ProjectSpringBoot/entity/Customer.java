package com.ProjectSpringBoot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Customer(Integer id,String name,String email,Integer age) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Customer() {

    }
}
