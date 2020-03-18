package com.telegramnotifier.service;

import com.telegramnotifier.model.SignedUsers;

public interface MyBotService {
    String hello();

    SignedUsers getSignedUsers();
}
