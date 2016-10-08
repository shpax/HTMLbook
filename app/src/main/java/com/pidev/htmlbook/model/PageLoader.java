package com.pidev.htmlbook.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.pidev.htmlbook.model.parser.listeners.OnPageHtmlLoadedListener;

import cz.msebera.android.httpclient.Header;

public class PageLoader {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public PageLoader() {
//        client = new AsyncHttpClient();
    }

    public void getPageHTML(String pageUrl, final OnPageHtmlLoadedListener listener) {
        client.get(pageUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                listener.onHtmlLoaded(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

}
