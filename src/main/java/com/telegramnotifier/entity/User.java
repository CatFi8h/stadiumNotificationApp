/*
 * Copyright (C) Whirl Software PTE LTD. 2014-2020 - All Rights Reserved
 * 600 North Bridge Road, Parkview Square #15-10, Singapore
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * License: see file "LICENSE.txt"
 */
package com.telegramnotifier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nick;
}
