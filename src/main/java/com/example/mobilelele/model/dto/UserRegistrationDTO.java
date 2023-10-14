package com.example.mobilelele.model.dto;

import com.example.mobilelele.model.validation.FieldMatch;
import com.example.mobilelele.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match!!!"
)
public class UserRegistrationDTO {
    @NotEmpty
    String firstName;
    @NotEmpty
    String lastName;
    @NotNull
    @Email
    @UniqueUserEmail(message = "Email already taken!!!")
    String email;
    @NotEmpty
    String password;
    @NotEmpty
    String confirmPassword;

    public UserRegistrationDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
