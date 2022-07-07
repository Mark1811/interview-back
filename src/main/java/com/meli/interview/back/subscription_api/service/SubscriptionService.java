package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.datos.UsernameDto;

public interface SubscriptionService {
    public Float getUserSubscriptionsCost(UsernameDto userdto) throws Exception;

    public void setJwt(String jwt);
}
