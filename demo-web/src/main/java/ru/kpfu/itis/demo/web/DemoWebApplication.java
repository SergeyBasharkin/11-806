package ru.kpfu.itis.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.accept;

@SpringBootApplication
public class DemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> router() {
        return RouterFunctions
                .route().GET("/func",
                        accept(MediaType.valueOf("application/json")),
                        serverRequest -> ServerResponse.ok().body("Hello from func")
                ).build();
    }
}
