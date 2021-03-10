package ru.kpfu.itis.demo.schedule.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.schedule.service.AsyncService;

@Component
public class RunCommand implements CommandLineRunner {

    private final AsyncService asyncService;

    public RunCommand(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello before method");
        asyncService.async();
        System.out.println("Hello after method");
    }
}
