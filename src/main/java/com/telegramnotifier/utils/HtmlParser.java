package com.telegramnotifier.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class HtmlParser {

    public  testHtmlParse() throws ParseException {
        Document document = null;
        try {
            document = Jsoup.connect("http://www.nsc-olimpiyskiy.com.ua/ru/events/").get();
        } catch (IOException e) {
            e.getMessage();
        }
        Elements elementsByClass = null;
        if (document != null) {
            elementsByClass = document.getElementsByClass("items");
            for (Element e : elementsByClass) {
                List<Node> nodes = e.childNodes();
                for (Node node : nodes) {
                    if (node.nodeName().equals("div")) {
                        Element element = (Element) node;
                        Elements items = element.getElementsByClass("item");
                        Element item = items.get(0);
                        Element date = item.getElementsByClass("date").get(0);
                        String dateStr = date.ownText();
                        Element time = item.getElementsByClass("time").get(0);
                        String timeStr = time.ownText();
                        Element title = item.getElementsByClass("title").get(0);
                        String titleStr = title.ownText();

                        parseDateAndTimeFrom(dateStr, timeStr);

                        System.out.println(dateStr + "\n" + timeStr + "\n" + titleStr + "\n");
                    }
                }
            }
        }

    }

    private Date parseDateAndTimeFrom(String date, String time) throws ParseException {

        String[] callendarMonthRu = {"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};
        List<String> monthRu = Arrays.asList(callendarMonthRu);
        String[] dateAndMonth = date.split(" ");
        String day = dateAndMonth[0];
        String monthStr = dateAndMonth[1];
        int month = IntStream.range(0, monthRu.size()).filter(i -> callendarMonthRu[i].equalsIgnoreCase(monthStr)).findAny().orElse(-1) + 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        String datePattern = month + "-" + day + " " + time;
        Date parse = dateFormat.parse(datePattern);
        System.out.println(parse);
        return parse;
    }

}
