package com.example.mobilelele.model.enitity;

import com.example.mobilelele.model.enums.Role;
import com.example.mobilelele.model.validation.UniqueUserEmail;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @UniqueUserEmail
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    private UserRoleEntity role;

    public UserEntity() {
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        this.isActive = active;
        return this;
    }
}
