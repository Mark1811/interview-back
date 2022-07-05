
package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.datos.Subscription;
import com.meli.interview.back.subscription_api.datos.User;
import com.meli.interview.back.subscription_api.datos.UserSession;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;

import java.util.ArrayList;


public class SubscriptionService {
    private String jwt;

    public SubscriptionService() {
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    /**
     * Devuelve el costo total de las suscripciones de un usuario siempre que el usuario que esté logueado,
     * se encuentre en su lista de amigos
     *
     * @param user
     * @return costo total de la suscripciones del user
     * @throws UserNotLoggedInException si no hay un usuario logueado
     */
    public Float getUserSubscriptionsCost(User user) throws Exception {
        ArrayList<Subscription> subscriptionList = new ArrayList<Subscription>();
        // get logged user
        User loggedUser = UserSession.getInstance().getLoggedUser();
        boolean isFriend = false;
        if (loggedUser != null) {
            for (User friend : user.getFriends()) {
                if (friend.equals(loggedUser)) {
                    isFriend = true;
                    break;
                }
            }
            if (isFriend) {
       //         subscriptionList = SuscriptionDAO.findSubscriptionByUser(user);
            }

            float totalPrice = 0;

            for (Subscription subscription : subscriptionList) {
                totalPrice += subscription.getPrice();
            }
            return totalPrice;
        } else {
           throw new UserNotLoggedInException("");
        }
    }


}
