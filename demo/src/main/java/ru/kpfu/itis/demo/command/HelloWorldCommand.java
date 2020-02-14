package ru.kpfu.itis.demo.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.dto.TestDto;
import ru.kpfu.itis.demo.service.DemoService;

@Component
@Slf4j
public class HelloWorldCommand implements CommandLineRunner {

    @Autowired
    private DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        log.debug("Debug");
        demoService.run();
    }
}
