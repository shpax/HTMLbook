package com.pidev.htmlbook.model.parser.checkers;

import com.pidev.htmlbook.model.parser.HtmlParser;
import com.pidev.htmlbook.model.parser.builders.H3Builder;
import com.pidev.htmlbook.model.parser.builders.ViewBuilder;
import com.pidev.htmlbook.model.parser.interfaces.TagChecker;

import org.jsoup.nodes.Element;

public class H3Checker implements TagChecker {

    static {
        HtmlParser.addTagChecker(new H3Checker());
    }

    @Override
    public int getOrder() {
        return 100;
    }

    @Override
    public boolean isApplicable(Element element) {
        return "h3".equals(element.tagName());
    }

    @Override
    public ViewBuilder getBuilder(Element element) {
        return new H3Builder(element);
    }
}
