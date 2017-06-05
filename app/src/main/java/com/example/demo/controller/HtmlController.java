package com.example.demo.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
public class HtmlController {

    private final JsBasePath jsBasePath;
    private final String contextPath;

    public HtmlController(final JsBasePath jsBasePath, final WebApplicationContext wac) {
        this.jsBasePath = Objects.requireNonNull(jsBasePath);
        this.contextPath = wac.getServletContext().getContextPath();
    }

    @GetMapping("{name}.html")
    String html(@PathVariable final String name, final CsrfToken csrfToken) {
        final StringWriter s = new StringWriter();
        try (PrintWriter out = new PrintWriter(s)) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>");
            out.printf("    <base href=\"%s/\">%n", contextPath);
            out.println("    <meta charset=\"utf-8\">");
            if (csrfToken != null) {
                out.printf("    <meta name=\"csrf-header-name\" content=\"%1$s\">%n",
                        csrfToken.getHeaderName());
                out.printf("    <meta name=\"csrf-parameter-name\" content=\"%1$s\">%n",
                        csrfToken.getParameterName());
                out.printf("    <meta name=\"csrf-token\" content=\"%1$s\">%n",
                        csrfToken.getToken());
            }
            out.println("    <title>spring-boot-doma-vue-sample</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <div id=\"app\"></div>");
            out.printf("    <script src=\"%1$sassets/vendor.js\"></script>%n", jsBasePath.value);
            out.printf("    <script src=\"%1$sassets/%2$s.js\"></script>%n", jsBasePath.value,
                    name);
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
