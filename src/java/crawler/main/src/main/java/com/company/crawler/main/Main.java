package com.company.crawler.main;

import java.util.ServiceLoader;

import com.company.crawler.api.Request;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Iterable<Request> requests = ServiceLoader.load(Request.class);
        for (Request request: requests) {
            String result = request.get("https://www.google.com");
            System.out.println("Service: " + request.getName());
            System.out.println(result);
        }

        System.out.println("Terminate.");
    }

}
