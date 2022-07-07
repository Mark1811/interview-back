package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.datos.Subscription;
import com.meli.interview.back.subscription_api.datos.User;
import com.meli.interview.back.subscription_api.datos.UserSession;
import com.meli.interview.back.subscription_api.datos.UsernameDto;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.repository.SubscriptionRepository;
import com.meli.interview.back.subscription_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    private String jwt;

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public SubscriptionServiceImpl() {
    }

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private UserRepository userRepository ;


    /**
     * Devuelve el costo total de las suscripciones de un usuario siempre que el usuario que esté logueado,
     * se encuentre en su lista de amigos
     *
     * @param userdto
     * @return costo total de la suscripciones del user
     * @throws UserNotLoggedInException si no hay un usuario logueado
     */

    @Override
    public Float getUserSubscriptionsCost(UsernameDto userdto) throws Exception {
        User friend = userRepository.findByUsername(userdto.getUsername());

        if (!Objects.isNull(friend)) {
            ArrayList<Subscription> subscriptionList = new ArrayList<Subscription>();

            User loggedUser = UserSession.getInstance().getLoggedUser();

            if (loggedUser != null) {
                boolean isFriend = friend.getFriends().contains(loggedUser);

                if (isFriend) {
                    subscriptionList = subscriptionRepository.findByUser(friend);
                }
                return (float) subscriptionList.stream()
                        .mapToDouble(Subscription::getPrice)
                        .sum();

           /* for (User friend : user.getFriends()) {// de ese usuario se obtiene una lista de Usuario
                if (friend.equals(loggedUser)) {// se itera la lista y se busca que el usuario este logueado
                    isFriend = true;
                    break;
                }
            }*/

           /* float totalPrice = 0;

            for (Subscription subscription : subscriptionList) {
                totalPrice += subscription.getPrice();
            }
            return totalPrice;*/
            } else {
                throw new UserNotLoggedInException("");
            }
        } else {
            throw new EntityNotFoundException("El usuario indicado no existe");
        }
    }

}//End of class