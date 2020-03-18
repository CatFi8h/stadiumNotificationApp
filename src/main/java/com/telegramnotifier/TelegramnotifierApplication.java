package com.telegramnotifier;

import com.telegramnotifier.bot.SuperBot;
import com.telegramnotifier.bot.TelegramMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Slf4j
@SpringBootApplication
public class TelegramnotifierApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi botsApi = new TelegramBotsApi();
		try {
			botsApi.registerBot(new SuperBot(new TelegramMessageSender()));
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}

		SpringApplication.run(TelegramnotifierApplication.class, args);
	}

}
