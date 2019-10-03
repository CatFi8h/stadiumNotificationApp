package com.telegramnotifier.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
class HtmlParserTest {



    @Test
    public void test() throws ParseException {
        HtmlParser htmlParser = new HtmlParser();
        htmlParser.testHtmlParse();

    }
}