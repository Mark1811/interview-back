package com.meli.interview.back.subscription_api.repository;

import com.meli.interview.back.subscription_api.session.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserDAO {
     private  User user = new User("1","Facundo", "cordobafs@gmail.com","1234");
     private List<User> usuarios = Arrays.asList(user);

    public User save(User user) throws Exception {;
        usuarios.add(user);
        return user;
    }

    public List<User> findAll() {
        return usuarios;
    }
    public Optional<User> findByNombre(String nombre){
        return findAll().stream()
                .filter(u->u.getName().equals(nombre)).findFirst();
    }

    public  Boolean existUserByName(String nombre){
        return (findAll().size()==0)? false : findByNombre(nombre).isPresent();
    }

}
