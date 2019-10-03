package com.telegramnotifier.service.impl;

import com.telegramnotifier.service.MyBotService;
import org.springframework.stereotype.Service;

@Service
public class MyBotServiceImpl implements MyBotService {

    @Override
    public String hello() {
        return "hello";
    }

}
