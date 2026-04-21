package com.example.wishlist.service;

import com.example.wishlist.model.User;
import com.example.wishlist.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    @Test
    void login_success(){
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserService(repo);

        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("1234");

        when(repo.findByEmail("test@test.com")).thenReturn(user);
        User result = service.login("test@test.com", "1234");

        assertNotNull(result);

    }
}
