package com.example.mobilelele.service.implemetation;

import com.example.mobilelele.model.dto.UserRegistrationDTO;
import com.example.mobilelele.model.enitity.UserEntity;
import com.example.mobilelele.repository.UserRepository;
import com.example.mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder
                           ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        UserEntity newUser = map(userRegistrationDTO);



        userRepository.save(newUser);
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
    }


}
