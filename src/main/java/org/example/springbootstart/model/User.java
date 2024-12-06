package org.example.springbootstart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Min(value = 0, message = "Id should be greater than zero")
    private Long id;
    @NotEmpty(message = "Name should not be emtpy")
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

}
