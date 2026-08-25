package org.example;
import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

// Driver Class
public class Main{

    public static void main(String[] args)
    {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

            server.createContext("/", new MyHandler());

            server.setExecutor(null); 
            server.start();

            System.out.println("Server is running on port 8000");
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }

    // Define a custom HttpHandler
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException
        {
            Gson gson = new Gson();
            CoursesService coursesService = new CoursesService();
            String requestMethod = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath();
            String role = exchange.getRequestHeaders().getFirst("ROLE");
            String[] subDirs = path.split("/");

            if(requestMethod.equals("GET")){
                if (subDirs.length == 3 && path.equals("/api/v1/Courses")){
                    //1
                }
                else if (subDirs.length > 3){
                    if (role.equals("USER")){

                    } else // 403

                }
                else {
                    // 404 not found
                }
                
            } else if (requestMethod.equals("POST")) {
                if (role.equals("ADMIN")){

                } else // 403
                
            } else if (requestMethod.equals("PUT")) {
                if (role.equals("ADMIN") || role.equals("TEACHER")){

                }

            } else if (requestMethod.equals("DELETE")) {
                if (role.equals("ADMIN")){

                } else // 403
            }

            // Handle the request
            String response = "Hello, this is a simple HTTP server response!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}