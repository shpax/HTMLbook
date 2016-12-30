package com.pidev.htmlbook.model.article;

import com.pidev.htmlbook.model.article.builder.ViewBuilder;
import com.pidev.htmlbook.model.article.interfaces.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

/**
 * BlockHandler manages page pieces, such as article, menus and page header
 */

public class BlockHandler {

    private static final String ARTICLE_SELECTOR = "ARTICLE .field-item.even > *";

    private Document document;
    private String selector;

    public BlockHandler(String selector) {
        this.selector = selector;
    }

    public BlockHandler setDocument(Document doc) {
        this.document = doc;
        return this;
    }

    public BlockHandler setDocument(String html) {
        this.document = Jsoup.parse(html);
        return this;
    }

    public ArrayList<ViewBuilder> makeViewBuilderList(Parser parser) {

    }

}
