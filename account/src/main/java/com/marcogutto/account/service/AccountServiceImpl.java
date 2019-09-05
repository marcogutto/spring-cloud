package com.marcogutto.account.service;

import org.springframework.stereotype.Service;

import com.marcogutto.account.client.AuthServiceFeignClient;
import com.marcogutto.account.dto.UserDto;
import com.marcogutto.account.dto.UserRegistrationDto;

@Service
public class AccountServiceImpl implements AccountService {

    private final AuthServiceFeignClient authServiceFeignClient;

    public AccountServiceImpl(AuthServiceFeignClient authServiceFeignClient) {
        this.authServiceFeignClient = authServiceFeignClient;
    }

    @Override
    public UserDto create(UserRegistrationDto user) {
        return authServiceFeignClient.createUser(user);
    }
}