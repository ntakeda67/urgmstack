package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.controller.HtmlController.DevLocalJsFileChecker;
import com.example.demo.controller.HtmlController.JarJsFileChecker;
import com.example.demo.controller.HtmlController.JsBasePath;
import com.example.demo.controller.HtmlController.JsFileChecker;

@SpringBootApplication
public class DemoApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    JsBasePath jsBasePath() {
        final String value = devLocal().isDevLocal() ? "//localhost:8888/" : "";
        return new JsBasePath(value);
    }

    @Bean
    JsFileChecker jsFileChecker() {
        if (devLocal().isDevLocal()) {
            return new DevLocalJsFileChecker();
        }
        return new JarJsFileChecker();
    }

    @Bean
    DevLocal devLocal() {
        final boolean devLocal = DemoApplication.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getProtocol()
                .equals("file");
        return () -> devLocal;
    }

    public interface DevLocal {
        boolean isDevLocal();
    }
}
