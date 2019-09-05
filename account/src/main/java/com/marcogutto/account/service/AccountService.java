package com.marcogutto.account.service;

import com.marcogutto.account.dto.UserDto;
import com.marcogutto.account.dto.UserRegistrationDto;

public interface AccountService {

    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    UserDto create(UserRegistrationDto user);
}