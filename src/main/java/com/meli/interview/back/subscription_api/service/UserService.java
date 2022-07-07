package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.datos.Role;
import com.meli.interview.back.subscription_api.datos.User;
import com.meli.interview.back.subscription_api.datos.UserRequestDTO;
import com.meli.interview.back.subscription_api.datos.UsernameDto;

import java.util.List;

public interface UserService   {
    User getUser(Integer id);

    User save(User user);

    List<User> findAll();

    User obtenerUsuarioPorCredenciales(UserRequestDTO usuario) throws Exception;

    public Float getUserSubscriptionsCost(UsernameDto userdto) throws Exception;
}
