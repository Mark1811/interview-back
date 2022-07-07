package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.datos.*;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.repository.SubscriptionRepository;
import com.meli.interview.back.subscription_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public User getUser(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }



    @Override
    public User obtenerUsuarioPorCredenciales(UserRequestDTO usuario) throws Exception {
     User user = userRepository.findByUsername(usuario.getUsername());
     if(user != null || (user.getPassword().equals(usuario.getPassword()))){
         return user;
     }
     throw new Exception("las contraseñas no coinciden");
    }


}
