package com.telegramnotifier.utils;

import com.telegramnotifier.model.dto.ParsedItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.telegramnotifier.utils.Constants.*;
import static java.util.stream.Collectors.toList;

@Component
public class HtmlParser {
    public List<ParsedItem> testHtmlParse() {
        Document document = null;
        String domain = "http://www.nsc-olimpiyskiy.com.ua";
        try {
            document = Jsoup.connect(domain + "/ru/events/").get();
        } catch (IOException e) {
            e.getMessage();
        }
        Elements elementsByClass = null;
        if (document != null) {
            elementsByClass = document.getElementsByClass("items");
            List<ParsedItem> parsedItems = null;
            for (Element e : elementsByClass) {
                parsedItems = e.childNodes().stream().map(this::getNodeFromElement).filter(Objects::nonNull).collect(toList());
            }
            return parsedItems;
        }
        return null;
    }

    private ParsedItem getNodeFromElement(Node node) {
        if (node.nodeName().equals(DIV)) {
            Element element = (Element) node;
            Element item = getElementVal(element, ITEM_NAME);
            if (item != null) {
                Element date = getElementVal(item, DATE_NAME);
                Element time = getElementVal(item, TIME_NAME);
                Element title = getElementVal(item, TITLE_NAME);
                Element link = getElementVal(item, READ_MORE);

                String dateStr = date.ownText();
                String timeStr = time.ownText();
                String titleStr = title.ownText();
                String linkStr = link.attributes().get(HREF);

                Date dateAndTimeFrom = null;
                try {
                    dateAndTimeFrom = DateUtil.parseDateAndTimeFrom(dateStr, timeStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return new ParsedItem(titleStr, dateAndTimeFrom, linkStr);
            }


        }
        return null;
    }

    private Element getElementVal(Element item, String date) {
        return item.getElementsByClass(date).first();
    }


}
