package com.pidev.htmlbook.model.article.builder;

import android.view.LayoutInflater;
import android.view.View;

import org.jsoup.nodes.Element;

/**
 * Base class for all builders
 */
public abstract class ViewBuilder {


    /**
     * IMPORTANT
     *
     * There should be a registration static block for each child class
     *
     */

    private LayoutInflater inflater;

    /**
     * Set layout inflater
     */
    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    /**
     * Check if this builder is applicable for this element
     */
    public abstract boolean isApplicable(Element element);

    /**
     * Get Rating that influences builder selection
     */
    public abstract int getRating();

    /**
     * Build view from element
     */
    public abstract View buildView(Element element);

}
