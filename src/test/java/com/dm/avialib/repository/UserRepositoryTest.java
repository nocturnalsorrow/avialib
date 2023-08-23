package com.dm.avialib.repository;

import com.dm.avialib.entity.Category;
import com.dm.avialib.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers() {
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(new User("test@gmail.com", "pass1234", "username", "USER"));
        expectedUsers.add(new User("test1@gmail.com", "pass12345", "username1", "USER"));

        when(userRepository.getAllUsers()).thenReturn(expectedUsers);

        List<User> actualUsers = userRepository.getAllUsers();

        assertEquals(expectedUsers.size(), actualUsers.size());
        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    void getUserByEmail() {
        User expectedUser = new User("test@gmail.com", "pass1234", "username", "USER");

        when(userRepository.getUserByEmail("test@gmail.com")).thenReturn(expectedUser);

        User actualUser = userRepository.getUserByEmail("test@gmail.com");

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void createUser() {
        User expectedUser = new User("test@gmail.com", "pass1234", "username", "USER");

        when(userRepository.createUser(new User("test@gmail.com", "pass1234", "username", "USER"))).thenReturn(expectedUser);

        User actualUser = userRepository.createUser(new User("test@gmail.com", "pass1234", "username", "USER"));

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void updateUser() {
        User userToUpdate = new User("test@gmail.com", "pass1234", "username", "USER");

        when(userRepository.updateUser(userToUpdate)).thenReturn(userToUpdate);

        userToUpdate.setEmail("updatedtest@gmail.com");
        userToUpdate.setPassword("updatedPass123");
        userToUpdate.setUsername("updatedUsername");
        userToUpdate.setRole("ADMIN");

        User updatedUser = userRepository.updateUser(userToUpdate);

        assertEquals("updatedtest@gmail.com", updatedUser.getEmail());
        assertEquals("updatedPass123", updatedUser.getPassword());
        assertEquals("updatedUsername", updatedUser.getUsername());
        assertEquals("ADMIN", updatedUser.getRole());

        verify(userRepository, times(1)).updateUser(userToUpdate);
    }

    @Test
    void deleteUserByEmail() {
        List<User> users = new ArrayList<>();
        users.add(new User("test@gmail.com", "pass1234", "username", "USER"));
        users.add(new User("test1@gmail.com", "pass12345", "username1", "USER"));

        userRepository.deleteUserByEmail("test@gmail.com");

        verify(userRepository, times(1)).deleteUserByEmail("test@gmail.com");
    }


}