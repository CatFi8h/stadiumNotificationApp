/*
 * Copyright (C) Whirl Software PTE LTD. 2014-2020 - All Rights Reserved
 * 600 North Bridge Road, Parkview Square #15-10, Singapore
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * License: see file "LICENSE.txt"
 */
package com.telegramnotifier.model;

import lombok.Data;

import java.util.List;

@Data
public class SignedUsers {
    private List<SignedUser> users;
    private Long total;
}
