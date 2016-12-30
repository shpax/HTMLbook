package com.pidev.htmlbook.model.article;


import com.pidev.htmlbook.model.article.builder.ViewBuilder;
import com.pidev.htmlbook.model.article.interfaces.Parser;
import com.pidev.htmlbook.model.article.interfaces.TagChecker;

import org.jsoup.nodes.Element;

import java.util.ArrayList;

/**
 * class HtmlParser is a representation of Parser interface
 */

public class HtmlParser implements Parser {

    private static ArrayList<TagChecker> tagCheckers;
    public HtmlParser() {}

    public static void addTagChecker(TagChecker tagChecker) {
        for (int i = 0; i < tagCheckers.size(); i++) {
            if (tagCheckers.get(i).getOrder() < tagChecker.getOrder()) {
                tagCheckers.add(i, tagChecker);
                return;
            }
        }

        tagCheckers.add(tagChecker);
    }

    @Override
    public ViewBuilder getBuilder(Element element) {
        for (TagChecker checker : tagCheckers) {
            if (checker.isApplicable(element)) {
                return checker.getBuilder(element);
            }
        }
        return null;
    }
}
