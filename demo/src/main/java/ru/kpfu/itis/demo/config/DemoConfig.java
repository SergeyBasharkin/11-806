package ru.kpfu.itis.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.kpfu.itis.demo.repository.DemoRepository;
import ru.kpfu.itis.demo.service.DemoService;

@Configuration
public class DemoConfig {

    @Bean
    public DemoService demoService(DemoRepository repository){
        return new DemoService(repository);
    }
}
