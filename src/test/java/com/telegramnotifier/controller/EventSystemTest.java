/*
 * Copyright (C) Whirl Software PTE LTD. 2014-2020 - All Rights Reserved
 * 600 North Bridge Road, Parkview Square #15-10, Singapore
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * License: see file "LICENSE.txt"
 */
package com.telegramnotifier.controller;

import org.apache.http.client.methods.RequestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventSystemTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    private void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void allEventsCanBeRetrieved() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/entities"))
            .andExpect(status().isOk())
            .andExpect(content().json("[\"Test1\", \"Test2\"]"));
    }
}
