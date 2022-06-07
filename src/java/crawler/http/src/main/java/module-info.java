module com.company.crawler.http {
    requires com.company.crawler.api;
    provides com.company.crawler.api.Request
        with com.company.crawler.http.HttpRequest;
}
