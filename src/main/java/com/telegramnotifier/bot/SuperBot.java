package com.telegramnotifier.bot;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@RequiredArgsConstructor
public class SuperBot extends TelegramLongPollingBot {
    private final TelegramMessageSender sender;

    @Value("${bot.key}")
    private String key;

    @SneakyThrows @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) {
            return;
        }
        Message message = update.getMessage();
        long chatId = message.getChatId();
        if (message.hasText()) {
            execute(sender.sendTextMessage(message, chatId));
        } else if (message.hasPhoto()) {
            execute(sender.sendPhotoMessage(message, chatId));
        }
    }

    @Override
    public String getBotUsername() {
        return "iGorAwesomeBot";
    }

    @Override
    public String getBotToken() {
        return key;
    }
}
