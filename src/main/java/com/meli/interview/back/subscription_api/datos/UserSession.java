package com.meli.interview.back.subscription_api.datos;

import com.meli.interview.back.subscription_api.exception.CollaboratorCallException;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.service.UserService;
import com.meli.interview.back.subscription_api.service.UserServiceImpl;
import com.meli.interview.back.subscription_api.util.JWTUtil;


public class UserSession {


    private UserService userService;
    private static final UserSession userSession = new UserSession();

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    private JWTUtil jwtUtil = new JWTUtil();

    private  String jwt;

    public UserSession setJwt(String jwt) {
        return this;
    }

    private UserSession() {
    }

    public static UserSession getInstance() {
        return userSession;
    }

    public User getLoggedUser() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJrbGF0aGFtN0B0d2l0dGVyLmNvbSIsImlhdCI6MTY1NzIwMTUyMCwic3ViIjoia2xhdGhhbTdAdHdpdHRlci5jb20iLCJpc3MiOiJNYWluIiwiZXhwIjoxNjU3ODA2MzIwfQ.tElF55TSlELAfdS7eGwu4LjSp5IIX0f-3vglvSwfwRY";//request.getHeader("authorization");
        String username = jwtUtil.getValue(token);
         if(!username.isEmpty()){
             UserRequestDTO user = new UserRequestDTO();
             user.setUsername(username);
             return userService.obtenerUsuarioPorCredenciales(user);
         }
        throw new CollaboratorCallException(
                "UserSession.getLoggedUser() should not be called in an unit test");
    }

    public String obtenerToken(UserServiceImpl userService, UserRequestDTO user) throws Exception {
        setUserService(userService);
        User usuarioLogueado = userService.obtenerUsuarioPorCredenciales(user);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getUsername()),user.getUsername());
            return tokenJwt;
        }
        throw new UserNotLoggedInException("usuario no registrado");
    }




}
