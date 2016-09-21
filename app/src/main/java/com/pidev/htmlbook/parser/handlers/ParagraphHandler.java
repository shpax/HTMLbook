package com.pidev.htmlbook.parser.handlers;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.pidev.htmlbook.parser.HtmlParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by max on 21.09.16.
 */
public class ParagraphHandler extends TagHandler {


    private static String selector = "p";
    private static int order = 50;

    {
        HtmlParser.registerHandler(ParagraphHandler.class);
    }

    public ParagraphHandler(Context context) {
        super(context);
    }

    @Override
    public ArrayList<View> handle(Elements elements) {
        ArrayList<View> views = new ArrayList<>();
        for (Element element:elements) {
            TextView tv = new TextView(this.context);
            tv.setText(Html.fromHtml(element.html()));
            views.add(tv);
        }
        return views;
    }
}
