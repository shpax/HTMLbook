package com.pidev.htmlbook.model.parser;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by max on 05.10.16.
 *
 * PageHandler manages page pieces, such as article itself, menus and page header
 *
 */
public class PageHandler {

    public static final int BLOCK_ARTICLE = 123;

    private static final String ARTICLE_SELECTOR = "ARTICLE .field-item.even";

    private Document document;
    private Elements articleElements;
    private HtmlParser parser;

    public PageHandler (String html) {
        this(Jsoup.parse(html));
    }

    public PageHandler (Document doc) {
        this.document = doc;
        this.parser = new HtmlParser();
        this.articleElements = this.document.select(ARTICLE_SELECTOR);
    }

    public ArrayList<View> getPageBlockViews(int blockType, Context context) {
        ArrayList<View> result;
        switch (blockType) {
            case BLOCK_ARTICLE:
                return this.parser.parseHTML("asd");
        }
        return new ArrayList<View>();
    }

}
