package com.example.knap_web_v1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class KnapManualTests {
    public static void main(String[] args) {
        // Create an HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Define the request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/v1/log"))
                .GET()
                .build();

        // Send the request and handle the response
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println("Status Code: " + response.statusCode());
                    System.out.println("Response Body: " + response.body());
                })
                .join();

        // Define the request
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/v1/message"))
                .GET()
                .build();

        // Send the request and handle the response
        client.sendAsync(request2, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println("Status Code: " + response.statusCode());
                    System.out.println("Response Body: " + response.body());
                })
                .join();
    }
}
