package com.example.demo.controller;

import java.util.Objects;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class HelloController {

    @PostMapping("api/hello")
    HelloResponse hello(@RequestBody final HelloRequest request) {
        final String name = request.name;
        final String message = String.format("Hello, %1$s!", name);
        return new HelloResponse(message);
    }

    public static final class HelloRequest {
        public final String name;
        public HelloRequest(@JsonProperty("name") final String name) {
            this.name = Objects.requireNonNull(name);
        }
    }

    public static final class HelloResponse {
        public final String message;
        public HelloResponse(final String message) {
            this.message = Objects.requireNonNull(message);
        }
    }
}
