package com.example.mobilelele.service;

import com.example.mobilelele.model.dto.UserLoginDTO;
import com.example.mobilelele.model.dto.UserRegistrationDTO;
import com.example.mobilelele.model.enitity.UserEntity;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();


}
