package com.example.demo.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmlController {

    private final JsBasePath jsBasePath;

    public HtmlController(final JsBasePath jsBasePath) {
        this.jsBasePath = Objects.requireNonNull(jsBasePath);
    }

    @GetMapping("{name}.html")
    String html(@PathVariable final String name) {
        final StringWriter s = new StringWriter();
        try (PrintWriter out = new PrintWriter(s)) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>");
            out.println("    <meta charset=\"utf-8\">");
            out.println("    <title>spring-boot-doma-vue-sample</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <div id=\"app\"></div>");
            out.printf("    <script src=\"%1$s/vendor.js\"></script>%n", jsBasePath.value);
            out.printf("    <script src=\"%1$s/%2$s.js\"></script>%n", jsBasePath.value, name);
            out.println("  </body>");
            out.println("</html>");
            out.flush();
        }
        return s.toString();
    }

    public static class JsBasePath {

        public final String value;

        public JsBasePath(final String value) {
            this.value = Objects.requireNonNull(value);
        }
    }
}
