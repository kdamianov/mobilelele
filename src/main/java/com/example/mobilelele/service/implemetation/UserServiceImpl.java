package com.example.mobilelele.service.implemetation;

import com.example.mobilelele.model.dto.UserLoginDTO;
import com.example.mobilelele.model.dto.UserRegistrationDTO;
import com.example.mobilelele.model.enitity.OfferEntity;
import com.example.mobilelele.model.enitity.UserEntity;
import com.example.mobilelele.repository.UserRepository;
import com.example.mobilelele.service.UserService;
import com.example.mobilelele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        UserEntity newUser = map(userRegistrationDTO);



        userRepository.save(newUser);
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

         var userEntity = userRepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

        boolean loginSuccessful = false;

        if (userEntity != null) {
            String rawPassword = userLoginDTO.password();
            String encodedPassword = userEntity.getPassword();

            loginSuccessful = encodedPassword != null &&
                    passwordEncoder.matches(rawPassword, encodedPassword);

            if (loginSuccessful) {
                currentUser.setLogged(true)
                        .setFirstName(userEntity.getFirstName())
                        .setLastName(userEntity.getLastName());
            } else {
                currentUser.logOut();
            }
        }
        return loginSuccessful;
    }

    @Override
    public void logoutUser() {
        currentUser.logOut();
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.getFirstName())
                .setLastName(userRegistrationDTO.getLastName())
                .setEmail(userRegistrationDTO.getEmail())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
    }


}
