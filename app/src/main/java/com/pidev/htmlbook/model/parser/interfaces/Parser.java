package com.pidev.htmlbook.model.parser.interfaces;

import android.view.View;

import org.jsoup.nodes.Element;

/**
 * Created by max on 08.10.16.
 */

public interface Parser {

    View makeView(Element element);

}
