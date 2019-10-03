package com.telegramnotifier.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Component
public class SuperBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) {
            return;
        }
        Message message = update.getMessage();
        long chatId = message.getChatId();
        if (message.hasText()) {
            SendMessage sendMessage = new SendMessage().setChatId(chatId)
                    .setText(message.getText());
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }

        } else if (message.hasPhoto()) {
            List<PhotoSize> photo = message.getPhoto();
            PhotoSize photoSize = photo.stream().min(Comparator.comparing(PhotoSize::getFileSize)).orElse(null);
            if (photoSize != null) {
                String fileId = photoSize.getFileId();
                Integer height = photoSize.getHeight();
                Integer width = photoSize.getWidth();
                String caption = "file_id: " + fileId + "\nwidth: " + Integer.toString(width) + "\nheight: " + Integer.toString(height);
                SendPhoto sendPhoto = new SendPhoto().setCaption(caption).setPhoto(fileId).setChatId(chatId);

                try {
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "iGorAwesomeBot";
    }

    @Override
    public String getBotToken() {
        return "831257557:AAEv2gU-VW6G4CH4CxJD3xP3ootP2CGYGzc";
    }
}
