package com.meli.interview.back.subscription_api.datos;

import com.meli.interview.back.subscription_api.datos.DTO.UserRequestDTO;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.service.UserService;
import com.meli.interview.back.subscription_api.service.impl.UserServiceImpl;
import com.meli.interview.back.subscription_api.util.JWTUtil;

public class UserSession {

    private UserService userService;

    private static final UserSession userSession = new UserSession();

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    private JWTUtil jwtUtil = new JWTUtil();

    private String jwt;

    public UserSession setJwt(String jwt) {
        return this;
    }

    public String getJwt() {
        return this.jwt;
    }

    private UserSession() {
    }

    public static UserSession getInstance() {
        return userSession;
    }

    public User getLoggedUser() throws UserNotLoggedInException {
        //String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmY29yZG9iYSIsImlhdCI6MTY1Njk1OTk1MCwic3ViIjoiIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY1NzU2NDc1MH0.bEeuRlpfiOd3sG4Hvz1E6CSrQJS4NkoVlLH0LQ-RRHQ";//request.getHeader("authorization");
        //
        String username = jwtUtil.getValue(this.jwt);
        String password = "q8qeYx4Pf"; //TODO borrar esto.

        if (!username.isEmpty()) {
            UserRequestDTO user = new UserRequestDTO();
            user.setUsername(username);
           user.setPassword(password);
            return userService.obtenerUsuarioPorCredenciales(user);
        }
        throw new UserNotLoggedInException("No hay ningún usuario logueado actualmente");
    }

    public String obtenerToken(UserServiceImpl userService, UserRequestDTO user) throws Exception {
        setUserService(userService);
        User usuarioLogueado = userService.obtenerUsuarioPorCredenciales(user);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getUsername()), user.getUsername());
            this.jwt = tokenJwt;
            return tokenJwt;
        }
        throw new UserNotLoggedInException("Usuario no registrado");
    }
}