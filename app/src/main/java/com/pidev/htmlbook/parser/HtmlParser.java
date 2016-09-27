package com.pidev.htmlbook.parser;


import android.content.Context;
import android.view.View;

import com.pidev.htmlbook.parser.handlers.TagHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Comparator;

public class HtmlParser {

    private static ArrayList<Class<TagHandler>> handlerClasses;
    private ArrayList<TagHandler> handlers;
    private Context context;

    public HtmlParser(Context context) {
        this.context = context;

        this.handlers = new ArrayList<>();
        for (Class<TagHandler> handlerClass : handlerClasses) {
            try {
                this.handlers.add(handlerClass.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //todo: sort handler classes
    }

    public ArrayList<View> parseData(String html) {
        Document document = Jsoup.parse(html);

        return null;
    }

    public static void registerHandler(Class c) {
        HtmlParser.handlerClasses.add(c);
    }

}
