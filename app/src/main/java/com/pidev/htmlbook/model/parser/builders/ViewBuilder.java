package com.pidev.htmlbook.model.parser.builders;

import android.view.LayoutInflater;
import android.view.View;

import org.jsoup.nodes.Element;

/**
 * class ViewBuilder is a base class for all builders
 */

public abstract class ViewBuilder {

    protected Element element;

    public ViewBuilder(Element element) {
        this.element = element;
    }


    /**
     * method buildView represents actual xml setup
     */

    public abstract View buildView(LayoutInflater inflater);

}
