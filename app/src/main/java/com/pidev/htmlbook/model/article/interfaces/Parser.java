package com.pidev.htmlbook.model.article.interfaces;

import com.pidev.htmlbook.model.article.builder.ViewBuilder;

import org.jsoup.nodes.Element;

/**
 * interface Parser is a base interface for handling TagCheckers and ViewBuilders
 */

public interface Parser {

    ViewBuilder getBuilder(Element element);

}
