package com.meli.interview.back.subscription_api.user;


import com.meli.interview.back.subscription_api.service.UserService;
import com.meli.interview.back.subscription_api.session.User;
import com.meli.interview.back.subscription_api.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        try {
              userService.save(user);
        } catch (Exception e) {
             user =null;
        }
        return user;
    }


    @GetMapping("/users")
    public List<User> findAllUsers(){
      return  userService.findAll();
    }


    @PutMapping(value = "/users/friends", params = "name")
    public User addFriends(@RequestParam String name, @RequestBody List<User> friends ) throws Exception {
       return userService.addFriends(name,friends);
    }







}
