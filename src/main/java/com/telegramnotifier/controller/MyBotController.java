package com.telegramnotifier.controller;

import com.telegramnotifier.model.SignedUsers;
import com.telegramnotifier.service.MyBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class MyBotController {

    private final MyBotService myBotService;

    @GetMapping("hello")
    public String sayHello() {
        return myBotService.hello();
    }

    @GetMapping("getSignedUsers")
    public SignedUsers getSignedUsers() {
        return myBotService.getSignedUsers();
    }
}
