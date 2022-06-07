package com.company.crawler.http;

import com.company.crawler.api.Request;

public class HttpRequest implements Request {

    @Override
    public String getName() {
        return "HttpRequest";
    }

    @Override
    public String get(String url) {
        return "HTTP Request: " + url;
    }
}
