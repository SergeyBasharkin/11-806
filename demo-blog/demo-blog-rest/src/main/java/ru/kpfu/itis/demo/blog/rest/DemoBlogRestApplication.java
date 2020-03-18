package ru.kpfu.itis.demo.blog.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.kpfu.itis.demo.blog.impl.config.BlogImplConfig;

@SpringBootApplication
@Import(BlogImplConfig.class)
public class DemoBlogRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBlogRestApplication.class, args);
    }

}
