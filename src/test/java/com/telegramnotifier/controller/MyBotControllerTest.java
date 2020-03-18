package com.telegramnotifier.controller;

import com.telegramnotifier.model.SignedUser;
import com.telegramnotifier.model.SignedUsers;
import com.telegramnotifier.service.MyBotService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class MyBotControllerTest {

    @Mock
    private MyBotService myBotService;

    private MyBotController controller;

    private MockMvc mockMvc;

    @Before
    public void init() {
        controller = new MyBotController(myBotService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testController() {
        SignedUsers signedUsers = new SignedUsers();
        signedUsers.setTotal(1L);

        SignedUser signedUser = new SignedUser();
        ArrayList<SignedUser> users = new ArrayList<>();
        users.add(signedUser);
        signedUsers.setUsers(users);

        when(myBotService.getSignedUsers()).thenReturn(signedUsers);

        Model modelMap = new ExtendedModelMap();
        controller.getSignedUsers();
    }


}