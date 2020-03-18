/*
 * Copyright (C) Whirl Software PTE LTD. 2014-2020 - All Rights Reserved
 * 600 North Bridge Road, Parkview Square #15-10, Singapore
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * License: see file "LICENSE.txt"
 */
package com.telegramnotifier.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.util.Comparator;
import java.util.List;

@Component
public class TelegramMessageSender {

    public SendPhoto sendPhotoMessage(Message message, long chatId) {
        List<PhotoSize> photo = message.getPhoto();
        PhotoSize photoSize = photo.stream().min(Comparator.comparing(PhotoSize::getFileSize)).orElse(null);
        if (photoSize != null) {
            String fileId = photoSize.getFileId();
            Integer height = photoSize.getHeight();
            Integer width = photoSize.getWidth();
            String caption = "file_id: " + fileId + "\nwidth: " + Integer.toString(width) + "\nheight: " + Integer.toString(height);

            return new SendPhoto().setCaption(caption).setPhoto(fileId).setChatId(chatId);
        }
        return null;
    }

    public SendMessage sendTextMessage(Message message, long chatId) {
        return new SendMessage().setChatId(chatId)
            .setText(message.getText());
    }

}
