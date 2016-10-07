package com.pidev.htmlbook.model.parser;


import android.content.Context;
import android.view.View;

import com.pidev.htmlbook.model.parser.handlers.TagHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Comparator;

public class HtmlParser {

    public static final String ARTICLE_SELECTOR = "ARTICLE .field-item.even";

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

        this.handlers.sort(new Comparator<TagHandler>() {
            @Override
            public int compare(TagHandler o1, TagHandler o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });
    }

    public ArrayList<View> parseHTML(String html) {
        Document document = Jsoup.parse(html);

        ArrayList<View> result = new ArrayList<>();

        for (TagHandler tagHandler : this.handlers) {
            result.addAll(tagHandler.handle(document.select(tagHandler.getSelector())));
        }

        return result;
    }

    public static void registerHandler(Class c) {
        HtmlParser.handlerClasses.add(c);
    }

}
