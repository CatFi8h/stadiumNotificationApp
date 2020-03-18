package com.telegramnotifier.service.impl;

import com.telegramnotifier.model.SignedUsers;
import com.telegramnotifier.repository.UserRepositoty;
import com.telegramnotifier.service.MyBotService;
import org.springframework.stereotype.Service;

@Service
public class MyBotServiceImpl implements MyBotService {

    private UserRepositoty userRepositoty;

    @Override
    public String hello() {
        return "hello";
    }

    @Override public SignedUsers getSignedUsers() {
        return null;
    }

}
