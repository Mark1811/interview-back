package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.repository.UserDAO;
import com.meli.interview.back.subscription_api.session.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User save(User user) throws Exception{
        if(existUserByName(user.getName()))
            throw  new Exception(" ya existe este usuario");
        user.setId(java.util.UUID.randomUUID().toString());
     return  userDAO.save(user);
    }

    public List<User> findAll(){
       return  userDAO.findAll();
    }

    public Boolean existUserByName(String name){
         return userDAO.existUserByName(name);
    }

     /* verificar que  no se pueda agregar el mismo amigo , ni ser amigo mismo */
    public User addFriends(String name, List<User> friends) throws  Exception {
        User user = userDAO.findByNombre(name).get();
        friends.stream().forEach(friend-> user.addFriend(userDAO.findByNombre(friend.getName()).get()));
        return userDAO.save(user);
    }
}
