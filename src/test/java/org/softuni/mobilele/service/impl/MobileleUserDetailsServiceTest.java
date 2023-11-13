package org.softuni.mobilele.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.model.entity.UserRoleEntity;
import org.softuni.mobilele.model.enums.UserRoleEnum;
import org.softuni.mobilele.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//анотира се, тк ни трябва някакво Repo
@ExtendWith(MockitoExtension.class)
class MobileleUserDetailsServiceTest {
    private MobileleUserDetailsService serviceToTest;
    @Mock  //анотира се задължително
    private UserRepository mockUserRepository;

    @BeforeEach
        //JUnit 5
    void setUp() {
        serviceToTest = new MobileleUserDetailsService(mockUserRepository);
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("pesho@test.com"));
    }

    @Test
    void testUserFoundException() {
        //Arrange
        UserEntity testUser = createTestUser();

        //обучаваме Mocked repo да връща определен резултат
        when(mockUserRepository.findByEmail(testUser.getEmail()))
                .thenReturn(Optional.of(testUser));

        //Act
        UserDetails userDetails = serviceToTest.loadUserByUsername(testUser.getEmail());

        //Assert
        assertNotNull(userDetails);
        assertEquals(
                testUser.getEmail(),
                userDetails.getUsername(),
                "Username is not mapped to email!"
        );
        assertEquals(testUser.getPassword(), userDetails.getPassword());
        assertEquals(2, userDetails.getAuthorities().size());
        assertTrue(containsAuthority(userDetails, "ROLE_" + UserRoleEnum.ADMIN),
                "The user is not ADMIN!");
        assertTrue(containsAuthority(userDetails, "ROLE_" + UserRoleEnum.USER),
                "The user is not USER!");
    }

    private static UserEntity createTestUser() {
        return new UserEntity()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setEmail("pesho@softuni.bg")
                .setActive(false)
                .setPassword("topSecret")
                .setRoles(List.of(
                        new UserRoleEntity().setRole(UserRoleEnum.ADMIN),
                        new UserRoleEntity().setRole(UserRoleEnum.USER)
                ));
    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
        return userDetails.getAuthorities()
                .stream()
                .anyMatch(a -> expectedAuthority.equals(a.getAuthority()));
        //.filter(a -> expectedAuthority.equals(a.getAuthority()))
        //.findAny()
        //.isPresent();
    }
}
