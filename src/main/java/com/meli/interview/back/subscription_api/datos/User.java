package com.meli.interview.back.subscription_api.datos;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class User   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String password;

    public User(String name, String username, String password) {
        this.id = 1;
        this.name = name;
        this.username = username;
        this.password = password;
    }


    /*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USUARIOS_ROLES", joinColumns = {
            @JoinColumn(name = "USUARIO_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;*/



    public User() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public List<User> getFriends() {
        return friends;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Subscription> subscriptions ;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> friends ;

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
}
