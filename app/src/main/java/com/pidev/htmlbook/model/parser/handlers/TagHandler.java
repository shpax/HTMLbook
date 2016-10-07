package com.pidev.htmlbook.model.parser.handlers;

import android.content.Context;
import android.view.View;

import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by max on 21.09.16.
 */
public abstract class TagHandler {

    protected static String selector = "";
    protected static int order = 100;
    protected Context context;

    public TagHandler(Context context) {
        this.context = context;
    }

    public String getSelector() {
        return selector;
    }

    public int getOrder() {
        return order;
    }

    public abstract ArrayList<View> handle(Elements elements);

}