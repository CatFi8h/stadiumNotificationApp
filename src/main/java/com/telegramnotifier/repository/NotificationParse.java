/*
 * Copyright (C) Whirl Software PTE LTD. 2014-2020 - All Rights Reserved
 * 600 North Bridge Road, Parkview Square #15-10, Singapore
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * License: see file "LICENSE.txt"
 */
package com.telegramnotifier.repository;

import com.telegramnotifier.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationParse extends JpaRepository<Long, Notification> {

}
