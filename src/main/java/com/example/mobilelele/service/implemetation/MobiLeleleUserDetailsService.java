package com.example.mobilelele.service.implemetation;

import com.example.mobilelele.model.enitity.UserEntity;
import com.example.mobilelele.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

//не анотираме със @Service, тк този клас е анотиран като @Bean в Security конфигурацията
public class MobiLeleleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MobiLeleleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with " + email + " not found!"));
    }

    //създаваме User details
    private UserDetails map(UserEntity userEntity) {
        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of()) //TODO -> add roles!
                .build();
    }
}
