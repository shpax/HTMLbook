package com.pidev.htmlbook.model.parser.handlers;

import android.view.View;

import com.pidev.htmlbook.model.parser.interfaces.TagHandler;

import org.jsoup.nodes.Element;

/**
 * Created by max on 08.10.16.
 */

public class h3Handler implements TagHandler {

    @Override
    public int getOrder() {
        return 100;
    }

    @Override
    public boolean isApplicable(Element element) {
        return "h3".equals(element.tagName());
    }

    @Override
    public View makeView(Element element) {
        return null;
    }
}
