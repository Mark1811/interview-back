package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.datos.DTO.UsernameDto;

public interface SubscriptionService {
    Float getUserSubscriptionsCost(UsernameDto userdto) throws Exception;
}
