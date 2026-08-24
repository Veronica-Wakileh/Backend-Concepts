package org.example;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        String payload = "It works!";
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            byte[] body = payload.getBytes(StandardCharsets.UTF_8);

            Headers responseHeaders = exchange.getResponseHeaders();
            responseHeaders.add("Content-Type", "text/plain; charset=UTF-8");

            exchange.sendResponseHeaders(200, body.length);

            OutputStream responseBodyStream = exchange.getResponseBody();
            responseBodyStream.write(body);
            responseBodyStream.flush();
            responseBodyStream.close();
        });

        server.start();

    }
}
