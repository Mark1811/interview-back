package com.meli.interview.back.subscription_api.repository;

import com.meli.interview.back.subscription_api.datos.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void name() {
        User user = new User();
        user.setUsername("facundo");
        user.setPassword("dsfsf");
        user.setName("sfsf");
        userRepository.save(user);
       userRepository.findAll();
    }
}