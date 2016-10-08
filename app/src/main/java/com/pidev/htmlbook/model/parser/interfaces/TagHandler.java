package com.pidev.htmlbook.model.parser.interfaces;

import android.view.View;

import org.jsoup.nodes.Element;

public interface TagHandler {

    int getOrder();

    boolean isApplicable(Element element);

    View makeView(Element element);

}
