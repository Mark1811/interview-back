package com.meli.interview.back.subscription_api.controller;
import com.meli.interview.back.subscription_api.datos.User;
import com.meli.interview.back.subscription_api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class UserControllerWebClientTest {

    @Autowired
    private UserService userService;

    @Autowired
    private WebTestClient client;

    @Test
    void getUsers() {
        client.get()
                .uri("/api/v1/users")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(User.class).isEqualTo(userService.findAll());
    }

    @Test
    void saveUser() {
    }

    @Test
    void addFriend() {
    }

    @Test
    void suscripciones() {
    }
}