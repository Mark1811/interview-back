package com.meli.interview.back.subscription_api.service.impl;

import com.meli.interview.back.subscription_api.datos.User;
import com.meli.interview.back.subscription_api.datos.DTO.UserRequestDTO;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.repository.UserRepository;
import com.meli.interview.back.subscription_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
    public User obtenerUsuarioPorCredenciales(UserRequestDTO usuario) throws UserNotLoggedInException {
        User user = userRepository.findByUsername(usuario.getUsername());
        if (user != null && (user.getPassword().equals(usuario.getPassword()))) {
            return user;
        } else {
            throw new UserNotLoggedInException("Usuario o contraseña inválidos");
        }
    }


}
