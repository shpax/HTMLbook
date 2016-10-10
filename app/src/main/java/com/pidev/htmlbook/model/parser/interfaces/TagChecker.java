package com.pidev.htmlbook.model.parser.interfaces;

import com.pidev.htmlbook.model.parser.builders.ViewBuilder;

import org.jsoup.nodes.Element;

/**
 * interface TagChecker handles element check and proper ViewBuilder creation
 */

public interface TagChecker {

    int getOrder();

    boolean isApplicable(Element element);

    ViewBuilder getBuilder(Element element);

}
