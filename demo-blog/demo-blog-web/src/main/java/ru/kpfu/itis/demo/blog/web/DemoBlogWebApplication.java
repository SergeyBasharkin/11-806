package ru.kpfu.itis.demo.blog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ru.kpfu.itis.demo.blog.impl.config.BlogImplConfig;

@EnableAsync
@Import(BlogImplConfig.class)
@SpringBootApplication
public class DemoBlogWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBlogWebApplication.class, args);
    }

    @Bean(name = "executor")
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(2);
        return threadPoolTaskExecutor;
    }
}
