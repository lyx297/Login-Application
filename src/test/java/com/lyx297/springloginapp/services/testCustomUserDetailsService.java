package com.lyx297.springloginapp.services;

import com.lyx297.springloginapp.entity.User;
import com.lyx297.springloginapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest

public class testCustomUserDetailsService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private CustomUserDetailsService service;

    @Test
    public void testLoadUserByUsernameIsWorking() {
        User user = new User();
        user.setUsername("abc");
        user.setPassword("abc1");
        repo.save(user);
        service.loadUserByUsername("abc");

    }
}
