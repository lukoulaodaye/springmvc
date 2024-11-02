package org.example.jdbcexample.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexample.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void save() {
        var user =User.builder()
                .name("Loong")
                .build();
        userRepository.save(user);
        assertNotNull(user.getId(), "User ID should not be null after saving");
    }

    @Test
    void delete() {
        var user = User.builder()
                .name("Loong")
                .build();
        userRepository.save(user);

        userRepository.deleteById(user.getId());

        Optional<User> deletedUser = userRepository.findById(user.getId());
        assertFalse(deletedUser.isPresent(), "User should not be found after deletion");
    }

    @Test
    void update() {
        var user = User.builder()
                .name("Loong")
                .build();
        userRepository.save(user);

        user.setName("Updated Loong");
        userRepository.save(user);

        Optional<User> updatedUser = userRepository.findById(user.getId());
        assertTrue(updatedUser.isPresent(), "User should be found after update");
        assertEquals("Updated Loong", updatedUser.get().getName(), "User name should be updated");
    }

    @Test
    void read() {
        var user = User.builder()
                .name("Loong")
                .build();
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findById(user.getId());
        assertTrue(foundUser.isPresent(), "User should be found");
        assertEquals("Loong", foundUser.get().getName(), "User name should match");
    }
}