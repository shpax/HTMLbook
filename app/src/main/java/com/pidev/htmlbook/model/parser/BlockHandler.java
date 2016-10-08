package com.pidev.htmlbook.model.parser;

import android.os.AsyncTask;
import android.view.View;

import com.pidev.htmlbook.model.parser.interfaces.Parser;
import com.pidev.htmlbook.model.parser.listeners.OnElementParsedListener;
import com.pidev.htmlbook.model.parser.listeners.OnViewListListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by max on 05.10.16.
 *
 * BlockHandler manages page pieces, such as article itself, menus and page header
 *
 */

public class BlockHandler implements OnElementParsedListener {

    private static final String ARTICLE_SELECTOR = "ARTICLE .field-item.even > *";

    private Document document;
    private String selector;
    private OnViewListListener viewListListener;

    public BlockHandler(String selector) {
        this.selector = selector;
    }

    public void setDocument(Document doc) {
        this.document = doc;
    }

    public void setDocument(String html) {
        this.document = Jsoup.parse(html);
    }

    public void setViewListListener(OnViewListListener viewListListener) {
        this.viewListListener = viewListListener;
    }

    public void parseBlock(Class<Parser> parserClass) {
        Elements elements = document.select(this.selector);
        int order = 0;
        for (Element element : elements) {
            new AsyncParser(parserClass, this, order).execute(element);
            order++;
        }
    }

    @Override
    public void OnViewReady(View view, int order) {
        // todo: implement viewListListener call after all views are ready
    }

    private class AsyncParser extends AsyncTask<Element, Void, View> {

        private Class<Parser> parserClass;
        private OnElementParsedListener listener;
        private int order;

        AsyncParser(Class<Parser> parserClass, OnElementParsedListener listener, int order) {
            this.parserClass = parserClass;
            this.listener = listener;
            this.order = order;
        }

        @Override
        protected View doInBackground(Element... params) {
            try {
                Parser parser = this.parserClass.newInstance();
                return parser.makeView(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(View view) {
            listener.OnViewReady(view, this.order);
        }
    }
}
