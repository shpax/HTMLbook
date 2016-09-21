package com.pidev.htmlbook.parser;


import com.pidev.htmlbook.parser.handlers.TagHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class HtmlParser {

    private static ArrayList<Class<TagHandler>> handlerClasses;
    private Document document;

    public HtmlParser(String html) {
        this.document = Jsoup.parse(html);
    }

    public static void registerHandler(Class c) {
        HtmlParser.handlerClasses.add(c);
    }

}
