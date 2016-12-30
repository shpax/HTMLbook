package com.pidev.htmlbook.model.article.interfaces;

import com.pidev.htmlbook.model.article.builder.ViewBuilder;

import org.jsoup.nodes.Element;

/**
 * interface TagChecker handles element check and proper ViewBuilder creation
 */

public interface TagChecker {

    int getOrder();

    boolean isApplicable(Element element);

    ViewBuilder getBuilder(Element element);

}
