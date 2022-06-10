package com.meli.interview.back.subscription_api.session;

import com.meli.interview.back.subscription_api.exception.CollaboratorCallException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserSession {

    private static final UserSession userSession = new UserSession();
    private String  jwt;

    private UserSession() {
    }

    public static UserSession getInstance() {
        return userSession;
    }

    public User getLoggedUser() {

        throw new CollaboratorCallException(
            "UserSession.getLoggedUser() should not be called in an unit test");
    }


    public  void setJwt(String jwt){
        this.jwt = jwt;
    }




}
