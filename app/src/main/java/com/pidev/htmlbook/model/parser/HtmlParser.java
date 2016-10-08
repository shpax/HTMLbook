package com.pidev.htmlbook.model.parser;


import android.content.Context;
import android.view.View;

import com.pidev.htmlbook.model.parser.interfaces.TagHandler;
import com.pidev.htmlbook.model.parser.interfaces.Parser;

import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class HtmlParser implements Parser{

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
    }

    public static void registerHandler(Class c) {
        if (handlerClasses.size() != 0) {
            for (int i=0; i < handlerClasses.size(); i++) try {
                int currentClassOrder = (int) handlerClasses.get(i).getMethod("getOrder").invoke(null);
                int newClassOrder = (int) c.getMethod("getOrder").invoke(null);
                if (currentClassOrder < newClassOrder) {
                    handlerClasses.add(c);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            handlerClasses.add(c);
        }
    }

    @Override
    public View makeView(Element element) {
        return null;
    }
}
