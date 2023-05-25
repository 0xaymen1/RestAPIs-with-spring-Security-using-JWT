package com.miniprojet;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name="Customers")
public class Customers {
    @Id
    @SequenceGenerator(name = "customers_id_sequence",
            sequenceName = "customers_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customers_id_sequence")

    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Customers(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Customers() {

    }
}
