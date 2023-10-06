package com.example.mobilelele.model.dto;

public record UserRegistrationDTO(String firstName,
                                  String lastName,
                                  String email,
                                  String password,
                                  String confirmPassword) {

}
